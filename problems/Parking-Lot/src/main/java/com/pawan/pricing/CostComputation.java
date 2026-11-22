package com.pawan.pricing;

import com.pawan.entity.Ticket;

/**
 * @author $ {USER}
 **/
public class CostComputation {

    private PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculatePrice(Ticket ticket) {
        return pricingStrategy.calculatePrice(ticket);
    }

    private void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}
