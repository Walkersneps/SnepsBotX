package me.walkersneps.snepsbotx.commands;


import me.walkersneps.snepsbotx.utils.ExecuteBashCommand;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static me.walkersneps.snepsbotx.ConfigReader.prefix;

public class Bash extends ListenerAdapter {

    private ExecuteBashCommand bash = new ExecuteBashCommand();

    private boolean figletMuted = false;

    private void doFigletCooldown() {
        figletMuted = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                figletMuted = false;
            }
        }, 15000); // 3 second wait
    }

    @Override
    public void onGenericMessage (GenericMessageEvent e) {

        String message = e.getMessage();

        //bash command
        if (message.startsWith(prefix + "bash")) {
            String commandToExecute = message.substring((prefix + "bash ").length());
            List<String> outputLines = bash.executeCommand(commandToExecute);
            for (String nowSending : outputLines) {
                e.respondWith(nowSending);
            }
        }

        //figlet
        if (message.startsWith(prefix + "figlet")) {
            if (!figletMuted) {
                //String dump = null;
                String executing = message.substring((prefix + "figlet ").length());
                if (executing.length() >= 20) {
                    e.respond("Abort: you're message was " + executing.length() + " characters long, but max allowed lenght is 19; please shrink down you're message :-) !");
                } else if (executing.length() < 20) {
                    String cmd = "figlet " + executing;
                    List<String> outputLines = bash.executeCommand(cmd);
                    for (String nowSending : outputLines) {
                        e.respondWith(nowSending);
                    }
                    doFigletCooldown();
                }

            } else {
                    e.respond("This command was recently performed! Please wait!");
            }

        }

    }

}//end of class
