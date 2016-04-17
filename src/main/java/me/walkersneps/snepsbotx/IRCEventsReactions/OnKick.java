package me.walkersneps.snepsbotx.IRCEventsReactions;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.KickEvent;

import static me.walkersneps.snepsbotx.ConfigReader.actualBotName;


public class OnKick extends ListenerAdapter {

    public void onKick (KickEvent e) throws InterruptedException {

        if (e.getRecipient().getNick().equals(actualBotName)) {

            String channel = e.getChannel().getName();

            Thread.sleep(500);

            e.getBot().sendIRC().joinChannel(channel);

            Thread.sleep(600);

            e.getBot().sendIRC().message(channel, "Ah-Ha! You thought you could get rid of me, but nobody can win over me MUAHAHAHAHAHAHAHAA!");

        }
    }


}//end of class
