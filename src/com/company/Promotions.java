package com.company;

import java.io.Serializable;

/**
 * class that represents all promotions
 */
abstract class Promotions implements Serializable {
    /**
     * name of the product in promotion
     */
    private String name;
    /**
     * date of the start of the promotion
     */
    private Date start;
    /**
     * date of the end of the promotion
     */
    private Date end;

    /**
     * empty constructor
     */
    public Promotions() {
    }

    /**
     *
     * constructor for inicializing the promotion object
     *
     * @param name name of the product in promotion
     * @param start date of the start of the promotion
     * @param end date of the end of the promotion
     */
    public Promotions(String name, Date start, Date end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    /**
     * gets the name of the product in promotion
     *@return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * sets the name of the product in promotion
     *
     * @param name name of the product in promotion
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * gets the date of the start of the promotion
     *
     * @return start
     */
    public Date getStart() {
        return start;
    }

    /**
     *
     * sets the date of the start of the promotion
     *
     * @param start start of the promotion
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     *
     * Gets the date of the end of the promotion
     *
     * @return end
     */

    public Date getEnd() {
        return end;
    }

    /**
     *
     * sets the end of the date of the promotion
     *
     * @param end end of the promotion
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     *
     * @return string with the info of the promotion
     */
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    /**
     *
     * this method calculates the price of the products bought with the promotion they have
     *
     * @param quantity quantity bought
     * @param price price of the product bought
     * @return price of the products with the discount
     */
    abstract double prodcutFinalPrice(int quantity, double price);
}
