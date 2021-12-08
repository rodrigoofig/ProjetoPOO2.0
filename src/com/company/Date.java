package com.company;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {

        if (day < 0 || day > 31) {
            throw new IllegalArgumentException("dia not between 0 and 31");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 0 || month > 12) {
            throw new IllegalArgumentException("mes not between 0 and 12");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("mes not bigger than 0");
        }
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }


    public boolean equals(Date d) {
        if (this == d) return true;
        return day == d.day && month == d.month && year == d.year;
    }

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
