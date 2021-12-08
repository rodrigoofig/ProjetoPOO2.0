package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class that saves a purchase made by the client
 */
public class Receipt implements Serializable {
    /**
     * name of the client
     */
    private String name;
    /**
     * date of the day
     */
    private Date todayDate;
    /**
     * list with the purchases of the client
     */
    private ArrayList<Products> purchases;
    /**
     * price of the purchases
     */
    private double purchaseValue;
    /**
     * price of the tranport
     */
    private double transportValue;

    /**
     * empty constructor
     */
    public Receipt() {
    }

    /**
     *
     *Constructor of the Receipt class
     *
     * @param name name of the client
     * @param todayDate date of the day
     * @param purchases list with the purchases of the client
     * @param purchaseValue price of the purchases
     * @param transportValue price of the tranport
     */
    public Receipt(String name, Date todayDate, ArrayList<Products> purchases, double purchaseValue, double transportValue) {
        this.name = name;
        this.todayDate = todayDate;
        this.purchases = purchases;
        this.purchaseValue = purchaseValue;
        this.transportValue = transportValue;
    }

    /**
     *gets the name of the client in the receipt
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * sets the name of the client in the receipt
     *
     * @param nome name of the client
     */
    public void setName(String nome) {
        this.name = name;
    }

    /**
     *
     * @return todayDate
     */
    public Date getTodayDate() {
        return todayDate;
    }

    /**
     *
     * @param todayDate date of the day
     */
    public void setTodayDate(Date todayDate) {
        this.todayDate = todayDate;
    }

    /**
     *
     * @return list with the purchases
     */
    public ArrayList<Products> getPurchases() {
        return purchases;
    }

    /**
     *
     * @param purchases list with the purchases of the client
     */
    public void setPurchases(ArrayList<Products> purchases) {
        this.purchases = purchases;
    }

    /**
     *
     * @return total price of the purchase
     */
    public double getPurchaseValue() {
        return purchaseValue;
    }

    /**
     *
     * @param purchaseValue total price of the purchase
     */
    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    /**
     *
     * @return total price of the transport
     */
    public double getTransportValue() {
        return transportValue;
    }

    /**
     *
     * @param transportValue total price of the transport
     */

    public void setTransportValue(double transportValue) {
        this.transportValue = transportValue;
    }

    /**
     *
     * This method prints the information of a purchase of the client
     * it shows how much money he spent on each item and the items he bought
     * Shows the date too , the total price of the products and the total price of the transport
     *
     * @param stock list with the products available in the store
     * @param proms list with the promotions
     */
    public void printReceipt(ArrayList<Products> stock, ArrayList<Promotions> proms) {
        System.out.println("--------COMPRA--------");
        System.out.println("name: " + name);
        for (Products s : stock) {
            int k = 0;
            int quantity = 0;
            for (Products c : purchases) {
                if (c.getName().compareTo(s.getName()) == 0) {
                    quantity += 1;
                }
            }
            int total = 0;
            for (Promotions p : proms) {
                if (s.getName().compareTo(p.getName()) == 0 && (todayDate.equals(p.getStart()) || todayDate.equals(p.getEnd()) || (todayDate.dataMaior(p.getStart()) && !todayDate.dataMaior(p.getEnd())))) {
                    total += p.prodcutFinalPrice(quantity, s.getPrice());
                    if(total != 0) {
                        System.out.println(s.getName() + ": " + (float) total + " euros");

                    }
                    k = 1;
                }

            }

            //if a promotion doesnt exists just multiplies the price of the product by the quantity bought
            if (quantity > 0 && k == 0) {
                System.out.println(s.getName() + ": " + (float) (quantity * s.getPrice()) + " euros");
            }

        }
        System.out.println("Total Price: " + (float) purchaseValue + " euros");
        System.out.println("Transport Price: " + transportValue + " euros");
        System.out.println("Date: " + todayDate);
        System.out.println("----------------------");
        System.out.println("\n");

    }

    /**
     *
     * @return String with the information of the object receipt
     */
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", todayDate=" + todayDate +
                ", purchases=" + purchases +
                ", purchaseValue=" + purchaseValue +
                ", transportValue=" + transportValue +
                '}';
    }

}
