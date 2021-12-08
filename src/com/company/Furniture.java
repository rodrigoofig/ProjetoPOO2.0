package com.company;

import java.io.Serializable;

/**
 * class that represents the furniture products
 */
public class Furniture extends Products implements Serializable {
    /**
     * weight of the furniture in kg
     */
    private double weight;
    /**
     * dimension of the furniture (altura x largura x profundidade cm)
     */
    private String dimension;

    /**
     * empty constructor of the furniture class
     */
    public Furniture() {
    }

    /**
     *
     * inicializes all variables of a furniture object
     *
     * @param identifier identifier of the furniture
     * @param name name of the furniture
     * @param price price of the furniture
     * @param stock quantity of the furniture
     * @param weight weight of the furniture
     * @param dimension dimension of the furniture
     */
    public Furniture(int identifier, String name, double price, int stock, double weight, String dimension) {
        super(identifier, name, price, stock);
        this.weight = weight;
        this.dimension = dimension;
    }

    /**
     *
     * @return weight of the furniture
     */
    @Override
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param weight weight of the furniture
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     *
     * @return dimension of the furniture
     */
    public String getDimension() {
        return dimension;
    }

    /**
     *
     * @param dimension dimension of the furniture
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    /**
     *
     * @return String with the information of the furniture
     */
    @Override
    public String toString() {
        return "Mobilia{" + super.toString() +
                "weight=" + weight +
                ", dimension=" + dimension +
                '}';
    }
}
