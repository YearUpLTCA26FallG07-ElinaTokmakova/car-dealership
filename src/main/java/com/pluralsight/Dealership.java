package com.pluralsight;

import com.pluralsight.Console;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {

        // if price within range – add to result list
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice().compareTo(min) >= 0 && v.getPrice().compareTo(max) <= 0) {
                result.add(v);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

        // if make and model matches – add to result list
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().toLowerCase().contains(make) &&
                    (v.getModel().toLowerCase().contains(model) || v.getModel().isEmpty())) {
                result.add(v);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {

        // if years within range – add to result list
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if ((v.getYear() >= min && v.getYear() <= max) ||
                    (v.getYear() >= min && max == 0)) {
                result.add(v);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {

        // if color matches – add to result list
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().toLowerCase().contains(color)) {
                result.add(v);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {

        // if odometer within range – add to result list
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if ((v.getOdometer() >= min && v.getOdometer() <= max) ||
                    (v.getOdometer() >= min && max == 0)) {
                result.add(v);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {

        // if type matches – add to result list
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleType().toLowerCase().contains(vehicleType)) {
                result.add(v);
            }
        }
        return result;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle v) {
        if (v != null && !inventory.contains(v)) {
            inventory.add(v);
        }
    }

    public void removeVehicle(int vin) {
        inventory.removeIf(v -> v.getVin() == vin);
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                "\ninventory=" + inventory +
                '}';
    }

    // formats dealership to save in inventory.csv file
    public String toEncodedString() {
        StringBuilder result = new StringBuilder();
        result.append(name + "|" + address + "|" + phone);

        for (Vehicle v : inventory) {
            result.append(v.toEncodedString());
        }

        return result.toString();
    }
}
