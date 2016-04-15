package me.walkersneps.snepsbotx.commands;

import me.walkersneps.snepsbotx.utils.SnepsUtils;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.masterUser;
import static me.walkersneps.snepsbotx.SnepsBotX.COMMANDS_FILE;

public class CommandRegistration extends ListenerAdapter {

    private static SnepsUtils utils = new SnepsUtils();

    private boolean listeningForCommandDescription = false;
    private boolean listeningForEncodingAnswer = false;

    private String newcommand;
    private String newdescription;


    @Override
    public void onPrivateMessage(PrivateMessageEvent e) {

        //useful variables
        String sender = e.getUser().getNick(); //sender
        String message = e.getMessage(); //message

        //command registration
            if (sender.equalsIgnoreCase(masterUser)) {
                if (listeningForEncodingAnswer) {
                    if (message.equalsIgnoreCase("yes")) {
                        e.respond("Perfect! Let's save it!");

                        utils.writeProperty(COMMANDS_FILE, newcommand, newdescription);

                        //reset waiting statuses
                        listeningForEncodingAnswer = false;
                        listeningForCommandDescription = false;

                        e.respond("Everything went all right! YAY!");


                    } else if (message.equalsIgnoreCase("no")) {
                        e.respond("Please, send again the command description or send 'abort' to stop the registration process");
                        listeningForEncodingAnswer = false;

                    } else if (message.equalsIgnoreCase("abort")) {
                        listeningForCommandDescription = false;
                        listeningForEncodingAnswer = false;
                        e.respond("Command registration aborted!");

                    } else {
                        e.respond("Please answer with 'yes' or 'no' or 'abort' (without the apostrophes).");
                    }

                } else if (listeningForCommandDescription) {
                    newdescription = message;
                    e.respond("Should I save command '" + newcommand + "' with description '" + newdescription + "'? [yes/no]");
                    listeningForEncodingAnswer = true;

                } else if (message.startsWith("newcommand")) {
                        newcommand = message.substring(("newcommand ").length());
                        listeningForCommandDescription = true;
                        e.respond("I'm now listening for this command's description!");
                }

            } //if sender isn't masterUser
             else {
                e.respond("Access denied");
            }


    } //end of 'onPrivateMessage' void




} //end of class