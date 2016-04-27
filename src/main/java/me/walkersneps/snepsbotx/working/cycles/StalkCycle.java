package me.walkersneps.snepsbotx.working.cycles;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.canStalk;
import static me.walkersneps.snepsbotx.commands.Stalk.stalkingPeople;
import static me.walkersneps.snepsbotx.utils.StalkExtraction.nextSentence;


public class StalkCycle extends ListenerAdapter {

    @Override
    public void onGenericMessage (GenericMessageEvent e) {

        String sender = e.getUser().getNick();

        //stalk cycle
        if (canStalk) {
            String senderup = sender.toUpperCase();
            //System.out.println("Uppercase sender nick is: " + senderup);
            if (stalkingPeople.contains(senderup)) {
                System.out.println("extracting stalkSentence...");
                String stalkSentence = nextSentence();
                e.respond(stalkSentence);
            }
        }

    }

}//end of class
