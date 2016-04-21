package me.walkersneps.snepsbotx.commands;


import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.*;

public class Spam extends ListenerAdapter {

    @Override
    public void onGenericMessage (GenericMessageEvent e) {

        String message = e.getMessage();


        //canSpam toggle
        if (message.startsWith(prefix + "spams ")) {
            String mode = message.split(" ") [1];
            if (mode.equalsIgnoreCase("on")) {
                canSpam = true;
                e.respondWith("Spam functions are now enabled, wuhuuu!");
            } else if (mode.equalsIgnoreCase("off")) {
                canSpam = false;
                e.respondWith("Spam functions are now disabled, die you little spammer motherfucker!");
            } else {
                e.respond("Wrong arguments. Please use 'on' or 'off'.");
            }
        }

        //channel spam
        if (message.startsWith(prefix + "spamhere")) {
            if (canSpam) {
                String timesToSpam = message.split(" ")[1];
                String textToSpam = message.substring((prefix + "spamhere " + timesToSpam + " ").length());
                int Amount;
                Amount = Integer.parseInt(timesToSpam);
                Amount++;
                do {
                    e.respondWith(textToSpam);
                    Amount--;
                } while (Amount != 1);
            }
        }


        //personal spam
        if (message.startsWith(prefix + "spam")) {
            if (canSpam) {
                String timesToSpam = message.split(" ")[1];
                String userToSpam = message.split(" ")[2];
                String textToSpam = message.substring((prefix + "spam " + timesToSpam + " " + userToSpam + " ").length());
                if (userToSpam.equalsIgnoreCase(masterUser)) {
                    e.respond("Dude, do you really think I would've let you do that?! You can't kill " + masterUser + " with its own gun!");
                } else {
                    e.respond("I'll now spam " + userToSpam + " for " + timesToSpam + " times, saying " + textToSpam);
                    int amount = Integer.parseInt(timesToSpam);

                    for (int a=0; a<amount; a++) {
                        e.getBot().send().message(userToSpam, textToSpam);
                    }

                    e.respond("Spam operation successfully executed ;-)");

                }

            }else{
                e.respond("Spam functions are disabled, ask SuperWalkers to enable them");
            }
        }


    }




}//end of class
