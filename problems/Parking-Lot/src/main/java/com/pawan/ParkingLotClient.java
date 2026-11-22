package com.pawan;

import com.pawan.entity.EntryGate;
import com.pawan.entity.ExitGate;
import com.pawan.entity.Ticket;
import com.pawan.model.ParkingSpot;
import com.pawan.model.Vehicle;
import com.pawan.model.VehicleType;
import com.pawan.parkingLot.ParkingBuilding;
import com.pawan.parkingLot.ParkingLevel;
import com.pawan.parkingLot.ParkingLot;
import com.pawan.payment.CashPayment;
import com.pawan.payment.PaymentType;
import com.pawan.pricing.CostComputation;
import com.pawan.pricing.FixedPriceStrategy;
import com.pawan.spotmanagers.FourWheelerSpotManager;
import com.pawan.spotmanagers.SpotManager;
import com.pawan.spotmanagers.TwoWheelerSpotManager;
import com.pawan.strategies.ParkingStrategy;
import com.pawan.strategies.RandomLookup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author $ {USER}
 **/
public class ParkingLotClient {

    public static void main(String[] args) {
        // 1. Build the parking lot: 2 levels, each with 2 two-wheeler and 2 four-wheeler spots
        ParkingLot parkingLot = buildParkingLot();
        PaymentType cash = new CashPayment();

        // 2. Vehicles
        Vehicle bike1 = new Vehicle("KA-01-BIKE-1", VehicleType.TWO_WHEELER);
        Vehicle bike2 = new Vehicle("KA-01-BIKE-2", VehicleType.TWO_WHEELER);
        Vehicle bike3 = new Vehicle("KA-01-BIKE-3", VehicleType.TWO_WHEELER);
        Vehicle car1 = new Vehicle("KA-01-CAR-1", VehicleType.FOUR_WHEELER);
        Vehicle car2 = new Vehicle("KA-01-CAR-2", VehicleType.FOUR_WHEELER);

        // 3. Vehicles arrive
        System.out.println("---- Arrivals ----");
        Ticket t1 = arrive(parkingLot, bike1);
        Ticket t2 = arrive(parkingLot, bike2);
        Ticket t3 = arrive(parkingLot, bike3); // spills over to level 2
        Ticket t4 = arrive(parkingLot, car1);
        Ticket t5 = arrive(parkingLot, car2);

        // 4. Exits
        System.out.println("---- Exits ----");
        exit(parkingLot, t1, cash);
        exit(parkingLot, t4, cash);

        // 5. Freed spots can be reused
        System.out.println("---- Re-entry after exit ----");
        Ticket t6 = arrive(parkingLot, new Vehicle("KA-01-CAR-3", VehicleType.FOUR_WHEELER));

        // 6. Fill the lot and show the "full" case
        System.out.println("---- Lot full scenario ----");
        List<Ticket> extra = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            extra.add(arrive(parkingLot, new Vehicle("KA-02-BIKE-" + i, VehicleType.TWO_WHEELER)));
        }
    }

    private static ParkingLot buildParkingLot() {
        ParkingStrategy strategy = new RandomLookup();

        List<ParkingLevel> levels = new ArrayList<>();
        for (int level = 1; level <= 2; level++) {
            List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
            List<ParkingSpot> fourWheelerSpots = new ArrayList<>();
            for (int i = 1; i <= 2; i++) {
                twoWheelerSpots.add(new ParkingSpot("L" + level + "-2W-" + i));
                fourWheelerSpots.add(new ParkingSpot("L" + level + "-4W-" + i));
            }

            Map<VehicleType, SpotManager> managers = new HashMap<>();
            managers.put(VehicleType.TWO_WHEELER, new TwoWheelerSpotManager(twoWheelerSpots, strategy));
            managers.put(VehicleType.FOUR_WHEELER, new FourWheelerSpotManager(fourWheelerSpots, strategy));

            levels.add(new ParkingLevel("L" + level, managers));
        }

        ParkingBuilding building = new ParkingBuilding(levels);
        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate(new CostComputation(new FixedPriceStrategy()));

        return new ParkingLot(building, entryGate, exitGate);
    }

    private static Ticket arrive(ParkingLot parkingLot, Vehicle vehicle) {
        Ticket ticket = parkingLot.vehicleArrive(vehicle);
        if (ticket == null) {
            System.out.println("No spot available for " + vehicle.getVehicleId()
                    + " (" + vehicle.getVehicleType() + ")");
        } else {
            System.out.println("Parked " + vehicle.getVehicleId()
                    + " at spot " + ticket.getSpot().getSpotId()
                    + ", ticket " + ticket.getTicketId());
        }
        return ticket;
    }

    private static void exit(ParkingLot parkingLot, Ticket ticket, PaymentType paymentType) {
        if (ticket == null) {
            System.out.println("Cannot exit: no ticket");
            return;
        }
        System.out.println("Exiting " + ticket.getVehicle().getVehicleId()
                + " from spot " + ticket.getSpot().getSpotId());
        parkingLot.vehicleExit(ticket, paymentType);
    }
}

