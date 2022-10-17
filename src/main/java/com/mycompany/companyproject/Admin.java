package com.mycompany.companyproject;
import java.io.*;
import java.util.*;

public class Admin extends Parent implements Serializable {

    static ArrayList<Admin> arrAdmin = new ArrayList<>();

    public Admin(String id, String name, String password, String email, String phoneNumber, int status) {
        super(id, name, password, email, phoneNumber, status);
    }

    public Admin() {
    }

    public void admin() {
        boolean check1 = true;
        while (check1) {
            System.out.println(">>>>> Admin <<<<< \n1- Add Manager. \n2- Update Manager.\n3- Delete manager.\n4- Search about Manager.\n5- Report about Manager."
                    + "\n6- Report about All Managers.\n7- Holiday requests.\n8- Deactivate & Activate Manager.\n9- Get Manager count and Employee count.\n10- Exit.");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    boolean isExit = false;
                    System.out.println(">>>>> Add Manager <<<<<");
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
                    System.out.println("Enter status :");
                    setStatus(s.nextInt());
                    for (int i = 0; i < arrAdmin.size(); i++) {
                        if (arrAdmin.get(i).getId().equals(id)) {
                            isExit = true;
                            break;
                        }
                    }
                    for (int j = 0; j < Manager.arrManager.size(); j++) {
                        if (Manager.arrManager.get(j).getId().equals(id)) {
                            isExit = true;
                            break;
                        }
                    }
                    if (isExit) {
                        System.out.println("Sorry, This id exists");
                    } else {
                        arrAdmin.add(new Admin(getId(), getName(), getPassword(), getEmail(), getPhoneNumber(), getStatus()));
                        System.out.println("The manager has been successful added.");
                    }
                    break;
                case 2:
                    boolean isNotUpdate = true;
                    System.out.println(">>>>> Update Manager <<<<<");
                    System.out.println("Enter id : ");
                    String update = s.next();
                    for (int i = 0; i < arrAdmin.size(); i++) {
                        if (arrAdmin.get(i).getId().equals(update)) {
                            System.out.println("New password :");
                            String newPassword = s.next();
                            s.nextLine();
                            arrAdmin.get(i).setPassword(newPassword);
                            isNotUpdate = false;
                            System.out.println("The manager's data was successful updated.");
                            break;
                        }
                    }
                    if (isNotUpdate) {
                        System.out.println("Error in updated..!");
                    }
                    break;
                case 3:
                    boolean isNotDelete = true;
                    System.out.println(" >>>>> Delete Manager <<<<<");
                    System.out.println("Enter id :");
                    String delete = s.next();
                    for (int i = 0; i < arrAdmin.size(); i++) {
                        if (arrAdmin.get(i).getId().equals(delete)) {
                            arrAdmin.remove(i);
                            isNotDelete = false;
                            System.out.println("The manager has been successful deleted.");
                            break;
                        }
                    }
                    if (isNotDelete) {
                        System.out.println("Error in deleted..!");
                    }
                    break;
                case 4:
                    boolean isNotSearch = true;
                    System.out.println(">>>>> Search about Manager <<<<<");
                    System.out.println("Enter id :");
                    String search = s.next();
                    for (int i = 0; i < arrAdmin.size(); i++) {
                        if (arrAdmin.get(i).getId().equals(search)) {
                            arrAdmin.get(i).search();
                            isNotSearch = false;
                            break;
                        }
                    }
                    if (isNotSearch) {
                        System.out.println("Error in search..!");
                    }
                    break;
                case 5:
                    boolean isNotReport = true;

                    System.out.println(">>>>> Report about Manager <<<<<");
                    System.out.println("Enter id or name :");
                    String idOrName = s.next();
                    s.nextLine();
                    for (int i = 0; i < arrAdmin.size(); i++) {
                        if (arrAdmin.get(i).getId().equals(idOrName) || (arrAdmin.get(i).getName().equalsIgnoreCase(idOrName))) {
                            arrAdmin.get(i).report();
                            isNotReport = false;
                            break;
                        }
                    }
                    if (isNotReport) {
                        System.out.println("Error in report..!");
                    }
                    break;
                case 6:
                    System.out.println(">>>>> Report about All Manager <<<<<\n>>>>> Choose the view of the data on the screen <<<<<\n1- Ascending order by Name.\n2- Descending order by Name.");
                    int order = s.nextInt();
                    System.out.println(">>>>> Finall Report <<<<<");
                    switch (order) {
                        case 1:
                            arrAdmin.sort((object1, object2) -> object1.getName().compareTo(object2.getName()));
                            for (int i = 0; i < arrAdmin.size(); i++) {
                                arrAdmin.get(i).report();
                            }
                            break;
                        case 2:
//                                arrAdmin.sort((object1, object2) -> object2.getName().compareTo(object1.getName()));
//                                for (int i = 0; i < arrAdmin.size(); i++) {
//                                    arrAdmin.get(i).report();
//                                }
                            arrAdmin.sort((object1, object2) -> object1.getName().compareTo(object2.getName()));
                            for (int i = arrAdmin.size() - 1; i >= 0; i--) {
                                arrAdmin.get(i).report();
                            }
                            break;
                        default:
                            System.out.println("Invalid Input..!");
                    }
                    break;
                case 7:
                    boolean check2 = true;
                    while (check2) {
                        System.out.println(">>>>> Holiday requests <<<<<\n1- View Holiday requests.\n2- Accept the holiday.\n3- Rejected the holiday.\n4- Exit.");
                        int optionHoliday = s.nextInt();
                        switch (optionHoliday) {
                            case 1:
                                System.out.println(">>>>> View Holiday requests <<<<<");
                                reportRequestHoliday();
                                break;
                            case 2:
                                System.out.println(">>>>> Accept the holiday <<<<<");
                                System.out.println("Enter id :");
                                String checkAccept = s.next();
                                for (int i = 0; i < Holiday.arrHolidayManager.size(); i++) {
                                    if (Holiday.arrHolidayManager.get(i).getId().equals(checkAccept)) {
                                        Holiday.arrHolidayManager.get(i).setCheck(1);
                                    }
                                }
                                for (int i = 0; i < Holiday.arrHolidayEmployee.size(); i++) {
                                    if (Holiday.arrHolidayEmployee.get(i).getId().equals(checkAccept)) {
                                        Holiday.arrHolidayEmployee.get(i).setCheck(1);
                                    }
                                }
                                break;

                            case 3:
                                System.out.println(">>>>> Rejected the holiday <<<<<");
                                System.out.println(" Enter id :");
                                String checkrejected = s.next();
                                for (int i = 0; i < Holiday.arrHolidayManager.size(); i++) {
                                    if (Holiday.arrHolidayManager.get(i).getId().equals(checkrejected)) {
                                        Holiday.arrHolidayManager.get(i).setCheck(2);
                                    }
                                }
                                for (int i = 0; i < Holiday.arrHolidayEmployee.size(); i++) {
                                    if (Holiday.arrHolidayEmployee.get(i).getId().equals(checkrejected)) {
                                        Holiday.arrHolidayEmployee.get(i).setCheck(2);
                                    }
                                }
                                break;
                            case 4:
                                check2 = false;
                                break;
                            default:
                                System.out.println("Invalid Input..!");
                        }
                    }
                    break;
                case 8:
                    ActiveAndDeactive();
                    break;

                case 9:
                    System.out.println(">>>>> Get Manager count and Employee count <<<<<");
                    System.out.println(" -Manager Count " + Admin.arrAdmin.size());
                    System.out.println(" -Employee Count " + Manager.arrManager.size());
                    break;
                case 10:
                    check1 = false;
                    break;
                default:
                    System.out.println("Invalid Input..! ");
            }
        }
    }

    private void ActiveAndDeactive() {
        boolean check3 = true;
        while (check3) {
            System.out.println(">>>>> Deactivate & Activate Manager <<<<<\n1- Activate.\n2- Deactivate.\n3- Exit.");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println(" >>>>> Activate Manager <<<<<");
                    System.out.println("Enter Id :");
                    String checkActivate = s.next();
                    for (int i = 0; i < arrAdmin.size(); i++) {
                        if (arrAdmin.get(i).getId().equals(checkActivate)) {
                            arrAdmin.get(i).setStatus(1);
                            System.out.println("The account has been activate.");
                        }
                    }
                    break;
                case 2:
                    System.out.println(" >>>>> Deactivate Manager <<<<<");
                    System.out.println("Enter Id : ");
                    String checkDeactivate = s.next();
                    for (int i = 0; i < arrAdmin.size(); i++) {
                        if (arrAdmin.get(i).getId().equals(checkDeactivate)) {
                            arrAdmin.get(i).setStatus(0);
                            System.out.println("The account has been Deactivate.");
                        }
                    }
                    break;
                case 3:
                    check3 = false;
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
        System.out.println("Id: " + getId() + " || name: " + getName() + " || Password: " + getPassword() + " || email: " + getEmail() + " || phone: " + getPhoneNumber()
                + " || status: " + getStatus() + " || check in: " + getCheckin() + " || check out: " + getCheckout());
    }

    public void reportRequestHoliday() {
        for (int i = 0; i < Holiday.arrHolidayManager.size(); i++) {
            if (Holiday.arrHolidayManager.get(i).getCheck() == 0) {
                System.out.println("Id: " + Holiday.arrHolidayManager.get(i).getId() + " Name: " + Holiday.arrHolidayManager.get(i).getName() + " Reason: " + Holiday.arrHolidayManager.get(i).getReason() + " Details: " + Holiday.arrHolidayManager.get(i).getDetails() + " Date: " + Holiday.arrHolidayManager.get(i).getDate());
            }
        }
        for (int i = 0; i < Holiday.arrHolidayEmployee.size(); i++) {
            if (Holiday.arrHolidayEmployee.get(i).getCheck() == 0) {
                System.out.println("Id: " + Holiday.arrHolidayEmployee.get(i).getId() + " Name: " + Holiday.arrHolidayEmployee.get(i).getName() + " Reason: " + Holiday.arrHolidayEmployee.get(i).getReason() + " Details: " + Holiday.arrHolidayEmployee.get(i).getDetails() + " Date: " + Holiday.arrHolidayEmployee.get(i).getDate());
            }
        }
    }
}


