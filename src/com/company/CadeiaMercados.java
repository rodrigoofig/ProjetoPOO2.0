package com.company;

import java.io.*;
import java.sql.SQLOutput;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * main class where i call all the methods and run the program
 */
public class CadeiaMercados {
    /**
     * Object with all lists
     */
    Lists lists;
    /**
     * clients list
     */
    ArrayList<Clients> records;
    /**
     * available prodcuts in the store list
     */
    ArrayList<Products> availableStock;
    /**
     * purchase of the clients list
     */
    ArrayList<Products> cart;
    /**
     * promotions list
     */
    ArrayList<Promotions> proms;
    /**
     * all purchases made by the client list(receipts)
     */
    ArrayList<Receipt> allPurchases;

    /**
     *
     * @param args console parameters
     */
    public static void main(String[] args) {
        //inicialize everything
        CadeiaMercados chain = new CadeiaMercados();
        chain.start();
    }

    /**
     * inicializes the lists and the Lists object
     */
    public CadeiaMercados() {
        records = new ArrayList<>();
        availableStock = new ArrayList<>();
        cart = new ArrayList<>();
        proms = new ArrayList<>();
        allPurchases = new ArrayList<>();
        lists = new Lists(records, availableStock, cart, proms, allPurchases);

    }

    /**
     * Inicializes all the program , is the main function called on main
     */
    public void start() {
        Files files = new Files();
        //this is the date that represents the date of the day and can be easily changed
        Date todaysDate = new Date(18, 12, 2021);
        Scanner s = new Scanner(System.in);
        //every txt used and their respective obj files are inicialized here
        File tfr = new File("data\\regists.txt");
        File tfp = new File("data\\products.txt");
        File tfpr = new File("data\\promotions.txt");
        File o = new File("data\\lists.obj");



        //if the object files doesnt exist yet , the program runs first with the txt and then create their respective obj file
        if (!o.exists()) {
            files.clientsListTxtFile(tfr, lists);
            files.productsListTxtFile(tfp, lists);
            files.promotionsListTxtFile(tfpr, lists);
            files.objFile(o, lists);

        //if all obj files already exist then the program runs with them
        } else {
            files.listsObjFile(o, lists);
        }
        //this lines check if the email introduced exist
        int log;
        Scanner l = new Scanner(System.in);
        do {
            System.out.println("1 - Login");
            System.out.println("0 - EXIT");
            while (true) {
                System.out.print("Choice: ");
                try {
                    log = l.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("invalid input");
                    l.nextLine();
                }
            }

            if(log == 1) {
                String eMail;
                do {
                    System.out.print("Login: ");
                    eMail = s.nextLine();
                    if (login(eMail) == 0) {
                        System.out.println("wrong email or email not registed");
                    }
                } while (login(eMail) == 0);

                System.out.println(" ");
                System.out.println("login done with success!");

                welcome(eMail, lists.getRecords());
                System.out.println(" ");

                Sells sell = new Sells();
                int choice;
                //Menu for the client choices
                do {
                    System.out.println("------MENU------");
                    System.out.println("1 - Purchase");
                    System.out.println("2 - Check your purchases");
                    System.out.println("0 - Log Out");
                    System.out.println("----------------");
                    System.out.println(" ");
                    while (true) {
                        System.out.print("Choice: ");
                        try {
                            choice = s.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input");
                            s.nextLine();
                        }
                    }

                    //if he chooses to close the program then all info is saved in the obj files
                    if (choice == 0) {
                        files.objFile(o, lists);
                    }
            /*
            if she chooses to purchase something then it calls the functions to make the purchase
                calculate the price of the purchase - totalPrice()
                calculate the price of the transport value - transportValue()
                and saves the receipt in the client file - addReceipt()
              In the end of the purchase the program ends too
            */
                    if (choice == 1) {
                        //Purchase menu
                        sell.buy(lists);

                        float pValue = (float) sell.totalPrice(lists.getAvailableStock(), lists.getCart(), lists.getProms(), todaysDate);
                        System.out.println("Price: " + pValue + " euros");

                        for (Clients c : lists.getRecords()) {
                            if (c.getEmail().compareTo(eMail) == 0) {
                                float tValue = (float) c.transportValue((float) sell.totalPrice(lists.getAvailableStock(), lists.getCart(), lists.getProms(), todaysDate), lists.getCart());
                                System.out.println("Transport Value: " + tValue);
                                Receipt r = new Receipt(c.getName(), todaysDate, lists.getCart(), pValue, tValue);
                                if (pValue > 0) {
                                    files.addReceipt(c.getName(), r, lists);
                                }
                            }
                        }

                        System.out.println("Thanks for your purchase ");
                    }
            /*
            If the client chooses to see his purchases the program prints every purchases - allPurchases() and printReceipt()
             */
                    if (choice == 2) {
                        File f;
                        ArrayList<Receipt> empty = new ArrayList<>();
                        for (Clients c : lists.getRecords()) {
                            if (c.getEmail().compareTo(eMail) == 0) {
                                f = new File("clientsPurchases\\" + c.getName() + "file.obj");
                                if (f.exists()) {
                                    files.listsObjFile(f, lists);
                                } else {
                                    System.out.println(" ");
                                    System.out.println("You didnt make any purchase");
                                    System.out.println(" ");
                                }
                                break;
                            }
                        }
                        for (Receipt r : lists.getAllPurchases()) {
                            r.printReceipt(lists.getAvailableStock(), lists.getProms());
                        }
                        lists.setAllPurchases(empty);

                    }

                } while (choice != 0);
            }
            else{
                System.out.println("Thanks for coming");
            }
        }while(log != 0);
    }

