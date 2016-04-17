package me.walkersneps.snepsbotx.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.ArrayList;

import static me.walkersneps.snepsbotx.ConfigReader.canStalk;
import static me.walkersneps.snepsbotx.ConfigReader.prefix;

public class Stalk extends ListenerAdapter {

    public static final ArrayList<String> stalkingPeople = new ArrayList<>(3);

    @Override
    public void onGenericMessage (GenericMessageEvent e) {

        String message = e.getMessage();

        //stalk list
        if (message.equalsIgnoreCase(prefix + "stalklist")) {
            e.respondWith("I'm currently stalking " + stalkingPeople);
        }

        //canStalk toggle
        if (message.startsWith(prefix + "stalks ")) {
            String mode = message.split(" ")[1];
            if (mode.equalsIgnoreCase("on")) {
                canStalk = true;
                e.respondWith("I'm now allowed to stalk people on command ;)");

            } else if (mode.equalsIgnoreCase("off")) {
                canStalk = false;
                e.respondWith("I won't stalk people anymore (what a pity!), I promise!");

            } else {
                e.respond("Wrong arguments. Please use 'on' or 'off'.");
            }
        }

        //stalk functions
        if (message.startsWith(prefix + "stalk ")) {
            String stalkMode = message.split(" ")[1];
            String toStalkNowTemp = message.split(" ")[2];
            String toStalkNow = toStalkNowTemp.toUpperCase();
            if (stalkMode.equalsIgnoreCase("start")) {

                if (stalkingPeople.size() == 3) {
                    e.respond("Warning! I'm already stalking 3 people, please remove one from the list with '" + prefix + "stalk stop <user>'.");
                } else {
                    stalkingPeople.add(toStalkNow);
                    e.respond("I'm now stalking " + stalkingPeople);
                }

            } else if (stalkMode.equalsIgnoreCase("stop")) {
                stalkingPeople.remove(toStalkNow);
                e.respond("I won't stalk " + toStalkNow + " anymore.");

            } else {
                e.respond("Wrong arguments. Please use 'start' or 'stop'.");
            }
        }

    } //end of onGenericMessage

}//end of class
