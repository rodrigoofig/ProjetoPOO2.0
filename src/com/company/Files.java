package com.company;


import java.io.*;
import java.util.ArrayList;

/**
 * class for writing and reading the files
 */
public class Files implements Serializable{
    /**
     * empty constructor of Files class
     */
    public Files() {
    }

    /**
     *
     * This method reads the text file that saves all informations from the client and put them in a object list
     *
     * @param f file to read
     * @param l object that has all lists
     */
    public void clientsListTxtFile(File f, Lists l) {
        ArrayList<Clients> clients = new ArrayList<>();
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                Date d = new Date();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] splitedInfo = line.split(",");
                    String nome = splitedInfo[1];
                    String morada = splitedInfo[2];
                    String mail = splitedInfo[3];
                    String telefone = splitedInfo[4];
                    String data = splitedInfo[5];

                    //"f" = frequente
                    if (splitedInfo[0].compareTo("f") == 0) {
                        Frequent c = new Frequent(nome, morada, mail, telefone, d.dateStringToInt(data));
                        clients.add(c);
                    }
                    //"r" = regular
                    if (splitedInfo[0].compareTo("r") == 0) {
                        Regular c = new Regular(nome, morada, mail, telefone, d.dateStringToInt(data));
                        clients.add(c);
                    }
                    l.setRecords(clients);
                }
                br.close();

            } catch (IOException e) {
                System.out.println("error reading file");
            }

        } else {
            System.out.println("file does not exist");
        }
    }

    /**
     *
     * writes the object that contains all list in the object file
     *
     * @param f file to read
     * @param l object that has all lists
     */
    public void objFile(File f, Lists l) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            oos.writeObject(l);


            oos.close();
        } catch (IOException e) {
            System.out.println("Error writing in the file");
        }
    }

    /**
     *
     * reads the object Lists in the file and rewrites all lists
     *
     * @param f file to read
     * @param l object that has all lists
     */
    public void listsObjFile(File f, Lists l) {
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Lists lists = (Lists)ois.readObject();
            l.setAvailableStock(lists.getAvailableStock());
            l.setRecords(lists.getRecords());
            l.setProms(lists.getProms());
            l.setAllPurchases(lists.getAllPurchases());

            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error opening file");
        } catch (IOException ex) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException ex) {
            System.out.println("error converting object");
        }
    }

    /**
     *
     * reads the promotions text file, creates the objects corresponding to their respective class
     * and puts them in a objects list
     *
     * @param f file to read
     * @param l object that has all lists
     *
     */
    public void promotionsListTxtFile(File f, Lists l) {
        ArrayList<Promotions> p = new ArrayList<>();
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                Date d = new Date();
                String line;
                String[] splitedLine;
                while ((line = br.readLine()) != null) {
                    splitedLine = line.split(",");
                    String nome = splitedLine[1];
                    String startDate = splitedLine[2];
                    String endDate = splitedLine[3];
                    // lqpt == PayThreeTakeFour
                    if (splitedLine[0].compareTo("lqpt") == 0) {
                        PayThreeTakeFour prom = new PayThreeTakeFour(nome, d.dateStringToInt(startDate), d.dateStringToInt(endDate));
                        p.add(prom);
                    }
                    //pm == PayLess
                    if (splitedLine[0].compareTo("pm") == 0) {
                        PayLess prom = new PayLess(nome, d.dateStringToInt(startDate), d.dateStringToInt(endDate));
                        p.add(prom);
                    }
                    l.setProms(p);
                }
                br.close();

            } catch (IOException e) {
                System.out.println("error reading file");
            }

        } else {
            System.out.println("file does not exist");
        }
    }

    /**
     *
     * reads the products text file , creates the objects corresponding with their respective class
     * and puts them in a objects list
     *
     * @param f file to read
     * @param l object that has all lists
     */
    public void productsListTxtFile(File f, Lists l) {
        ArrayList<Products> p = new ArrayList<>();
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;
                String[] splitedLine;
                while ((line = br.readLine()) != null) {
                    splitedLine = line.split(",");
                    int identificador = Integer.parseInt(splitedLine[1]);
                    String nome = splitedLine[2];
                    double preco = Double.parseDouble(splitedLine[3]);
                    int stock = Integer.parseInt(splitedLine[4]);

                    if (splitedLine[0].compareTo("a") == 0) {
                        double calorias = Double.parseDouble(splitedLine[5]);
                        int gordura = Integer.parseInt(splitedLine[6]);

                        Foods produto = new Foods(identificador, nome, preco, stock, calorias, gordura);
                        p.add(produto);
                    }
                    if (splitedLine[0].compareTo("l") == 0) {
                        int toxicidade = Integer.parseInt(splitedLine[5]);

                        Cleaning produto = new Cleaning(identificador, nome, preco, stock, toxicidade);
                        p.add(produto);
                    }
                    if (splitedLine[0].compareTo("m") == 0) {
                        double peso = Double.parseDouble(splitedLine[5]);
                        String dimensao = splitedLine[6];

                        Furniture produto = new Furniture(identificador, nome, preco, stock, peso, dimensao);
                        p.add(produto);
                    }
                    l.setAvailableStock(p);
                }
                br.close();

            } catch (IOException e) {
                System.out.println("error reading file");
            }

        } else {
            System.out.println("file does not exist");
        }
    }

    /**
     *
     * this method checks if the file with the receipts of a certain client exists
     * if not , creats it and put the receipt there
     * if the file already exists , reads the file in a list, put the receipt r in the list, updates the receipt list
     * in the Lists object and rewrites the file with the Lists object
     *
     * @param name name of the client
     * @param r object that saves a certain receipt
     * @param l Object whit all lists
     */
    public void addReceipt(String name, Receipt r,Lists l) {
        File f = new File("clientsPurchases\\" + name + "file.obj");
        ArrayList<Receipt> re = new ArrayList<>();
        //Checks if the file exists

        if (!f.exists()) {
            l.getAllPurchases().add(r);
            try {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(l);

                oos.close();
            } catch (IOException e) {
                System.out.println("Error writing in the file");
            }
        } else {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Lists listsF = (Lists) ois.readObject();
                re = listsF.getAllPurchases();

                ois.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error opening file");
            } catch (IOException ex) {
                System.out.println("Error reading file");
            } catch (ClassNotFoundException ex) {
                System.out.println("error converting object");
            }
            re.add(r);
            //updates the allPurchases list in the Lists object
            l.setAllPurchases(re);
            try {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(l);

                oos.close();
            } catch (IOException e) {
                System.out.println("Error writing in the file");
            }

        }
    }

}
