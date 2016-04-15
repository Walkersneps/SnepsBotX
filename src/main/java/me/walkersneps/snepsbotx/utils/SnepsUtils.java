package me.walkersneps.snepsbotx.utils;

import java.io.*;
import java.util.Properties;
import java.util.Random;

public class SnepsUtils {

    public void writeProperty (String filename, String key, String value) {

        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(filename); // prepare the file to write

            prop.setProperty(key, value); // set the properties value

            prop.store(output, null); // save properties to project root folder

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close(); //close the outputStream
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readProperty (String filename, String key) {

        String value = null;

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(filename); //prepare the file to read

            prop.load(input); // load the properties file

            value = prop.getProperty(key); // get the property value

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close(); //close the input stream
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return value; //return the read value

    }

    public int stringToInt (String str){
        return Integer.parseInt(str); //return it
    }

    public char stringToChar (String str) {
        char character;
        character = str.charAt(0); //transform string in character

        return character; //return the obtained char
    }

    public String charToString (char c) {
        return Character.toString(c);
    }

    public String intToString (int i) {
        return Integer.toString(i);
    }

    private int randomNumber(int exclusiveMax) {
        Random rand = new Random();
        return rand.nextInt(exclusiveMax);
    }

    public String stalkExtraction() {

        String stalkSentence;

        int randomizedNumber = randomNumber(5);

        switch (randomizedNumber) {
            case 0: stalkSentence = "Bla Bla Bla";
                break;
            case 1: stalkSentence = "Happy Christmas!";
                break;
            case 2: stalkSentence = "Fag, fAg, faG, FAg, FaG, fAG, FAAAAAAAAG";
                break;
            case 3: stalkSentence = "Yeah, you're right: SuperWalkers is fucking cool!";
                break;
            case 4: stalkSentence = "On the chair the goat sings, under the chair the goat dies";
                break;
            default: stalkSentence = "BRRRRRR extraction errorrrrr!";
                break;
        }


        return stalkSentence;
    }

    public void print (String stringToPrint) {
        System.out.println(stringToPrint);
    }






} //end of class
