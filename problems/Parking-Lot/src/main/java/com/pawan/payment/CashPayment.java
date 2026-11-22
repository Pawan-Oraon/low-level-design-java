package com.pawan.payment;

/**
 * @author $ {USER}
 **/
public class CashPayment implements PaymentType{
    @Override
    public boolean pay(double amount) {
        System.out.println("paid thorugh cash");
        return true;
    }
}
