package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Pattern;

// reads inventory file and converts text into Dealership object
// takes Dealership object and save into inventory file
public class DealershipFileManager {
    public static Dealership getDealership() {
        String fileName = "inventory.csv";
        Dealership dealership = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            // split first line from file
            String line = bufferedReader.readLine();
            String[] parts = line.split(Pattern.quote("|"));
            String name = parts[0];
            String address = parts[1];
            String phone = parts[2];

            // create Dealership
            dealership = new Dealership(name, address, phone);

            //loop goes through every line in file
            while ((line = bufferedReader.readLine()) != null) {
                // convert each line to Vehicle object
                Vehicle v = getVehicleFromLine(line);

                // add vehicle to dealership
                dealership.addVehicle(v);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found. Please try again.");
        } catch (IOException e) {
            System.out.println("△ Something went wrong. Please try again.");
        }
        return dealership;
    }

    public static Vehicle getVehicleFromLine(String line) {
        // split each line into parts
        // vin/year/make/model/vehicleType/color/odometer/price
        try {
            String[] parts = line.split(Pattern.quote("|"));

            int vin = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[1]);
            String make = parts[2];
            String model = parts[3];
            String vehicleType = parts[4];
            String color = parts[5];
            int odometer = Integer.parseInt(parts[6]);
            BigDecimal price = new BigDecimal(parts[7]);

            return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        } catch (Exception e) {
            System.out.println("△ Something went wrong. Please try again.");
            return null;
        }
    }

    public static void saveDealership(Dealership d) {

    }
}
