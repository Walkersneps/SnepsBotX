package me.walkersneps.snepsbotx.commands;

import me.walkersneps.snepsbotx.reference.CommandMap;
import me.walkersneps.snepsbotx.utils.SnepsUtils;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.botVersion;
import static me.walkersneps.snepsbotx.ConfigReader.masterUser;
import static me.walkersneps.snepsbotx.ConfigReader.prefix;

public class BotInfos extends ListenerAdapter {

    private final SnepsUtils utils = new SnepsUtils();

    @Override
    public void onGenericMessage (GenericMessageEvent e) {

        // useful variables
        String message = e.getMessage();
        String sender = e.getUser().getNick();

        //info
        if (message.equalsIgnoreCase(prefix + "info")) {
            e.respond("Hi! I'm SnepsBotX v." + botVersion + ", the IRC bot developed by Walkersneps! I can do lots of things, some of them are useful, other ones are funny, but most of them are pretty useless! To receive a list of what I can do, please type '" + prefix + "commands' or '" + prefix + "help'.");
            e.respondWith("Have a nice day!");
        }

        // am I the masterUser?
        if (message.equalsIgnoreCase(prefix + "master")){
            e.respond("Currently, my owner is " + masterUser);
            if (sender.equals(masterUser)) { e.respondWith("Which is actually you :-)"); }
        }

        //get help
        if (message.equalsIgnoreCase(prefix + "help")) {
            e.respond("Hi! I'm SnepsBotX, and I'm here to help you (possibly). Send the command '" + prefix + "commands' (without the apostrophes) to receive a list of the commands I can perform.");
        }

        //get command description
        if (message.startsWith(prefix + "help")) {
            String command = message.substring((prefix + "help ").length());
            e.respond(command.toUpperCase() + " --> " + CommandMap.descriptionOf(command));
        }

        //command list
        if (message.equalsIgnoreCase(prefix + "commands")) {
            e.respondWith("The " + utils.intToString(CommandMap.howManyEntries()) + " commands I can execute are the following: " + CommandMap.getCommandList());
        }


        //tips
        if (message.equalsIgnoreCase(prefix + "tips")) {
            e.respondPrivateMessage("-Every commands with a channel as an argument requires you to prepend an # before the channel name.");

        }




    }








}//end of class
