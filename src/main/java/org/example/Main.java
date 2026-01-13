package org.example;

import org.example.io.EventFileReader;
import org.example.io.GiftFileReader;
import org.example.io.TributFileReader;
import org.example.io.TributFileWriter;
import org.example.model.Event;
import org.example.model.Gift;
import org.example.model.Tribut;
import org.example.service.EventStats;
import org.example.service.TributStats;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try { // 1
            ArrayList<Tribut> tributes = new TributFileReader().readFromResources("tributes.json");
            ArrayList<Event> events = new EventFileReader().readFromResources("events.json");
            ArrayList<Gift> gifts = new GiftFileReader().readFromResources("gifts.json");
            System.out.println("Tributes: " + tributes.size());
            System.out.println("Events: " + events.size());
            System.out.println("Gifts: " + gifts.size());

            // 2
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Input district: ");
                int district = Integer.parseInt(scanner.nextLine().trim());

                TributStats tributStats = new TributStats();
                tributStats.filterByDistrict(tributes, district)
                        .forEach(System.out::println);
            }

            // 3
            TributStats tributStats = new TributStats();
            List<Tribut> sortedTributes = tributStats.sortBySkillThanName(tributes);
            sortedTributes.forEach(System.out::println);

            // 4
            new TributFileWriter().writeToFile(sortedTributes, "tributes_sorted.txt");

            // 5
            EventStats eventStats = new EventStats();
            eventStats.printFirstFiveComputedPoints(events);
        } catch (IOException e) {
            System.out.println("Failed to read resources: " + e.getMessage());
        }
    }
}
