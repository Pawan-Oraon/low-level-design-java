package com.pawan.pricing;

import com.pawan.entity.Ticket;

/**
 * @author $ {USER}
 **/
public class FixedPriceStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Ticket ticket) {
        return 100.0;
    }
}
