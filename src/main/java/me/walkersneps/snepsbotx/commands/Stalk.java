package me.walkersneps.snepsbotx.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.ArrayList;

import static me.walkersneps.snepsbotx.ConfigReader.prefix;

public class Stalk extends ListenerAdapter {

    public static ArrayList<String> stalkingPeople = new ArrayList<>(3);

    @Override
    public void onGenericMessage (GenericMessageEvent e) {

        String message = e.getMessage();

        //stalk functions
        if (message.startsWith(prefix + "stalk")) {
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
                e.respond("Wrong arguments. Use 'start' or 'stop'");
            }
        }

        //stalk list
        if (message.equalsIgnoreCase(prefix + "stalklist")) {
            e.respondWith("I'm currently stalking " + stalkingPeople.toString());
        }
    }

}//end of class
