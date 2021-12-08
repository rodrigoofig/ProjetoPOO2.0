package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class that represents regular customers
 */
public class Regular extends Clients implements Serializable {
    /**
     * empty constructor
     */
    public Regular() {
    }

    /**
     *
     * Inicializes the variables of the class
     *
     * @param name name of the client
     * @param household household of the client
     * @param email email of the client
     * @param phoneNum phone number of the client
     * @param birhtday birthday date of the client
     */
    public Regular(String name, String household, String email, String phoneNum, Date birhtday) {
        super(name, household, email, phoneNum, birhtday);
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
        double valuet = 20;

        if(pValue == 0){
            return 0;
        }

        for (Products p : list) {
            if (p.getWeight() > 15) {
                valuet += 10;
            }
        }
        return valuet;
    }

}
