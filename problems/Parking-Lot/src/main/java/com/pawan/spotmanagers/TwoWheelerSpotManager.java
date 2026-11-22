package com.pawan.spotmanagers;

import com.pawan.model.ParkingSpot;
import com.pawan.strategies.ParkingStrategy;

import java.util.List;

/**
 * @author $ {USER}
 **/
public class TwoWheelerSpotManager extends SpotManager{
    TwoWheelerSpotManager(List<ParkingSpot> spotList, ParkingStrategy parkingStrategy) {
        super(spotList, parkingStrategy);
    }
}
