package me.walkersneps.snepsbotx.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.masterUser;
import static me.walkersneps.snepsbotx.ConfigReader.prefix;


public class IRCMovements extends ListenerAdapter {

    @Override
    public void onMessage(MessageEvent e) throws Exception {

        String message = e.getMessage();
        String sender = e.getUser().getNick();


        //join specified private channel
        if (message.startsWith(prefix + "joink")) {
            String cToJoin = message.split(" ")[1];
            String key = message.split(" ")[2];
            e.respond("I'll now join channel " + cToJoin + " with key '" + key + "'.");
            e.getBot().sendIRC().joinChannel(cToJoin, key);
            e.getBot().send().message(cToJoin, "Hello everyone!");
        }


        //join specified channel
        if (message.startsWith(prefix + "join")) {
            String cToJoin = message.split(" ") [1];
            e.respond("I'm joining channel " + cToJoin + " now.");
            e.getBot().sendIRC().joinChannel(cToJoin);
            e.getBot().send().message(cToJoin, "Hello everyone!");
        }


        //part current channel
        if (message.equalsIgnoreCase(prefix + "leave")) {
            if (sender.equals(masterUser)) {
                e.respondWith("Goodbye everyone!");
                e.getChannel().send().part();
            } else {
                e.respond("No sir");
            }
        }


        //part specified channel
        if (message.startsWith(prefix + "part ")) {
            String channelToLeave = message.split(" ") [1];
            e.getBot().send().message(channelToLeave, "Goodbye everyone!");
            e.getBot().sendRaw().rawLine("PART " + channelToLeave);
            e.respond("I've just left channel #" + channelToLeave);
        }


        //part and rejoin current channel
        if (message.equalsIgnoreCase(prefix + "cycle")){
            e.respond("OK sir");
            e.getChannel().send().cycle();
        }


    }

}//end of class













