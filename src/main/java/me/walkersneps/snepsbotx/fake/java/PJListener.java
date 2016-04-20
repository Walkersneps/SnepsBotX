package me.walkersneps.snepsbotx.fake.java;


import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.prefix;
import static me.walkersneps.snepsbotx.fake.java.KeywordsLists.classes;


public class PJListener extends ListenerAdapter{

    @Override
    public void onGenericMessage(GenericMessageEvent e) throws Exception {

        String message = e.getMessage();

        //create a new object
        if (message.startsWith(prefix + "pjn ")) {
            String creator = message.substring((prefix + "pjn ").length());
            String objectType = creator.substring(0, creator.indexOf(" "));
            String objectName = creator.split(" ") [1];
            
            if (classes.contains(objectType)) {

                Class <?> newClass = Class.forName(objectType);
                Object newObject = newClass.newInstance();

            } else {
                e.respond("Requested class " + objectType + " doesn't exist. Please use one of " + classes.toString() + ".");
            }
        }



        if (message.startsWith(prefix + "pj ")) {
            String firstKeyword = message.substring((prefix + "pj ").length(), message.indexOf("."));
        }



    }

} //end of class
