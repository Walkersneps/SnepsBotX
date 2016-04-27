package me.walkersneps.snepsbotx;

import me.walkersneps.sneps.utils.property.PropertyReader;
import me.walkersneps.snepsbotx.reference.CommandMap;
import me.walkersneps.sneps.utils.lazy.*;

import static me.walkersneps.sneps.utils.convert.PrimitiveConverter.stringToChar;
import static me.walkersneps.snepsbotx.SnepsBotX.CONFIG_FILE;

public class ConfigReader {

    public static String masterUser;
    public static String botVersion;
    public static String consoleChannel;
    public static String defaultBotName;
    public static String actualBotName;
    public static String password;
    public static String fmKey;
    public static String fmUser;
    //public static String waKey;
    public static char prefix;
    public static boolean canSpam = false;
    public static boolean canStalk = false;
    public static boolean canChat = false;

    private static final Aliases u = new Aliases();
    private static final PropertyReader property = new PropertyReader(CONFIG_FILE);


    static void initialize () {

        u.p("");
        u.p("Starting initialization routine!");

        loadConfigs();

        loadCommandsHashmap();

        u.p("Initialization routine completed!");
        u.p("");

    }


    private static void loadCommandsHashmap() {

        u.p("Loading command hashmap...");
        CommandMap.loadCommandsOnStartup(); //load the commands hashmap!
        u.p("Loaded command hashmap!");
        u.p("");

    }

    private static void loadConfigs() {

        u.p("Starting reading configuration file NOW!");

        String serverHostname = property.readProperty("serverHostname");
        u.p("Read server hostname is: " + serverHostname + "!");

        masterUser = property.readProperty("masterUser"); //read who is the masterUser
        u.p("Read master user is: '" + masterUser + "'.");

        botVersion = property.readProperty("botVersion");
        u.p("Read bot version is: " + botVersion + ".");

        defaultBotName = property.readProperty("botName");
        actualBotName = defaultBotName;
        u.p("Read bot name is: " + defaultBotName + ".");

        consoleChannel = property.readProperty("consoleChannel");
        u.p("Read console channel is: #" + consoleChannel + ".");

        password = property.readProperty("NickServPassword");
        u.p("Read NickServ password (Psst: it's a secret!).");

        prefix = stringToChar(property.readProperty("prefix"));
        u.p("Read prefix is: '" + prefix + "'.");

        fmUser = property.readProperty("lastfmUser");
        fmKey = property.readProperty("lastfmKey");
        u.p("Read last.fm data are: user-> " + fmUser + "; key-> " + fmKey + ".");

        //waKey = u.readProperty("wolframKey");
        //u.p("Read Wolfram Alpha AppID is: " + waKey);


        canSpam = Boolean.parseBoolean(property.readProperty("canSpam"));
        canStalk = Boolean.parseBoolean(property.readProperty("canStalk"));
        canChat = Boolean.parseBoolean(property.readProperty("canChat"));
        u.p("Read toggles are (SPAM/STALK/DUMB): " + canSpam + "/" + canStalk + "/" + canChat + " .");

        u.p("Done extracting variables from config file at " + CONFIG_FILE + "!");
        u.p("");

    }


} //end of class
