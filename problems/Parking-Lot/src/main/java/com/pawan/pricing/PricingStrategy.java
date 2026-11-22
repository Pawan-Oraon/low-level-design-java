package com.pawan.pricing;

import com.pawan.entity.Ticket;

/**
 * @author $ {USER}
 **/
public interface PricingStrategy {
    public double calculatePrice(Ticket ticket);
}
