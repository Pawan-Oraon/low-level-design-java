package com.pawan.entity;

import com.pawan.model.Vehicle;
import com.pawan.parkingLot.ParkingBuilding;

/**
 * @author $ {USER}
 **/
public class EntryGate {
    public Ticket enter(ParkingBuilding building, Vehicle vehicle) {
        return building.allocate(vehicle);
    }
}
