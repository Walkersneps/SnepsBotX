package me.walkersneps.snepsbotx.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.masterUser;
import static me.walkersneps.snepsbotx.ConfigReader.prefix;


public class SendMessage extends ListenerAdapter {

    @Override
    public void onGenericMessage(GenericMessageEvent e) throws Exception {

        if (e.getMessage().toLowerCase().startsWith(prefix + "send")) {
            if (e.getUser().getNick().equals(masterUser)) {
                String receiver = e.getMessage().split(" ") [1];
                String message = e.getMessage().substring((prefix + "send " + receiver + " ").length());

                e.getBot().sendIRC().message(receiver, message);

                e.respond("Message sent!");

            } else {
                e.respondWith("Access denied: must be bot's owner!");
            }

        }

    }

}//end of class