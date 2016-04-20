package me.walkersneps.snepsbotx.fake.java.objects;


import static me.walkersneps.snepsbotx.SnepsBotX.sendMessage;

public class Dog {

    //properties
    private String dogBreed;
    private String dogColor;



    //Constructor
    Dog (String breed, String color) {
        dogBreed = breed;
        dogColor = color;
    }



    //behaviors
    void bark (String where) {
        sendMessage (where, "Wof, wof!");
    }



    //setters
    void setDogBreed (String breed) {
        dogBreed = breed;
    }

    void setDogColor (String color) {
        dogColor = color;
    }


    //getters
    String getDogBreed () {
        return dogBreed;
    }

    String getDogColor () {
        return dogColor;
    }




} //end of class
