package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class of the frequent clients
 */
public class Frequent extends Clients implements Serializable {
    /**
     * empty constructor of the frequent class
     */
    public Frequent() {
    }

    /**
     *
     * inicializes all variables of a frequent object
     *
     * @param name name of the client
     * @param household household of the client
     * @param email email of the client
     * @param phoneNum phone number of the client
     * @param birthday birthday date of the client
     */
    public Frequent(String name, String household, String email, String phoneNum, Date birthday) {
        super(name, household, email, phoneNum, birthday);
    }

    /**
     *
     * This method calculates the price of the transport , for a regular client he pays 20 euros by default
     * if he buys Furniture that weight more than 15 kg adds more 10 as many items as he bought
     *
     * @param pValue price paid by the client
     * @param list Products bought by the user
     * @return price of the transport
     */

    @Override
    double transportValue(double pValue, ArrayList<Products> list) {
        double valuet = 0;
        if(pValue == 0){
            return 0;
        }


        if (pValue < 40) {
            valuet = 15;
        }

        for (Products p : list) {
            if (p.getWeight() > 15) {
                valuet += 10;
            }
        }
        return valuet;
    }
}

