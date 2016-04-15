package me.walkersneps.snepsbotx.IRCEventsReactions;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.KickEvent;

import static me.walkersneps.snepsbotx.ConfigReader.botName;

/**
 * @deprecated
 * It doesn't work: for some reason it just loops in a strange way and quits the process
 */

public class OnKick extends ListenerAdapter{

    public void onKick (KickEvent e) throws InterruptedException {

        if (e.getRecipient().getNick().equals(botName)) {

            String channel = e.getChannel().toString();

            Thread.sleep(500);

            e.getBot().sendIRC().joinChannel(channel);

            Thread.sleep(600);

            e.getBot().sendIRC().message(channel, "Ah-Ha! You thought you could get rid of me, but nobody can win over me MUAHAHAHAHAHAHAHAA!");

        }
    }


}//end of class
