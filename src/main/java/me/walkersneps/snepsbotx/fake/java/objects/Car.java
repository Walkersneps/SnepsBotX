package me.walkersneps.snepsbotx.fake.java.objects;


import static me.walkersneps.snepsbotx.SnepsBotX.sendMessage;

public class Car {

    //properties
    private String carColor;
    private String carModel;



    //constructor
    Car (String model, String color) {
        carModel = model;
        carColor = color;
    }



    //behaviors
    void horn (String where) {
        sendMessage (where, "Beep beep!");
    }

    void accident (String where) {
        sendMessage(where, "Crash! wroom dadnajdqdabpshhh!");
    }

    void throttle (String where) {
        sendMessage(where, "Wroom wroom, motherfucker!");
    }



    //setters
    void setCarColor (String color) {
        carColor = color;
    }

    void setCarModel (String model) {
        carModel = model;
    }


    //getters
    String getCarColor () {
        return carColor;
    }

    String getCarModel () {
        return carModel;
    }




} //end of class
