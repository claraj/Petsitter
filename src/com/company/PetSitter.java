package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PetSitter {

    static String[] daysOfWeek = {"Monday", "Tuesday" , "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private static int maxVisitsPerDay = 6;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Pet> listOfPets = new ArrayList<Pet>();

        while (true) {

            System.out.println("Enter name of pet (or press enter to stop)");
            String name = scanner.nextLine();

            if (name.isEmpty()) { break; }   //Break the loop if user doesn't enter anything

            System.out.println("Enter name address of " + name);
            String address = scanner.nextLine();

            Pet pet = new Pet(name, address);

            System.out.println("Please enter the number of times you'll visit " + name + " on each of these days of the week");
            for (int day = 0 ; day < 7 ; day++ ) {
                System.out.println("How many times will you visit on " + daysOfWeek[day]);
                int timesVisited = Integer.parseInt(scanner.nextLine()); //TODO validation!
                pet.setTimesVisited(day, timesVisited);
            }

            System.out.println("Here's all of the data about this pet");
            pet.displayAllData();

            listOfPets.add(pet);

        }

        displaySchedule(listOfPets);

        scanner.close();

        System.out.println("Thanks for using the program!");
    }


    private static void displaySchedule(ArrayList<Pet> listOfPets) {

        for (int day = 0 ; day < 7 ; day++)  {

            int  totalVisitsOnThisDay = 0;
            System.out.println("** " + daysOfWeek[day] + " Schedule **");
            for (Pet p : listOfPets) {
                if (p.getTimesVisited(day) != 0) {
                    int visits = p.getTimesVisited(day);
                    totalVisitsOnThisDay += visits;
                    System.out.println("Visit " + p.getName() + " at " + p.getAddress() + " " + visits + " time(s)");
                    if (totalVisitsOnThisDay > maxVisitsPerDay) {
                        System.out.println("** Warning! More than " + maxVisitsPerDay + " visits to pets today **");
                    }
                }
            }

        }


    }

}
