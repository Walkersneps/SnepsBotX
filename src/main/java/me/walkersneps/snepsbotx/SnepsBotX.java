package me.walkersneps.snepsbotx;

import me.walkersneps.snepsbotx.chatter.BasicChatsENG;
import me.walkersneps.snepsbotx.chatter.ChatToggle;
import me.walkersneps.snepsbotx.commands.*;
import me.walkersneps.snepsbotx.irc.events.reactions.*;
import me.walkersneps.snepsbotx.utils.SnepsUtils;
import me.walkersneps.snepsbotx.working.cycles.StalkCycle;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import java.io.IOException;

public class SnepsBotX {

    // #-#-#-# EDITABLE VARIABLES #-#-#-#
    public static final String CONFIG_FILE = "config.properties";
    public static final String COMMANDS_FILE = "commands.properties";




    private static PircBotX bot;


    SnepsBotX() {

        SnepsUtils property = new SnepsUtils(); //create a SnepsUtils instance, I'll need it to get the configurations from the CONFIG_FILE

        //my configuration builder
        Configuration myConfig = new Configuration.Builder()
                .setName(property.readProperty(CONFIG_FILE, "botName")) //Set nick
                .setLogin(property.readProperty(CONFIG_FILE, "botName"))
                .addServer(property.readProperty(CONFIG_FILE, "serverHostname"), property.stringToInt(property.readProperty(CONFIG_FILE, "serverPort"))) //set server hostname and port
                .setNickservPassword(property.readProperty(CONFIG_FILE, "NickServPassword")) //NickServ password
                .addAutoJoinChannel(property.readProperty(CONFIG_FILE, "defaultChannel")) //set autoJoin channel(s)
                .setMessageDelay(property.stringToInt(property.readProperty(CONFIG_FILE, "messageDelay")))

                //ALL MY LOVELY LISTENERS
                // Commands listeners
                .addListener(new BotInfos())
                .addListener(new Prefix())
                .addListener(new Bash())
                .addListener(new SendMessage())
                .addListener(new TestCommands())
                .addListener(new IRCCommands())
                .addListener(new IRCMovements())
                .addListener(new Spam())
                .addListener(new Stalk())
                .addListener(new ChatToggle())
                .addListener(new LastfmCommands())

                // fake.java listeners
                //.addListener(new PJListener())

                // IRCEventsReactions listeners
                .addListener(new OnInvite())
                .addListener(new OnKick())
                .addListener(new OnJoin())
                .addListener(new OnPart())
                .addListener(new OnSetSecret())
                .addListener(new OnUnknown())

                // chatter listeners
                .addListener(new BasicChatsENG())

                // working.cycles listeners
                .addListener(new StalkCycle())

                .buildConfiguration(); //build it!


        bot = new PircBotX(myConfig); //give him the configs

        try {
            bot.startBot(); //start the bot
        } catch (IOException | IrcException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage (String target, String message) {
        bot.send().message(target, message);
    }

    public static void join (String channel) {
        bot.sendIRC().joinChannel(channel);
    }

    public static void part (String channel) {
        bot.sendRaw().rawLine("PART " + channel);
    }



} //end of class
