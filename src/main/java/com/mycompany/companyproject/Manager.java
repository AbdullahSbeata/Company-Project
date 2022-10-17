package com.mycompany.companyproject;
import java.io.*;
import java.util.*;

public class Manager extends Parent implements Serializable {

    static ArrayList<Manager> arrManager = new ArrayList<Manager>();
    private static int typeEmp;

    public Manager(String id, String name, String password, String email, String phoneNumber, int status, int typeEmp) {
        super(id, name, password, email, phoneNumber, status);
        this.typeEmp = typeEmp;
    }
    public Manager() {}
    public void manager() {
        boolean check = true;
        while (check) {
            System.out.println(">>>>> Manager <<<<<\n1- Add Employee.\n2- Update Employee.\n3- Delete Employee.\n4- Search about Employee."
                    + "\n5- Report about Employee.\n6- Report about All Employee.\n7- Deactivate & Activate Employee.\n8- Promote an Employee to Manager.\n9- Attendance.\n10- Holiday.\n11- Exit");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    boolean isExit = false;
                    System.out.println(">>>>> Add Employee <<<<<");
                    System.out.println("Enter id :");
                    String id = s.next();
                    setId(id);
                    System.out.println("Enter name :");
                    setName(s.next());
                    s.nextLine();
                    System.out.println("Enter password :");
                    setPassword(s.nextLine());
                    System.out.println("Enter email :");
                    setEmail(s.nextLine());
                    System.out.println("Enter phone number :");
                    setPhoneNumber(s.nextLine());
                    System.out.println("Types of employees (1) <Full-time> or (2) <Part-time>");
                    setType(s.nextInt());
                    System.out.println("Enter status :");
                    setStatus(s.nextInt());
                    for (int i = 0; i < arrManager.size(); i++) {
                        if (arrManager.get(i).getId().equals(id)) {
                            isExit = true;
                            break;
                        }
                    }
                    for (int j = 0; j < Admin.arrAdmin.size(); j++) {
                        if (Admin.arrAdmin.get(j).getId().equals(id)) {
                            isExit = true;
                            break;
                        }
                    }
                    if (isExit) {
                        System.out.println("Sorry, This id exist");
                    } else {
                        arrManager.add(new Manager(getId(), getName(), getPassword(), getEmail(), getPhoneNumber(), getStatus(), getType()));
                        System.out.println("The Employee has been successful added.");
                    }
                    break;
                case 2:
                    boolean isNotUpdate = true;
                    System.out.println(">>>>> Update Employee <<<<<");
                    System.out.println("Enter id :");
                    String update = s.next();
                    for (int i = 0; i < arrManager.size(); i++) {
                        if (arrManager.get(i).getId().equals(update)) {
                            System.out.println("New password :");
                            String newPassword = s.next();
                            s.nextLine();
                            arrManager.get(i).setPassword(newPassword);
                            isNotUpdate = false;
                            System.out.println("The Employee data was successful updated.");
                            break;
                        }
                    }
                    if (isNotUpdate) {
                        System.out.println("Error in update..!");
                    }
                    break;
                case 3:
                    boolean isNotDelete = true;
                    System.out.println(">>>>> Delete Employee <<<<<");
                    System.out.println("Enter id :");
                    String delete = s.next();
                    for (int i = 0; i < arrManager.size(); i++) {
                        if (arrManager.get(i).getId().equals(delete)) {
                            arrManager.remove(i);
                            isNotDelete = false;
                            System.out.println("The Employee has been successful deleted.");
                            break;
                        }
                    }
                    if (isNotDelete) {
                        System.out.println("Error in delete..!");
                    }
                    break;
                case 4:
                    boolean isNotSearch = true;
                    System.out.println(">>>>> Search about  Employee <<<<<");
                    System.out.println("Enter id :");
                    String search = s.next();
                    for (int i = 0; i < arrManager.size(); i++) {
                        if (arrManager.get(i).getId().equals(search)) {
                            arrManager.get(i).search();
                            isNotSearch = false;
                            break;
                        }
                    }
                    if (isNotSearch) {
                        System.out.println(" error in search ");
                    }
                    break;
                case 5:
                    boolean isNotReport = true;
                    System.out.println(">>>>> Report about Employee <<<<<");
                    System.out.println("Enter id or name :");
                    String idOrName = s.next();
                    s.nextLine();
                    for (int i = 0; i < arrManager.size(); i++) {
                        if (arrManager.get(i).getId().equals(idOrName) || (arrManager.get(i).getName().equalsIgnoreCase(idOrName))) {
                            arrManager.get(i).report();
                            isNotReport = false;
                            break;
                        }
                    }
                    if (isNotReport) {
                        System.out.println("Error in report..! ");
                    }
                    break;
                case 6:
                    System.out.println(">>>>> Report about All Employee <<<<<");
                    for (int i = 0; i < arrManager.size(); i++) {
                        arrManager.get(i).report();
                    }
                    break;
                case 7:
                    ActiveAndDeactive();
                    break;
                case 8:
                    boolean isNotPromote = true;
                    System.out.println(">>>>> Promote an Employee to  Manager <<<<<");
                    System.out.println(" Enter id :");
                    String promote = s.next();
                    for (int i = 0; i < arrManager.size(); i++) {
                        if (arrManager.get(i).getId().equals(promote)) {
                            Admin.arrAdmin.add(new Admin(arrManager.get(i).getId(), arrManager.get(i).getName(),
                                    arrManager.get(i).getPassword(), arrManager.get(i).getEmail(),
                                    arrManager.get(i).getPhoneNumber(), arrManager.get(i).getStatus()));
                            isNotPromote = false;
                            arrManager.remove(i);
                            System.out.println("The current employee (" + promote + ") has the athourity a manager. ");
                            break;
                        }
                    }
                    if (isNotPromote) {
                        System.out.println("Error in promote..!");
                    }
                    break;
                case 9:
                    attendance();
                    break;
                case 10:
                    Holiday();
                    break;
                case 11:
                    check = false;
                    break;
                default:
                    System.out.println(" Invalid Input..!");
            }
        }
    }
    private void ActiveAndDeactive() {
        boolean check3 = true;
        while (check3) {
            System.out.println(">>>>> Deactivate & Activate  Employee <<<<<\n1- Activate.\n2- Deactivate.\n3- Exit.");
            int optionAc = s.nextInt();
            s.nextLine();
            switch (optionAc) {
                case 1:
                    System.out.println(">>>>> Activate  Employee <<<<<");
                    System.out.println("Enter Id:");
                    String checkActivate = s.next();
                    for (int i = 0; i < arrManager.size(); i++) {
                        if (arrManager.get(i).getId().equals(checkActivate)) {
                            arrManager.get(i).setStatus(1);
                            System.out.println("The account has been activate.");
                        }
                    }
                    break;
                case 2:
                    System.out.println(">>>>> Deactivate  Employee <<<<<");
                    System.out.println("Enter Id:");
                    String checkDeactivate = s.next();
                    for (int i = 0; i < arrManager.size(); i++) {
                        if (arrManager.get(i).getId().equals(checkDeactivate)) {
                            arrManager.get(i).setStatus(0);
                            System.out.println("The account has been Deactivate.");
                        }
                    }
                    break;
                case 3:
                    check3 = false;
                    break;
                default:
                    System.out.println("Invalid Input..! ");
            }
        }
    }
    public void attendance() {
        boolean checkForWhile = true;
        while (checkForWhile) {
            System.out.println(">>>>> Attendance <<<<<\n1- Time of attendance.\n2- Time of leave.\n3- Exit");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println(">>>>> Time of attendance <<<<<");
                    for (int j = 0; j < Admin.arrAdmin.size(); j++) {
                        if (Main.idManager.equals(Admin.arrAdmin.get(j).getId())) {
                            System.out.println("Enter the time");
                            String timeAttendance = s.next();
                            s.nextLine();
                            Admin.arrAdmin.get(j).setCheckIn(timeAttendance);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println(">>>>> Time of leave <<<<<");
                    for (int j = 0; j < Admin.arrAdmin.size(); j++) {
                        if (Main.idManager.equals(Admin.arrAdmin.get(j).getId())) {
                            System.out.println("Enter the time");
                            String timeLeave = s.next();
                            s.nextLine();
                            Admin.arrAdmin.get(j).setCheckout(timeLeave);
                            break;
                        }
                    }
                    break;
                case 3:
                    checkForWhile = false;
                    break;
                default:
                    System.out.println("Invalid Input...");
            }
        }
    }
    public void Holiday() {
        boolean checkForWhile = true;
        while (checkForWhile) {
            System.out.println(">>>>> Holiday <<<<<\n1- My Holiday.\n2- Create Holiday.\n3- Exit");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println(">>>>> My Holiday <<<<<");
                    reportHoliday();
                    break;
                case 2:
                    System.out.println(">>>>> Create Holiday <<<<<");
                    setId(Main.idManager);
                    System.out.println("Enter Name");
                    setName(s.next());
                    s.nextLine();
                    System.out.println("Enter Reason");
                    setReason(s.nextLine());
                    System.out.println("Enter Details");
                    setDetails(s.nextLine());
                    System.out.println("Enter Date");
                    setDate(s.nextLine());
                    Holiday.arrHolidayManager.add(new Holiday(getId(), getName(), getReason(), getDetails(), getDate()));
                    break;
                case 3:
                    checkForWhile = false;
                    break;
                default:
                    System.out.println("Invalid Input..!");
            }
        }
    }
    @Override
    public void search() {
        System.out.println("Name: " + getName() + " || Status: " + getStatus());
    }

    @Override
    public void report() {
        System.out.println("Id: " + getId() + "  name: " + getName() + " password: " + getPassword() + "  email: " + getEmail() + "  phone: " + getPhoneNumber()
                + "  status: " + getStatus() + " Type Emp:" + typeEmp + "  check in: " + getCheckin() + "  check out: " + getCheckout());
    }

    public void reportHoliday() {
        for (int i = 0; i < Holiday.arrHolidayManager.size(); i++) {
            if (Holiday.arrHolidayManager.get(i).getId().equals(Main.idManager)) {
                System.out.println("Id: " + Holiday.arrHolidayManager.get(i).getId() + "  name: " + Holiday.arrHolidayManager.get(i).getName() + "  Reason: " + Holiday.arrHolidayManager.get(i).getReason() + "  Details: " + Holiday.arrHolidayManager.get(i).getDetails()
                        + "  Date: " + Holiday.arrHolidayManager.get(i).getDate() + " Check: " + Holiday.arrHolidayManager.get(i).getCheck());
            }
        }
    }

    public int getType() {
        return typeEmp;
    }
    public void setType(int typeEmp) {
        this.typeEmp = typeEmp;
    }
}

