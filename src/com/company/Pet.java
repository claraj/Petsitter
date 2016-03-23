package com.company;

/**
 * Created by Clara on 3/23/16.
 */
public class Pet {

    String name;
    String address;
    int[] timesVisited = new int[7];

    Pet(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setTimesVisited(int dayOfWeek, int timesVisitedOnThisDay) {
        timesVisited[dayOfWeek] = timesVisitedOnThisDay;
    }

    public int getTimesVisited(int dayOfWeek) {
        return timesVisited[dayOfWeek];
    }

    public void displayAllData() {

        System.out.println("Pet name:" + name);
        System.out.println("Pet address:" + address);
        System.out.println("Weekly Schedule");
        for (int day = 0 ; day < 7 ; day++ ) {
            System.out.println(PetSitter.daysOfWeek[day] + ": " + timesVisited[day] + " visit(s)");
        }

    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
}
