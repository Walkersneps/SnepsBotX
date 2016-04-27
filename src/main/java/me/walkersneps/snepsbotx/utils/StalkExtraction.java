package me.walkersneps.snepsbotx.utils;

/**
 * Created by Walkersneps on 27/04/16
 * in package me.walkersneps.snepsbotx.utils
 * for SnepsBotX
 */


import static me.walkersneps.sneps.utils.random.Randomizer.randomNumber;

/**
 * @author Walkersneps
 */
public class StalkExtraction {


    public static String nextSentence () {

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


} //end of class
