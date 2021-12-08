package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class that controls the purchases of the client and calculate them price
 */
public class Sells implements Serializable {

    /**
     * This method prints the menu and manages all purchases made by the client
     * the client make his choices by entering the number  that corresponds to the action he want to do
     * if the input is invalid the program will thell the user and ask again for the input
     *
     * @param l object with the lists of the program
     */
    public void buy(Lists l) {
        int quantity;
        int choice;
        int assurence;
        ArrayList<Products> purchases = new ArrayList<>();

        do {
            int skip = 0;
            Scanner s = new Scanner(System.in);
            int i = 1;
            //shows whats available in the store
            System.out.println("-----Available Products-----");
            for (Products p : l.getAvailableStock()) {
                System.out.println(i + "-" + p.getName());
                i++;
            }
            System.out.println("0-End Purchase");
            //loop until the client chooses a valid input
            do {
                while (true) {
                    System.out.print("Choice: ");

                    try {
                        choice = s.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("input invalido");
                        s.nextLine();
                    }
                }
                if (choice > l.getAvailableStock().size() || choice < 0) {
                    System.out.println("Input not available in the menu");
                }
            } while (choice > l.getAvailableStock().size() || choice < 0);
            System.out.print("");
            //in the the client chooses 0 it ends
            if (choice == 0) {
                break;
            }

            System.out.println(" ");
            System.out.println("Product: " + l.getAvailableStock().get(choice - 1).getName());
            System.out.println("Available stock: " + l.getAvailableStock().get(choice - 1).getStock());
            System.out.println("Price of the product: " + l.getAvailableStock().get(choice - 1).getPrice() + " euros");
            System.out.println(" ");

            System.out.println("Are you sure you want this product?");
            System.out.println("1 - Yes");
            System.out.println("0 - Go back");
            //loop until the client chooses a valid input
            do {
                while (true) {
                    System.out.print("choice: ");

                    try {
                        assurence = s.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("input invalido");
                        s.nextLine();
                    }
                }
                if (assurence < 0 || assurence > 1) {
                    System.out.println("Input not available in the menu");
                }
            } while (assurence < 0 || assurence > 1);
            System.out.print("");

            if(assurence == 0){
                skip = 1;
            }

            if(skip == 0) {
                if (l.getAvailableStock().get(choice - 1).getStock() > 0) {
                    //loop until the client chooses a valid input
                    do {
                        while (true) {
                            System.out.print("quantity: ");
                            try {
                                quantity = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("input invalido");
                                s.nextLine();
                            }
                        }

                        if (quantity > l.getAvailableStock().get(choice - 1).getStock() || quantity <= 0) {
                            System.out.println("Quantity asked is greater then the available");
                        }

                    } while (quantity > l.getAvailableStock().get(choice - 1).getStock() || quantity <= 0);
                    //adds the product as many times as the quantity the client asked for
                    for (int j = 0; j < quantity; j++) {
                        purchases.add(l.getAvailableStock().get(choice - 1));
                    }
                    //update the stock in the stock list
                    int getStock = l.getAvailableStock().get(choice - 1).getStock();
                    l.getAvailableStock().get(choice - 1).setStock(getStock - quantity);
                } else {
                    System.out.println("Product out of stock");
                }
            }
        } while (true);
        l.setCart(purchases);
    }

    /**
     *
     * this method checks if the purchases list is empty
     * if not it runs all the purchases list and sum all the prices of the prodcuts in the list
     * It checks too for a possible promotion and if it exists , use a function to
     * calculate the price of the product that has a promotion
     *
     * @param stock list that contains all products available
     * @param purchases list that contains all products purchased by the client
     * @param proms list that contains all promotions available
     * @param td date of the day
     * @return  0 if the purchases list is empty or totalPrice of the pruchase
     */
    public double totalPrice(ArrayList<Products> stock, ArrayList<Products> purchases, ArrayList<Promotions> proms, Date td) {
        double totalPrice = 0;

        //if the list purchases list is empty return 0
        if (purchases.isEmpty()) {
            return 0;
        }

        for (Products s : stock) {
            int quantity = 0;
            int k = 0;
            //runs the purchases list and counts the quantity of a certain product
            for (Products c :purchases) {
                if (c.getName().compareTo(s.getName()) == 0) {
                    quantity += 1;
                }
            }
            //if a promotion exists calculate it
            for (Promotions p : proms) {
                if (s.getName().compareTo(p.getName()) == 0 && (td.equals(p.getStart()) || td.equals(p.getEnd()) || (td.dataMaior(p.getStart()) && !td.dataMaior(p.getEnd())))) {
                    totalPrice += p.prodcutFinalPrice(quantity, s.getPrice());
                    k = 1;
                }
            }
            //if a promotion doesnt exists just multiplies the price of the product by the quantity bought
            if (k == 0) {
                totalPrice += quantity * s.getPrice();
            }

        }

        return totalPrice;
    }

}

