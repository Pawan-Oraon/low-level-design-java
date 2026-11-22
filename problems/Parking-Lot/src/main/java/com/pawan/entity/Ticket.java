package com.pawan.entity;

import com.pawan.model.ParkingSpot;
import com.pawan.model.Vehicle;
import com.pawan.parkingLot.ParkingLevel;

import java.sql.Timestamp;

/**
 * @author $ {USER}
 **/
public class Ticket {
    String ticketId;
    long entryTime;
    ParkingSpot spot;
    Vehicle vehicle;
    ParkingLevel level;

    public Ticket(ParkingSpot spot, Vehicle vehicle, ParkingLevel level) {
        this.spot = spot;
        this.vehicle = vehicle;
        this.entryTime = System.currentTimeMillis();
        this.ticketId = "randomId" + vehicle.getVehicleId();
        this.level = level;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingLevel getLevel() {
        return level;
    }

    public void setLevel(ParkingLevel level) {
        this.level = level;
    }
}
