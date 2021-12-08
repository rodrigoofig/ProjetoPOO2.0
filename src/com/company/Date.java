package com.company;

import java.io.Serializable;

/**
 * Class for the Dates
 */
public class Date implements Serializable {
    /**
     * day of the date
     */
    private int day;
    /**
     * month of the date
     */
    private int month;
    /**
     * year of the date
     */
    private int year;

    /**
     * empty constructor of the Date class
     */
    public Date() {
    }

    /**
     *
     * inicializes the variables of the Date object
     *
     * @param day day of the date
     * @param month month of the date
     * @param year year of the date
     */

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     *
     * @return day of the date
     */
    public int getDay() {
        return day;
    }

    /**
     *
     * @param day day of the date
     */
    public void setDay(int day) {

        if (day < 0 || day > 31) {
            throw new IllegalArgumentException("dia not between 0 and 31");
        }
        this.day = day;
    }

    /**
     *
     * @return month of the date
     */
    public int getMonth() {
        return month;
    }

    /**
     *
     * @param month month of the date
     */
    public void setMonth(int month) {
        if (month < 0 || month > 12) {
            throw new IllegalArgumentException("mes not between 0 and 12");
        }
        this.month = month;
    }

    /**
     *
     * @return year of the date
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @param year year of the date
     */
    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("mes not bigger than 0");
        }
        this.year = year;
    }

    /**
     *
     *@return String with the Date
     */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    /**
     *
     * compares two dates and returns if the date is equal or not
     *
     * @param d Date
     * @return true or false if the date is equal or not
     */
    public boolean equals(Date d) {
        if (this == d) return true;
        return day == d.day && month == d.month && year == d.year;
    }

    /**
     *
     * compares two dates and returns if the date is bigger or not
     *
     * @param d Date
     * @return returns true or false if the date is bigger or not
     */
    public boolean dataMaior(Date d) {
        if (month == d.month && year == d.year) {
            return day > d.day;
        }
        if (month > d.month && year == d.year) {
            return true;
        }
        if (year > d.year) {
            return true;
        }
        return false;
    }

    /**
     *
     * gets a date in form of a string and returns a Date object
     *
     * @param date Date String
     * @return Object Date
     */
    public Date dateStringToInt(String date) {
        String[] dmy = date.split("/");
        try {
            int day = Integer.parseInt(dmy[0]);
            int month = Integer.parseInt(dmy[1]);
            int year = Integer.parseInt(dmy[2]);
            return new Date(day, month, year);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return null;
        }

    }

}
