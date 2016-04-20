package me.walkersneps.snepsbotx.irc.events.reactions;


import me.walkersneps.snepsbotx.reference.Channels;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;

import static me.walkersneps.snepsbotx.ConfigReader.actualBotName;

public class OnPart extends ListenerAdapter{

    @Override
    public void onJoin(JoinEvent e) throws Exception {

        if (e.getUser().getNick().equals(actualBotName)) {

            Channels.addChannel(e.getChannel().getName());

        }



    }

} //end of class
