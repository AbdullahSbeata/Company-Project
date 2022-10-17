package com.mycompany.companyproject;
import java.util.*;
public class Holiday extends Parent {
    public Holiday(String id, String name, String reason, String details, String date) {
        super(id,name,reason,details,date);
    }
    static ArrayList<Holiday> arrHolidayManager = new ArrayList<Holiday>();
    static ArrayList<Holiday> arrHolidayEmployee = new ArrayList<Holiday>();

    @Override
    void search(){}
    @Override
    void report(){}
}
