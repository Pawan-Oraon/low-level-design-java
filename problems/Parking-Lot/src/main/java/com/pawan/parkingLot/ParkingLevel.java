package com.pawan.parkingLot;

import com.pawan.model.ParkingSpot;
import com.pawan.model.Vehicle;
import com.pawan.model.VehicleType;
import com.pawan.spotmanagers.SpotManager;

import java.util.Map;

/**
 * @author $ {USER}
 **/
public class ParkingLevel {
    String levelNo;
    Map<VehicleType, SpotManager> managers;
    public ParkingLevel(String levelNo, Map<VehicleType, SpotManager> managers) {
        this.levelNo = levelNo;
        this.managers = managers;
    }

    public ParkingSpot park(Vehicle vehicle) {
        SpotManager spotManager = managers.get(vehicle.getVehicleType());
        return spotManager.park();
    }

    public void unpark(Vehicle vehicle, ParkingSpot spot) {
        SpotManager spotManager = managers.get(vehicle.getVehicleType());
        if (spotManager != null) {
            spotManager.unpark(spot);
        }
    }

    public boolean hasAvailability(Vehicle vehicle) {
        SpotManager spotManager = managers.get(vehicle.getVehicleType());
        if (spotManager != null) {
            return spotManager.hasAvailability();
        }
        return false;
    }
}
