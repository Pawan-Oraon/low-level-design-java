package com.pawan.strategies;

import com.pawan.model.ParkingSpot;

import java.util.List;

/**
 * @author $ {USER}
 **/
public interface ParkingStrategy {

    ParkingSpot getSpot(List<ParkingSpot> spotList);
}
