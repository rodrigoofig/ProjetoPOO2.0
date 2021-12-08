package com.company;

import java.io.Serializable;

/**
 * class that represents the food products
 */
public class Foods extends Products implements Serializable {
    /**
     *  calories of the food /100 grams
     */
    private double calories;
    /**
     * fat of the food in %
     */
    private int fat;

    /**
     * empty constructor
     */
    public Foods() {
    }

    /**
     *
     * inicializes the variables of a object food
     *
     * @param identifier identifier of the food
     * @param name  name of the food
     * @param price price of the food
     * @param stock stock of the food
     * @param calories calories of the food
     * @param fat fat of the food
     */
    public Foods(int identifier, String name, double price, int stock, double calories, int fat) {
        super(identifier, name, price, stock);
        this.calories = calories;
        this.fat = fat;
    }

    /**
     *
     * gets the calories in a food object
     *
     * @return calories
     */
    public double getCalories() {
        return calories;
    }


    /**
     *
     * sets the calories of a food object
     *
     * @param calories calories of the food
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     *
     * gets the fat of a food object
     *
     * @return fat
     */

    public int getFat() {
        return fat;
    }

    /**
     *
     * sets the fat of a food object
     *
     * @param fat fat of a food
     */

    public void setFat(int fat) {
        this.fat = fat;
    }

    /**
     *
     * @return String with the info of a food object
     */

    @Override
    public String toString() {
        return "Foods{" + super.toString() +
                "calories=" + calories +
                ", Fat=" + fat +
                '}';
    }
}
