package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType; // car, truck, etc.
    private String color;
    private int odometer;
    private BigDecimal price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, BigDecimal price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("""
                ║ %-5d ║ %-4d ║ %-13s ║ %-14s ║ %-8s ║ %-9s ║ %10d ║ %11.2f ║""",
                vin, year, make, model, vehicleType, color, odometer, price);
    }

    // use for adding new vehicles to .csv file
    public String toEncodedString(){
        return "\n" + getVin() + "|" + getYear() + "|" + getMake() + "|" + getModel()
                + "|" + getVehicleType() + "|" + getColor() + "|" + getOdometer() + "|" + getPrice();
    }
}
