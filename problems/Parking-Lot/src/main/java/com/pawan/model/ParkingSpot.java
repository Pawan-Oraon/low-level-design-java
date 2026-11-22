package com.pawan.model;

/**
 * @author $ {USER}
 **/
public class ParkingSpot {
    String spotId;
    boolean free;
    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.free = true;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public boolean isFree() {
        return free;
    }

    public void occupySpot() {
        this.free = false;
    }

    public void releaseSpot() {
        this.free = true;
    }
}
