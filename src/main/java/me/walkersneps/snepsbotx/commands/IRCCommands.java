package me.walkersneps.snepsbotx.commands;


import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.*;

public class IRCCommands extends ListenerAdapter{

    @Override
    public void onMessage (MessageEvent e) throws Exception {

        String message = e.getMessage();
        String sender = e.getUser().getNick();

        //nick change
        if (message.startsWith(prefix + "nick")) {
            if (sender.equals(masterUser)) {
                String newnick = message.split(" ")[1];
                e.respondWith("As you wish, my master");
                e.getBot().sendIRC().changeNick(newnick);
            } else {
                e.respond("You little bitch can't change me!");
            }
        }

        //set nick back to the one specified in the config file
        if (message.startsWith(prefix + "resetnick")) {
            if (sender.equals(masterUser)) {
                e.respondWith("I'm glad you want to let me be my true self :-)");
                e.getBot().sendIRC().changeNick(botName);
            } else {
                e.respond("Nope");
            }
        }

        // /me commands
        if (message.startsWith(prefix + "act")) {
            if (sender.equals(masterUser)) {
                String where = message.split(" ") [1];
                String action = message.substring((prefix + "act " + where + " ").length());
                e.getBot().sendIRC().action(where, action);
            } else {
                e.respond("You sure can't tell me what to do >:( ");
            }
        }

        //identify with nickserv
        if (message.equalsIgnoreCase(prefix + "identify")) {
            e.getBot().sendIRC().identify(password);
            e.respond("I should now be identified!");
        }


    }





} //end of class













