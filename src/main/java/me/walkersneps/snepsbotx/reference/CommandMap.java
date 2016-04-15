package me.walkersneps.snepsbotx.reference;

import java.util.LinkedHashMap;

public class CommandMap {

    private static LinkedHashMap<String, String> c = new LinkedHashMap<>();

    public static void loadCommandsOnStartup () {

        c.put("bash", "Syntax: bash <command> (executes a shell command).");
        c.put("figlet", "Syntax: figlet <text> (makes the inserted text an ASCII art).");
        c.put("spamhere", "Syntax: spamhere <times> <text> (sends a text a specified number of times on the same channel it was casted on).");
        c.put("spam", "Syntax: spam <times> <user> <text> (sends a text a specified amount of times to a specified victim ;) ).");
        c.put("stalk", "Syntax: stalk {start/stop} <user> (adds the specified user to the list of the being stalked people, which is pretty bad for them! ;-) )");
        c.put("stalklist", "Syntax: stalklist (returns the list of people being stalked)");
        c.put("test", "Syntax: test (just answers in a silly way).");
        c.put("info", "Syntax: info (get some information about me!).");
        c.put("prefix", "Syntax: prefix (displays current prefix, call it without the prefix itself!).");
        c.put("newprefix", "Syntax: newprefix <prefix> (changes the commands prefix).");
        c.put("master", "Syntax: master (displays who my owner is! :)).");
        c.put("help", "Syntax: help [command] (gives help on a specified command; if casted without any argument, it sends an helpful message).");
        c.put("commands", "Syntax: commands (lists every command I can execute).");
        c.put("whoami", "Syntax: whoami (replies with the caster's nickname).");
        c.put("writetest", "Syntax: writetest (writes a test property in the bot's configuration file, creating it if it's not present; only useful in debugging).");
        c.put("newcommand", "Syntax: newcommand <command> (deprecated way to add commands descriptions to a list like this).");


    }

    public static String descriptionOf (String key) {
        if (c.containsKey(key)) {
            return c.get(key);
        } else { return "No entries could be found for the requested command ;("; }
    }

    public static int howManyEntries () {
        return c.size();
    }

    public static String getCommandList () {
        return (c.keySet()).toString();
    }




} //end of 'commands' class
