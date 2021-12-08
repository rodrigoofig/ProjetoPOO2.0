package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class for the clients
 */
abstract class Clients implements Serializable {
    /**
     * name of the client
     */
    private String name;
    /**
     * household of the client
     */
    private String household;
    /**
     * email of the client
     */
    private String email;
    /**
     * phone number of the client
     */
    private String phoneNum;
    /**
     * birthday Date of the client
     */
    private Date birhtday;

    /**
     * empty constructor of the class Clients
     */
    public Clients() {
    }

    /**
     *
     * inicializes the variables of a Clients object
     *
     * @param name name of the client
     * @param household household of the client
     * @param email email of the client
     * @param phoneNum phone number of the client
     * @param birhtday birthday Date of the client
     */
    public Clients(String name, String household, String email, String phoneNum, Date birhtday) {
        this.name = name;
        this.household = household;
        this.email = email;
        this.phoneNum = phoneNum;
        this.birhtday = birhtday;


    }

    /**
     *
     * @return name of the client
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name name of the client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return household of the client
     */
    public String getHousehold() {
        return household;
    }

    /**
     *
     * @param household household of the client
     */
    public void setHousehold(String household) {
        this.household = household;
    }

    /**
     *
     * @return email of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email email of the client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return phone number of the client
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     *
     * @param phoneNum phone number of the client
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     *
     * @return birthday Date of the client
     */
    public Date getBirhtday() {
        return birhtday;
    }

    /**
     *
     * @param birhtday birthday Date of the client
     */
    public void setBirhtday(Date birhtday) {
        this.birhtday = birhtday;
    }

    /**
     *
     * @return String with the information of the client
     */
    @Override
    public String toString() {
        return "Clientes{" +
                "name='" + name + '\'' +
                ", household='" + household + '\'' +
                ", email='" + email + '\'' +
                ", phone number='" + phoneNum + '\'' +
                ", birhtday=" + birhtday +
                ", valTrans=" +
                '}';
    }
    /**
     *This is a abstract method that calculates the tranport value of a purchase
     *
     * @param pValue price paid by the client
     * @param list Products bought by the user
     * @return price of the transport
     */

    abstract double transportValue(double pValue, ArrayList<Products> list);
}
