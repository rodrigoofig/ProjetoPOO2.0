package com.company;

import java.io.Serializable;

/**
 * class of one of the promotions
 */
public class PayLess extends Promotions implements Serializable {
    /**
     * empty constructor of the PayLess class
     */
    public PayLess() {
    }

    /**
     *
     * inicializes the variables of the object
     *
     * @param name name of the product
     * @param start start date of the promotion
     * @param end end date of the promotion
     */
    public PayLess(String name, Date start, Date end) {
        super(name, start, end);
    }

    /**
     *
     * this method calculates a discount for a product
     * this discount consists in paying less 5% for each product until it reaches 50% of discount
     * after the discount reaches 50% all the following products of the same type will all have 50% of discount
     *
     * @param quantity quantity of products bought
     * @param price price of the product
     * @return price of the product with discount
     */
    @Override
    double prodcutFinalPrice(int quantity, double price) {
        double precoFinal = 0;
        int discount;
        for (int i = 0; i < quantity; i++) {
            discount = (100 - 5 * i);
            if (discount >= 50) {
                precoFinal += price * ((double) discount / 100);
            } else {
                precoFinal = price * 0.5;
            }
        }
        return precoFinal;
    }

    /**
     *
     * @return String with the information of the promotion
     */
    @Override
    public String toString() {
        return "PayLess{}" + super.toString();
    }
}
