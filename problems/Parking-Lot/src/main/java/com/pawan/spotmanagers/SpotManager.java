package com.pawan.spotmanagers;

import com.pawan.model.ParkingSpot;
import com.pawan.strategies.ParkingStrategy;

import java.util.List;

/**
 * @author $ {USER}
 **/
public abstract class SpotManager {
    protected List<ParkingSpot> spotList;
    protected ParkingStrategy parkingStrategy;

    SpotManager(List<ParkingSpot> spotList, ParkingStrategy parkingStrategy) {
        this.spotList = spotList;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot park() {
        ParkingSpot parkingSpot = parkingStrategy.getSpot(spotList);
        if (parkingSpot == null) {
            return null;
        }
        parkingSpot.occupySpot();
        return parkingSpot;
    }

    public void unpark(ParkingSpot spot) {
        spot.releaseSpot();
    }

    public boolean hasAvailability() {
        for (ParkingSpot spot : spotList) {
            if (spot.isFree()) {
                return true;
            }
        }
        return false;
    }

}
