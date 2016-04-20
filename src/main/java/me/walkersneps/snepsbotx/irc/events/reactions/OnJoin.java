package me.walkersneps.snepsbotx.irc.events.reactions;


import me.walkersneps.snepsbotx.reference.Channels;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;

import static me.walkersneps.snepsbotx.ConfigReader.actualBotName;

public class OnJoin extends ListenerAdapter{

    @Override
    public void onJoin(JoinEvent e) throws Exception {

        if (e.getUser().getNick().equals(actualBotName)) {

            Channels.removeChannel(e.getChannel().getName());
        }



    }

} //end of class
