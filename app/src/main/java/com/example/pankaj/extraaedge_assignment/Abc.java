package com.example.pankaj.extraaedge_assignment;

import com.google.gson.annotations.SerializedName;

public class Abc {
    @SerializedName("coord")
    Coord coord;
    @SerializedName("name")
    String name;
   @SerializedName("main")
    Main main;
    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

