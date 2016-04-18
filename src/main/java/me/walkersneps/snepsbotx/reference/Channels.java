package me.walkersneps.snepsbotx.reference;


import java.util.List;

public class Channels {

    public static List<String> channels;


    public static List <String> getChannels () {
        return channels;
    }


    public static void removeChannel (String channel) {
        channels.remove(channel);
    }


    public static void addChannel (String channel) {
        channels.add(channel);
    }




} //end of class
