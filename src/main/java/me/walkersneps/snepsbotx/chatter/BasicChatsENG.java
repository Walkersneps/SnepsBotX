package me.walkersneps.snepsbotx.chatter;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.canChat;

public class BasicChatsENG extends ListenerAdapter{

    public void onGenericMessage (GenericMessageEvent e) {

        if (canChat) {

            String m = e.getMessage().toLowerCase();

            if (m.contains("hi") | m.contains("yo")) {
                e.respondWith("Yo!");
            }

            if (m.contains("hello")) {
                //if ()
            }

            if (m.contains("cool")) {
              e.respondWith("Great bro!");
            }


        }
    }



} //end of class
