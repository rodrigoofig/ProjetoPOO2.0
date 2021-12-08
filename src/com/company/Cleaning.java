package com.company;

import java.io.Serializable;

/**
 * class of the cleaning products
 */
public class Cleaning extends Products implements Serializable {
    /**
     * toxicity rate in 1 to 10 of the product
     */
    private int toxicity;

    /**
     * empty constructor of the cleaning class
     */
    public Cleaning() {
    }

    /**
     *
     * inicializes all variables of a cleaning object
     *
     * @param identifier identifier of the product
     * @param name name of the product
     * @param price price of the product
     * @param stock quantity of the product
     * @param toxicity toxicity rate of the product
     */
    public Cleaning(int identifier, String name, double price, int stock, int toxicity) {
        super(identifier, name, price, stock);
        this.toxicity = toxicity;
    }

    /**
     *
     * @return toxicity rate
     */
    public int getToxicity() {
        return toxicity;
    }

    /**
     *
     * @param toxicity toxicity rate in 1 to 10
     */
    public void setToxicity(int toxicity) {
        this.toxicity = toxicity;
    }

    /**
     *
     * @return String with all informations of the cleaning object
     */
    @Override
    public String toString() {
        return "Cleaning{" + super.toString() + "toxicity=" + toxicity + '}';
    }
}
