package com.company;

import java.io.Serializable;

/**
 * class that represents all products (super class)
 */
abstract class Products implements Serializable {
    /**
     * identifier of the product
     */
    private int identifier;
    /**
     * name of the product
     */
    private String name;
    /**
     * price of the product
     */
    private double price;
    /**
     * quantity of the product
     */
    private int stock;

    /**
     * empty constructor of the Prodcuts class
     */
    public Products() {
    }
    /**
     *
     * inicializes all variables of a product object
     *
     * @param identifier identifier of the product
     * @param name name of the product
     * @param price price of the product
     * @param stock quantity of the product
     */

    public Products(int identifier, String name, double price, int stock) {
        this.identifier = identifier;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     *
     * @return identifier of the product
     */
    public int getIdentifier() {
        return identifier;
    }

    /**
     *
     * @param identifier identifier of the product
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     *
     * @return name of the product
     */
    public String getName() {

        return name;
    }

    /**
     *
     * @return 0
     */
    public double getWeight(){
        return 0;
    }

    /**
     *
     * @param price identifier of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param nome name of the product
     */
    public void setName(String nome) {
        this.name = name;
    }

    /**
     *
     * @return price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return quantity of the product
     */
    public int getStock() {
        return stock;
    }

    /**
     *
     * @param stock quantity of the product
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     *
     * @return String with all product information
     */
    @Override
    public String toString() {
        return "identifier=" + identifier + ", name='" + name + '\'' + ", price=" + price + ", stock=" + stock ;
    }
}
