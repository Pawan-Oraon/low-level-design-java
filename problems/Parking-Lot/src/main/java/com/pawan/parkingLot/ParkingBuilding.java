package com.pawan.parkingLot;

import com.pawan.entity.Ticket;
import com.pawan.model.ParkingSpot;
import com.pawan.model.Vehicle;

import java.util.List;

/**
 * @author $ {USER}
 **/
public class ParkingBuilding {
    List<ParkingLevel> levels;

    public ParkingBuilding(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    public Ticket allocate(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.hasAvailability(vehicle)) {
                ParkingSpot spot = level.park(vehicle);
                return new Ticket(spot, vehicle, level);
            }
        }
        return null;
    }

    public void release(Ticket ticket) {
        Vehicle vehicle = ticket.getVehicle();
        ticket.getLevel().unpark(vehicle, ticket.getSpot());
    }
}
