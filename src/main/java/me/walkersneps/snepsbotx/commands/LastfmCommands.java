package me.walkersneps.snepsbotx.commands;


import me.walkersneps.snepsbotx.utils.Lastfm;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import static me.walkersneps.snepsbotx.ConfigReader.fmUser;
import static me.walkersneps.snepsbotx.ConfigReader.prefix;

public class LastfmCommands extends ListenerAdapter{

    private final Lastfm fm = new Lastfm();

    @Override
    public void onGenericMessage(GenericMessageEvent e) throws Exception {

        String message = e.getMessage();

        //latest scrobbled song of masterUser
        if (message.equalsIgnoreCase(prefix + "fm")) {

            //let's get the latest scrobbled song
            String[] latestScrobble = fm.getLatestTrack(fmUser);

            //retrieve the individual data of the song from the array we got
            String song = latestScrobble[0];
            String album = latestScrobble[1];
            String artist = latestScrobble[2];

            e.respondWith("Latest " + fmUser + "'s " + "scrobble: '" + song + "' by " + artist + " in '" + album + "'."); //answer

        }


        //latest scrobbled song of a specified user
        if (message.startsWith(prefix + "lastfm ")) {

            String user = message.split(" ") [1];

            String[] latestScrobble = fm.getLatestTrack(user);

            //retrieve the individual data of the song from the array we got
            String song = latestScrobble[0];
            String album = latestScrobble[1];
            String artist = latestScrobble[2];

            e.respondWith("Latest song scrobbled by " + user + ": '" + song + "' by " + artist + " in '" + album + "'."); //answer

        }


        //Top song
        if (message.startsWith(prefix + "fmsong")) {

            String user = message.split(" ") [1];

            String[] bestSong = fm.getBestTrack(user);

            //retrieve the individual data of the song from the array we got
            String song = bestSong[0];
            String album = bestSong[1];
            String artist = bestSong[2];

            e.respondWith(user + "'s favourite song is: '" + song + "' by " + artist + " in '" + album + "'.");

        }


        //Top artist
        if (message.startsWith(prefix + "fmartist ")) {

            String user = message.split(" ") [1];

            String artist = fm.getBestArtist(user);

            e.respondWith(user + "'s favourite artist is " + artist + ".");

        }






    }














} //end of class
