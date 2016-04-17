package me.walkersneps.snepsbotx.chatter;


import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.canChat;
import static me.walkersneps.snepsbotx.ConfigReader.prefix;

public class ChatToggle extends ListenerAdapter{

    @Override
    public void onGenericMessage (GenericMessageEvent e) throws Exception {

        String message = e.getMessage();

        if (message.startsWith(prefix + "chat ")) {
            String mode = message.split(" ") [1];

            if (mode.equalsIgnoreCase("on")) {
                canChat = true;
                e.respond("I can now chat! How lovely :)");
            } else if (mode.equalsIgnoreCase("off")) {
                canChat = false;
                e.respond("Ok, so you want me to shut up?! Oh, what the fuck you little bitch!");
            }
        }


    }

} //end of class
