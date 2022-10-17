package com.mycompany.companyproject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable {

    static String idEmployee;
    static String idManager;

    public static void main(String[] args) {
        readDataFromFile();
        Scanner s = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("Enter The Id: ");
            String id = s.nextLine();
            System.out.println("Enter The User: ");
            String user = s.nextLine();
            System.out.println("Enter The Password: ");
            String password = s.nextLine();
            if (id.equals("2022") && password.equals("123456") && user.equals("admin")) {
                System.out.println("Welcome To Company...");
                check = false;
            } else {
                System.out.println("Error in user or password or id!");
            }
        }
        boolean checkAll = true;
        try {
            while (checkAll) {
                Admin adminclass = new Admin();
                Manager managerclass = new Manager();
                Employee employeeclass = new Employee();

                System.out.println(">>>>> Login Screen <<<<<\n1- Login as Admin\n2- Login as Manager\n3- Login as Employee\n4- About System\n5- Exit");
                int option = s.nextInt();
                s.nextLine();
                switch (option) {
                    case 1:
                        adminclass.admin();
                        break;
                    case 2:
                        System.out.println("Enter id: ");
                        String idM = s.nextLine();
                        System.out.println("Enter password: ");
                        String passwordManager = s.nextLine();
                        for (int i = 0; i < Admin.arrAdmin.size(); i++) {
                            if (Admin.arrAdmin.get(i).getId().equals(idM) && Admin.arrAdmin.get(i).getPassword().equals(passwordManager) && Admin.arrAdmin.get(i).getStatus() == 1) {
                                idManager = idM;
                                managerclass.manager();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter id: ");
                        String idE = s.nextLine();
                        System.out.println("Enter password: ");
                        String passwordEmployee = s.nextLine();
                        for (int i = 0; i < Manager.arrManager.size(); i++) {
                            if (Manager.arrManager.get(i).getId().equals(idE) && Manager.arrManager.get(i).getPassword().equals(passwordEmployee) && Manager.arrManager.get(i).getStatus() == 1) {
                                idEmployee = idE;
                                employeeclass.employee();
                            }
                        }
                        break;
                    case 4:
                        System.out.println(">>>>>> System Information <<<<<");
                        System.out.println("> Company Management System");
                        System.out.println("> Develop by Mohammed Sbeata");
                        System.out.println("> @2022-2023");
                        break;
                    case 5:
                        checkAll = false;
                        saveDataInFile();
                        break;
                    default:
                        System.out.println(" Invalid Input..!");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error! " + ex);

        }
    }
    static File file = new File("C://project//project.txt");

    public static void saveDataInFile() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Admin.arrAdmin);
            oos.writeObject(Manager.arrManager);
            oos.writeObject(Holiday.arrHolidayManager);
            oos.writeObject(Holiday.arrHolidayEmployee);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found " + ex);
        } catch (IOException ex) {
            System.out.println("Error write data " + ex);
        }
    }

    public static void readDataFromFile() {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Admin.arrAdmin = (ArrayList<Admin>) ois.readObject();
            Manager.arrManager = (ArrayList<Manager>) ois.readObject();
            Holiday.arrHolidayManager = (ArrayList<Holiday>) ois.readObject();
            Holiday.arrHolidayEmployee = (ArrayList<Holiday>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found " + ex);
        } catch (IOException ex) {
            System.out.println("Error read date " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found " + ex);
        }
    }
}
