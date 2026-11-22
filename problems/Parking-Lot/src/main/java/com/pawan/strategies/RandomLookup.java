package com.pawan.strategies;

import com.pawan.model.ParkingSpot;

import java.util.List;

/**
 * @author $ {USER}
 **/
public class RandomLookup implements ParkingStrategy{
    @Override
    public ParkingSpot getSpot(List<ParkingSpot> spotList) {
        for (ParkingSpot spot : spotList) {
            if (spot.isFree()) {
                return spot;
            }
        }
        return null;
    }
}
