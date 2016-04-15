package me.walkersneps.snepsbotx.chatter;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class BasicChats extends ListenerAdapter{

    public void onGenericMessage (GenericMessageEvent e) {

        String m = e.getMessage().toLowerCase();
        //String time = LocalDateTime.now();

        if (m.contains("hi") | m.contains("yo")) {
            e.respondWith("Yo!");
        }

        if (m.contains("hello")) {
            //if ()
        }




    }



} //end of class
