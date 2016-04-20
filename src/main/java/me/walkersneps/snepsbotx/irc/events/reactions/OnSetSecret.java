package me.walkersneps.snepsbotx.irc.events.reactions;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.SetSecretEvent;

public class OnSetSecret extends ListenerAdapter{

    @Override
    public void onSetSecret(SetSecretEvent e) throws Exception {

        String chan = e.getChannel().toString();

        e.getBot().sendIRC().message(chan, "Ah-ha! So now we can do our super secret stuff without anyone knowing, uh?");

    }

}//end of class