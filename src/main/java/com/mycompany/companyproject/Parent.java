package com.mycompany.companyproject;
import java.io.*;
import java.util.*;
public abstract class Parent implements Serializable {
        public static Scanner s =new Scanner(System.in);
        private String id;
        private String phoneNumber;
        private String email;
        private String password;
        private String name;
        private String reason,details,date,checkin,checkout;
        private int check = 0;
        private int status;
        public Parent(String id, String name, String password, String email, String phoneNumber, int status) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.status = status;
        }
        public Parent(String id, String name, String reason, String details, String date) {
            this.id = id;
            this.name = name;
            this.reason = reason;
            this.details = details;
            this.date = date;
        }
        public Parent(){}
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        public int getStatus() {
            return status;
        }
        public void setStatus(int status) {
            this.status = status;
        }
        public String getReason() {
            return reason;
        }
        public void setReason(String reason) {
            this.reason = reason;
        }
        public String getDetails() {
            return details;
        }
        public void setDetails(String details) {
            this.details = details;
        }
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public String getCheckin() {
            return checkin;
        }
        public void setCheckIn(String checkin) {
            this.checkin = checkin;
        }
        public String getCheckout() {
            return checkout;
        }
        public void setCheckout(String checkout) {
            this.checkout = checkout;
        }
        public void setCheck(int check) {
            this.check = check;
        }
        public int getCheck() {
            return check;
        }
        abstract void search();
        abstract void report();
}