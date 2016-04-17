package me.walkersneps.snepsbotx.IRCEventsReactions;

import me.walkersneps.snepsbotx.utils.SnepsUtils;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.InviteEvent;

public class OnInvite extends ListenerAdapter {

    private final SnepsUtils u = new SnepsUtils();

    @Override
    public void onInvite(InviteEvent e) {

        u.print("Received an InviteEvent from " + e.getUser().getNick() + " to join #" + e.getChannel() + ". Joining it now!");

        e.getBot().sendIRC().message(e.getUser().getNick(), "Thanks for inviting me to your wonderful secret party! I'm joining right now!");
        e.getBot().sendIRC().joinChannel(e.getChannel());
        e.getBot().sendIRC().message(e.getChannel(), "Hello everyone!");

    }

}//end of class
