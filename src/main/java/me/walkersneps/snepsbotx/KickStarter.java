package me.walkersneps.snepsbotx;


import me.walkersneps.snepsbotx.gui.MainGUI;

import java.awt.*;

public class KickStarter {

    private static boolean dontUseGui = false;


    public static void main (String[] args) {

        //arguments checker
        for (String arg : args) { //in the arguments given when calling the program...
            if (arg.contains("nogui")) { //if I call 'nogui'
                dontUseGui = true;
            }
        }

        if (!GraphicsEnvironment.isHeadless()) { //if we have a graphic environment and we're not headless
            if (!dontUseGui) { //if we want to use the GUI
                //new GUI();
                new MainGUI();
                System.out.println("Using GUI");
            }
        }

        ConfigReader.initialize(); //read the variables set in the config file

        new SnepsBotX(); //Let's go!

    }




}//end of class
