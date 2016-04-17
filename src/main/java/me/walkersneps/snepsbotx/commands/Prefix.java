package me.walkersneps.snepsbotx.commands;

import me.walkersneps.snepsbotx.utils.SnepsUtils;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.masterUser;
import static me.walkersneps.snepsbotx.ConfigReader.prefix;

public class Prefix extends ListenerAdapter{

    private final SnepsUtils utils = new SnepsUtils();

    @Override
    public void onGenericMessage (GenericMessageEvent e) {

        // useful variables
        String message = e.getMessage();
        String sender = e.getUser().getNick();

        //get prefix
        if (message.contains("prefix")) {
            e.respond("Current prefix is '" + utils.charToString(prefix) + "'.");
        }

        // new prefix
        if (message.startsWith(prefix + "newprefix")) {
            if (sender.equals(masterUser)) { //check permission

                String newprefix = message.split(" ")[1]; //split the command to get the new prefix

                int prefixLength = newprefix.length(); //let's see how long the prefix is

                if (prefixLength == 1) { // check prefix length
                    prefix = utils.stringToChar(newprefix);
                    e.respond("Done! New prefix is: '" + prefix + "'.");
                } else {
                    e.respond("Warning! Prefix can only be 1 character long!");
                }
            } else { e.respond("Access denied!"); }

        }
    }
}
