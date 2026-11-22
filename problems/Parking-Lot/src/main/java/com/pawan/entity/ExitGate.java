package com.pawan.entity;

import com.pawan.parkingLot.ParkingBuilding;
import com.pawan.payment.PaymentType;
import com.pawan.pricing.CostComputation;

/**
 * @author $ {USER}
 **/
public class ExitGate {
    CostComputation costComputation;
    public ExitGate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }
    public void exitVehicle(ParkingBuilding parkingBuilding, Ticket ticket, PaymentType paymentType) {
        double amount = costComputation.calculatePrice(ticket);
        boolean isPaymentSuccess = paymentType.pay(amount);
        if (isPaymentSuccess) {
            parkingBuilding.release(ticket);
            System.out.println("Vehicle exit successful, Gate opened");
        } else {
            System.out.println("payment was not successful");
        }

    }
}
