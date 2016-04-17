package me.walkersneps.snepsbotx.commands;


import me.walkersneps.snepsbotx.utils.SnepsUtils;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.masterUser;
import static me.walkersneps.snepsbotx.ConfigReader.prefix;
import static me.walkersneps.snepsbotx.SnepsBotX.CONFIG_FILE;

public class TestCommands extends ListenerAdapter {

    private final SnepsUtils utils = new SnepsUtils();

    @Override
    public void onGenericMessage (GenericMessageEvent e) {

        String sender = e.getUser().getNick();

        // send a test message
        if (e.getMessage().equalsIgnoreCase(prefix + "test")) {
            e.respond("Ciao bello! ;-)");
        }

        //whoami
        if (e.getMessage().equalsIgnoreCase(prefix + "whoami")) {
            e.respond("You are " + sender + ", indeed!");
        }

        //write a test .property file to find out where it goes
        if (e.getMessage().equalsIgnoreCase(prefix + "writetest")) {
            if (sender.equals(masterUser)) {
                e.respond("Writing a " + CONFIG_FILE + "...");
                utils.writeProperty(CONFIG_FILE, "test", "I'm a test");
                e.respond("Done!");
            } else { e.respond("Access denied!"); }
        }

    }

} //end of class