    /**
     * this method checks the name of the client that uses this mail and welcome him
     *
     * @param mail email written by the user
     * @param list clients list
     */
    public void welcome(String mail, ArrayList<Clients> list) {
        for (Clients c : list) {
            if (c.getEmail().compareTo(mail) == 0) {
                System.out.println("Welcome " + c.getName() + " !");
            }
        }
    }

    /**
     * this method checks if the email written exists in the clients file
     *
     * @param mail email written by the user
     * @return 0 if doesnt exist and 1 if it does
     */
    public int login(String mail) {
        for (Clients r : lists.getRecords()) {
            if (r.getEmail().compareTo(mail) == 0) {
                return 1;
            }
        }
        return 0;
    }
}

/**
 * class that contains the lists
 */
class Lists implements Serializable{
    /**
     * list with the clients information
     */
    private ArrayList<Clients> records;
    /**
     * list with all products available
     */
    private ArrayList<Products> availableStock;
    /**
     * list with the purchases of the client
     */
    private ArrayList<Products> cart;
    /**
     * list with all promotions
     */
    private ArrayList<Promotions> proms;
    /**
     * list with all purchases of the client
     */
    private ArrayList<Receipt> allPurchases;

    /**
     * empty construct of Lists class
     */
    public Lists() {
    }

    /**
     *
     * inicializes all variables of the Lists object
     *
     * @param records list with the clients information
     * @param availableStock list with all products available
     * @param cart list with the purchases of the client
     * @param proms list with all promotions
     * @param allPurchases list with all purchases of the client
     */
    public Lists(ArrayList<Clients> records, ArrayList<Products> availableStock, ArrayList<Products> cart, ArrayList<Promotions> proms, ArrayList<Receipt> allPurchases) {
        this.records = records;
        this.availableStock = availableStock;
        this.cart = cart;
        this.proms = proms;
        this.allPurchases = allPurchases;
    }

    /**
     *
     * @return list with clients informations
     */
    public ArrayList<Clients> getRecords() {
        return records;
    }

    /**
     *
     * @param records list with clients informations
     */
    public void setRecords(ArrayList<Clients> records) {
        this.records = records;
    }

    /**
     *
     * @return list with all products available
     */
    public ArrayList<Products> getAvailableStock() {
        return availableStock;
    }

    /**
     *
     * @param availableStock list with all products available
     */
    public void setAvailableStock(ArrayList<Products> availableStock) {
        this.availableStock = availableStock;
    }

    /**
     *
     * @return list with the purchases of the client
     */
    public ArrayList<Products> getCart() {
        return cart;
    }

    /**
     *
     * @param cart list with the purchases of the client
     */
    public void setCart(ArrayList<Products> cart) {
        this.cart = cart;
    }

    /**
     *
     * @return list with all promotions
     */
    public ArrayList<Promotions> getProms() {
        return proms;
    }

    /**
     *
     * @param proms list with all promotions
     */
    public void setProms(ArrayList<Promotions> proms) {
        this.proms = proms;
    }

    /**
     *
     * @return list with all purchases of the client
     */
    public ArrayList<Receipt> getAllPurchases() {
        return allPurchases;
    }

    /**
     *
     * @param allPurchases list with all purchases of the client
     */
    public void setAllPurchases(ArrayList<Receipt> allPurchases) {
        this.allPurchases = allPurchases;
    }

    /**
     *
     * @return all lists content
     */
    @Override
    public String toString() {
        return "Lists{" +
                "records=" + records +
                ", availableStock=" + availableStock +
                ", cart=" + cart +
                ", proms=" + proms +
                ", allPurchases=" + allPurchases +
                '}';
    }
}
