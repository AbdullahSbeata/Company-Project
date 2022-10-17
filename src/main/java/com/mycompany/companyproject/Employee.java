package com.mycompany.companyproject;
import java.io.Serializable;

public class Employee extends Manager implements Serializable {

    public Employee(){}

    public void employee() {
        boolean check = true;
        while (check) {
            System.out.println(">>>>> Employee <<<<<\n1- Change Password.\n2- Attendance.\n3- Holiday.\n4- Exit.");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    boolean checkFor = true;
                    for (int i = 0; i < Manager.arrManager.size(); i++) {
                        if (Main.idEmployee.equals(Manager.arrManager.get(i).getId())) {
                            System.out.println(">>>>> Change Password <<<<<");
                            System.out.println("Enter new password :");
                            String newPassword = s.next();
                            s.nextLine();
                            Manager.arrManager.get(i).setPassword(newPassword);
                            checkFor = false;
                            System.out.println("The password was successful changed.");
                            break;
                        }
                    }
                    if (checkFor) {
                        System.out.println("Error in change..! ");
                    }
                    break;
                case 2:
                    attendance();
                    break;
                case 3:
                    Holiday();
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Invalid Input..!");
            }
        }
    }
    @Override
    public void Holiday() {
        boolean checkForWhile = true;
        while (checkForWhile) {
            System.out.println(">>>>> Holiday <<<<<\n1- My Holiday.\n2- Create Holiday.\n3- Exit.");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println(">>>>> My Holiday <<<<<");
                    reportHoliday();
                    break;
                case 2:
                    System.out.println(">>>>> Create Holiday <<<<<");
                    setId(Main.idEmployee);
                    System.out.println("Enter Name");
                    setName(s.next());
                    s.nextLine();
                    System.out.println("Enter Reason");
                    setReason(s.nextLine());
                    System.out.println("Enter Details");
                    setDetails(s.nextLine());
                    System.out.println("Enter Date");
                    setDate(s.nextLine());
                    Holiday.arrHolidayEmployee.add(new Holiday(getId(), getName(), getReason(), getDetails(), getDate()));
                    break;
                case 3:
                    checkForWhile = false;
                    break;
                default:
                    System.out.println("Invalid Input...");
            }
        }
    }
    @Override
    public void attendance() {
        boolean checkForWhile = true;
        while (checkForWhile) {
            System.out.println(">>>>> Attendance <<<<<\n1- Time of attendance.\n2- Time of leave.\n3- Exit.");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println(">>>>> Time of attendance <<<<<");
                    for (int j = 0; j < Manager.arrManager.size(); j++) {
                        if (Main.idEmployee.equals(Manager.arrManager.get(j).getId())) {
                            System.out.println("Enter the time");
                            String timeAttendance = s.next();
                            s.nextLine();
                            Manager.arrManager.get(j).setCheckIn(timeAttendance);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println(">>>>> Time of leave <<<<<");
                    for (int j = 0; j < Manager.arrManager.size(); j++) {
                        if (Main.idEmployee.equals(Manager.arrManager.get(j).getId())) {
                            System.out.println("Enter the time");
                            String timeLeave = s.next();
                            s.nextLine();
                            Manager.arrManager.get(j).setCheckout(timeLeave);
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
    @Override
    public void reportHoliday() {
        for (int i = 0; i < Holiday.arrHolidayEmployee.size(); i++) {
            if (Holiday.arrHolidayEmployee.get(i).getId().equals(Main.idEmployee)) {
                System.out.println("Id: " + Holiday.arrHolidayEmployee.get(i).getId() + "  name: " + Holiday.arrHolidayEmployee.get(i).getName() + "  Reason: " + Holiday.arrHolidayEmployee.get(i).getReason() + "  Details: " + Holiday.arrHolidayEmployee.get(i).getDetails()
                        + "  Date: " + Holiday.arrHolidayEmployee.get(i).getDate() + " Check: " + Holiday.arrHolidayEmployee.get(i).getCheck());
            }
        }
    }
}

