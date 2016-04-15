package me.walkersneps.snepsbotx;

import me.walkersneps.snepsbotx.Mechs.ConfigReader;
import me.walkersneps.snepsbotx.commands.*;
import me.walkersneps.snepsbotx.utils.SnepsUtils;
import me.walkersneps.snepsbotx.workingCycles.StalkCycle;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import java.io.IOException;

public class SnepsBotX {

    // #-#-#-# EDITABLE VARIABLES #-#-#-#
    public static final String CONFIG_FILE = "config.properties";
    public static final String COMMANDS_FILE = "commands.properties";



    // #-#-#-# PROGRAM STARTS HERE #-#-#-#

    public static void main (String[] args) {

        ConfigReader.initialize(); //read the variables set in the config file

        new SnepsBotX(); //Let's go!

    }


    private SnepsBotX() {

        SnepsUtils property = new SnepsUtils(); //create a SnepsUtils instance, I'll need it to get the configurations from the CONFIG_FILE

        //my configuration builder
        Configuration myConfig = new Configuration.Builder()
                .setName(property.readProperty(CONFIG_FILE, "botName")) //Set nick
                .setLogin(property.readProperty(CONFIG_FILE, "botName"))
                .addServer(property.readProperty(CONFIG_FILE, "serverHostname"), property.stringToInt(property.readProperty(CONFIG_FILE, "serverPort"))) //set server hostname and port
                .setNickservPassword(property.readProperty(CONFIG_FILE, "nickServPassword")) //NickServ password
                .addAutoJoinChannel(property.readProperty(CONFIG_FILE, "defaultChannel")) //set autoJoin channel(s)
                .setMessageDelay(property.stringToInt(property.readProperty(CONFIG_FILE, "messageDelay")))
                .addListener(new BotInfos()) //ALL MY LOVELY LISTENERS
                .addListener(new Prefix())
                .addListener(new Bash())
                .addListener(new TestCommands())
                .addListener(new Spam())
                .addListener(new Stalk())
                .addListener(new CommandRegistration())
                .addListener(new StalkCycle())
                .buildConfiguration(); //build it!

        PircBotX bot = new PircBotX(myConfig); //give him the configs

        try {
            bot.startBot(); //start the bot
        } catch (IOException | IrcException e) {
            e.printStackTrace();
        }
    }



} //end of class
