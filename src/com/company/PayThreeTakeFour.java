package com.company;

import java.io.Serializable;

/**
 * class of one of the promotions
 */


public class PayThreeTakeFour extends Promotions implements Serializable {
    /**
     * empty constructor of the class PayThreeTakeFour
     */
    public PayThreeTakeFour() {
    }

    /**
     *
     * inicializes the variables of the PayThreeTakeFour object
     *
     *
     * @param name name of the procuct
     * @param start start date of the promotion
     * @param end end date of the promotion
     */
    public PayThreeTakeFour(String name, Date start, Date end) {
        super(name, start, end);
    }

    /**
     *
     * @param quantity quantity bought
     * @param price price of the product bought
     * @return price of the products with the promotion
     */
    @Override
    double prodcutFinalPrice(int quantity, double price) {
        return (quantity - (int) ((float) quantity / 4)) * price;
    }

    /**
     *
     * @return String with the informtation of the promotion
     */
    @Override
    public String toString() {
        return "PayThreeTakeFour{}" + super.toString();
    }

}
