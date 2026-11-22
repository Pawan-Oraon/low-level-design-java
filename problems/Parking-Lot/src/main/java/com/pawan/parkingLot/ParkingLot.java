package com.pawan.parkingLot;

import com.pawan.entity.EntryGate;
import com.pawan.entity.ExitGate;
import com.pawan.entity.Ticket;
import com.pawan.model.ParkingSpot;
import com.pawan.model.Vehicle;
import com.pawan.model.VehicleType;
import com.pawan.payment.PaymentType;

/**
 * @author $ {USER}
 **/
public class ParkingLot {
    public ParkingBuilding parkingBuilding;
    public EntryGate entryGate;
    public ExitGate exitGate;
    public ParkingLot(ParkingBuilding parkingBuilding, EntryGate entryGate, ExitGate exitGate) {
        this.parkingBuilding = parkingBuilding;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleArrive(Vehicle vehicle) {
        return entryGate.enter(parkingBuilding, vehicle);
    }

    public void vehicleExit(Ticket ticket, PaymentType paymentType) {
        exitGate.exitVehicle(parkingBuilding, ticket, paymentType);
    }
}
