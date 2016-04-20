package me.walkersneps.snepsbotx;

import me.walkersneps.snepsbotx.gui.MainGUI;

import java.awt.*;

public class KickStarter {

    private static boolean dontUseGui = false;
    private static boolean dontStartBot = false;


    public static void main (String[] args) {

        //arguments checker
        for (String arg : args) {

            //check if argument 'nogui' was passed
            if (arg.equalsIgnoreCase("nogui")) { //if I call 'nogui'
                dontUseGui = true;
            }

            //check if argument 'nobot' was passed
            if (arg.equalsIgnoreCase("nobot")) {
                dontStartBot = true;
            }
        } //end of arguments check

        //if we're launching the app from a headless server, don't start the GUI anyway
        if (!GraphicsEnvironment.isHeadless()) { //if we have a graphic environment and we're not headless
            if (!dontUseGui) { //if we want to use the GUI
                new MainGUI();
                System.out.println("Using GUI");
            }
        }


        ConfigReader.initialize(); //read the variables set in the config file


        if (!dontStartBot) {
            new SnepsBotX(); //Let's go!
        } else { System.out.println("Not starting the bot!"); }

    }




}//end of class
