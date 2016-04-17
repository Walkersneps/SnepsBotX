package me.walkersneps.snepsbotx;

import me.walkersneps.snepsbotx.reference.CommandMap;
import me.walkersneps.snepsbotx.utils.SnepsUtils;
import static me.walkersneps.snepsbotx.SnepsBotX.CONFIG_FILE;

public class ConfigReader {

    public static String masterUser;
    public static String botVersion;
    public static String consoleChannel;
    public static String defaultBotName;
    public static String actualBotName;
    public static String password;
    public static char prefix;
    public static boolean canSpam = false;
    public static boolean canStalk = false;
    public static boolean canChat = false;

    private static final SnepsUtils u = new SnepsUtils();


    static void initialize () {

        u.print("Starting initialization routine!");

        loadConfigs();

        loadCommandsHashmap();

        u.print("Initialization routine completed!");

    }


    private static void loadCommandsHashmap() {

        u.print("Loading command hashmap...");
        CommandMap.loadCommandsOnStartup(); //load the commands hashmap!
        System.out.println("Loaded command hashmap!");

    }

    private static void loadConfigs() {

        u.print("Starting reading configuration file NOW!");

        String serverHostname = u.readProperty(CONFIG_FILE, "serverHostname");
        u.print("Read server hostname is: " + serverHostname + "!");

        masterUser = u.readProperty(CONFIG_FILE, "masterUser"); //read who is the masterUser
        u.print("Read master user is: '" + masterUser + "'.");

        botVersion = u.readProperty(CONFIG_FILE, "botVersion");
        u.print("Read bot version is: " + botVersion + ".");

        defaultBotName = u.readProperty(CONFIG_FILE, "botName");
        actualBotName = defaultBotName;
        u.print("Read bot name is: " + defaultBotName + ".");

        consoleChannel = u.readProperty(CONFIG_FILE, "consoleChannel");
        u.print("Read console channel is: #" + consoleChannel + ".");

        password = u.readProperty(CONFIG_FILE, "NickServPassword");
        u.print("Read NickServ password (Psst: it's a secret!).");

        prefix = u.stringToChar(u.readProperty(CONFIG_FILE, "prefix"));
        u.print("Read prefix is: '" + prefix + "'.");


        canSpam = Boolean.parseBoolean(u.readProperty(CONFIG_FILE, "canSpam"));
        canStalk = Boolean.parseBoolean(u.readProperty(CONFIG_FILE, "canStalk"));
        canChat = Boolean.parseBoolean(u.readProperty(CONFIG_FILE, "canChat"));
        u.print("Read toggles are (SPAM/STALK/DUMB): " + canSpam + "/" + canStalk + "/" + canChat + " .");

        u.print("Done extracting variables from config file at " + CONFIG_FILE + "!");

    }


} //end of class
