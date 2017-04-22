package com.example.jaychou.hackathon3;

/**
 * Created by jaychou on 4/22/17.
 */
/* The Week Class */

/* The Week Class */

import java.util.*;

public class Week{
    public Day monday;
    public Day tuesday;
    public Day wednesday;
    public Day thursday;
    public Day friday;

    public Week(List<Course> cs){
        this.monday = Day.getDay(cs, "M");
        this.tuesday = Day.getDay(cs, "T");
        this.wednesday = Day.getDay(cs, "W");
        this.thursday = Day.getDay(cs, "TH");
        this.friday = Day.getDay(cs, "F");
    }

    public String toString(){
        String s = "";
        s += "Monday\n" + monday.toString() + "\n";
        s += "Tuesday\n" + tuesday.toString() + "\n";
        s += "Wednesday\n" + wednesday.toString() + "\n";
        s += "Thursday\n" + thursday.toString() + "\n";
        s += "Friday\n" + friday.toString() + "\n";
        return s;
    }

    public static void main(String[] args){
        List<Course> cs = new ArrayList<Course>();
        cs.add(new Course("MATH110101", "M W F 9", null));
        cs.add(new Course("PHYS120001", "M W F 4 30*", null));
        cs.add(new Course("CSCI120001", "M W F 12 30", null));
        cs.add(new Course("CSCI300001", "M W F 3", null));
        cs.add(new Course("MATH880801", "M W F 6", null));
        Week week = new Week(cs);
        System.out.println(week.toString());

    }
}

