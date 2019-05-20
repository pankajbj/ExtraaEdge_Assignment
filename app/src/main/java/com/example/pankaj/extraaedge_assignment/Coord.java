package com.example.pankaj.extraaedge_assignment;

import com.google.gson.annotations.SerializedName;

public class Coord {
    @SerializedName("lon")
    float lon;

    @SerializedName("lat")
    float lan;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLan() {
        return lan;
    }

    public void setLan(float lan) {
        this.lan = lan;
    }
}


