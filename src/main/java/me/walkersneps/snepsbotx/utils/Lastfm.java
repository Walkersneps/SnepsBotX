package me.walkersneps.snepsbotx.utils;


import de.umass.lastfm.Caller;
import de.umass.lastfm.User;

import static me.walkersneps.snepsbotx.ConfigReader.fmKey;

public class Lastfm {


    public Lastfm() {

        Caller.getInstance().setUserAgent("tst");

    }


    public String[] getLatestTrack (String user) {

        String artist = User.getRecentTracks(user, 1, 1, fmKey).iterator().next().getArtist();
        String album = User.getRecentTracks(user, 1, 1, fmKey).iterator().next().getAlbum();
        String song = User.getRecentTracks(user, 1, 1, fmKey).iterator().next().getName();

        String[] result = new String[3];

        result[0] = song;
        result[1] = album;
        result[2] = artist;

        return result;

    }

    public String[] getBestTrack (String user) {

        String song = User.getTopTracks(user, fmKey).iterator().next().getName();
        String artist = User.getTopTracks(user, fmKey).iterator().next().getArtist();
        String album = User.getTopTracks(user, fmKey).iterator().next().getAlbum();

        String[] result = new String[3];

        result[0] = song;
        result[1] = album;
        result[2] = artist;

        return result;

    }

    public String getBestArtist (String user) {

        return User.getTopArtists(user, fmKey).iterator().next().getName();

    }





} //end of class
