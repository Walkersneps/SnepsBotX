package me.walkersneps.snepsbotx.irc.events.reactions;


import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.UnknownEvent;

import static me.walkersneps.snepsbotx.ConfigReader.consoleChannel;
import static me.walkersneps.snepsbotx.ConfigReader.masterUser;

public class OnUnknown extends ListenerAdapter{

    @Override
    public void onUnknown(UnknownEvent e) throws Exception {

        System.out.println("WARNING! Received the following unknown line from the IRC server: " + e.getLine());
        e.getBot().sendIRC().message(consoleChannel, "Warning! Received the following unknown line from the IRC server: " + e.getLine());

    }
}//end of class