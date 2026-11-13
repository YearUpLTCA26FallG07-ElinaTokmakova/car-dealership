package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Locale;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }

    private void init() {
       this.dealership = DealershipFileManager.getDealership();
    }

    public void display() {
        init();
        int selectedOption;

       do {
           selectedOption = com.pluralsight.models.Console.promptForInt("""
                                 \n╔══════════════════════════════════════════╗
                                 ║               car dealership             ║
                                 ║        ~~~~~~~~~~~~~~~~~~~~~~~~~~~       ║
                                 ║  [1] find vehicles within a price range  ║
                                 ║  [2] find vehicles by make / model       ║
                                 ║  [3] find vehicles by year range         ║
                                 ║  [4] find vehicles by color              ║
                                 ║  [5] find vehicles by mileage range      ║
                                 ║  [6] find vehicles by type               ║
                                 ║  [7] view all vehicles                   ║
                                 ║  [8] add a vehicle                       ║
                                 ║  [9] remove a vehicle                    ║
                                 ║  [10] quit                               ║
                                 ╚══════════════════════════════════════════╝
                                 Select an option (1-10): """);

           switch(selectedOption){
               case 1 -> processGetByPriceRequest();
               case 2 -> processGetByMakeModelRequest();
               case 3 -> processGetByYearRequest();
               case 4 -> processGetByColorRequest();
               case 5 -> processGetByMileageRequest();
               case 6 -> processGetByVehicleTypeRequest();
               case 7 -> processGetAllVehiclesRequest();
               case 8 -> processAddVehicleRequest();
               case 9 -> processRemoveVehicleRequest();
               case 10 -> {}
               default -> System.out.println("\n△ Invalid command, please try again.");
           }
       } while(selectedOption != 10);
    }

    // helper method – displays list and can be called from all search
    // and get vehicles type of methods
    private void displayVehicles(ArrayList<Vehicle> selectedVehicles) {

        System.out.println("""
                \n╔═══════╦══════╦═══════════════╦════════════════╦══════════╦═══════════╦════════════╦═════════════╗
                ║ vin   ║ year ║ make          ║ model          ║ type     ║ color     ║   odometer ║       price ║
                ╠═══════╬══════╬═══════════════╬════════════════╬══════════╬═══════════╬════════════╬═════════════╣""");

        for (Vehicle v : selectedVehicles) {
            System.out.println(v);
        }
    }

    public void processGetByPriceRequest(){

        // user input
        BigDecimal min = com.pluralsight.models.Console.promptForBigDecimal("Enter minimum price range (e.g. 5000): ");
        BigDecimal max = com.pluralsight.models.Console.promptForBigDecimal("Enter maximum price range (press Enter↵ to skip): ");

        ArrayList<Vehicle> result = dealership.getVehiclesByPrice(min, max);
        displayVehicles(result);
    }

    public void processGetByMakeModelRequest(){

        // user input
        String make;
        do {
            make = com.pluralsight.models.Console.promptForString("Enter make: ").trim().toLowerCase();
        } while (make.isEmpty());
        String model = com.pluralsight.models.Console.promptForString("Enter model (press Enter↵ to skip): ").trim().toLowerCase();

        ArrayList<Vehicle> result = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(result);
    }

    public void processGetByYearRequest(){

        // user input
        int min;
        int max;
        min = com.pluralsight.models.Console.promptForInt("Enter start of year range (press Enter↵ to skip): ");
        max = com.pluralsight.models.Console.promptForInt("Enter end of year range (press Enter↵ to skip): ");

        ArrayList<Vehicle> result = dealership.getVehiclesByYear(min, max);
        displayVehicles(result);
    }

    public void processGetByColorRequest(){

        // user input
        String color = com.pluralsight.models.Console.promptForString("Enter color: ").trim().toLowerCase();

        ArrayList<Vehicle> result = dealership.getVehiclesByColor(color);
        displayVehicles(result);
    }

    public void processGetByMileageRequest(){

        // user input
        int min;
        int max;
        min = com.pluralsight.models.Console.promptForInt("Enter minimum mileage (press Enter↵ to skip): ");
        max = com.pluralsight.models.Console.promptForInt("Enter maximum mileage (press Enter↵ to skip): ");

        ArrayList<Vehicle> result = dealership.getVehiclesByMileage(min, max);
        displayVehicles(result);
    }

    public void processGetByVehicleTypeRequest(){

        // user input
        String vehicleType = com.pluralsight.models.Console.promptForString("Enter type (car/SUV/coupe/truck/sedan/van): ").trim().toLowerCase();

        ArrayList<Vehicle> result = dealership.getVehiclesByType(vehicleType);
        displayVehicles(result);
    }

    public void processGetAllVehiclesRequest(){
        ArrayList<Vehicle> allVehicles = this.dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public void processAddVehicleRequest() {
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        B
        // user input
        do {
            int vin = com.pluralsight.models.Console.promptForInt("Enter vin (vehicle identification number):");
        } w
        int year = com.pluralsight.models.Console.promptForInt("Enter model year: ");
        String make = com.pluralsight.models.Console.promptForString("Enter make: ");
        String model = com.pluralsight.models.Console.promptForString("Enter model: ");
        String vehicleType = com.pluralsight.models.Console.promptForString("Enter vehicle type: ");
        String color = com.pluralsight.models.Console.promptForString("Enter color: ");
        int odometer = com.pluralsight.models.Console.promptForInt("Enter mileage: ");
        BigDecimal price = com.pluralsight.models.Console.promptForBigDecimal("Enter price: ");
        price.setScale(2, RoundingMode.HALF_UP);

        // create new vehicle
        Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        dealership.addVehicle(v);

        //success message
        System.out.println("Vehicle is successfully added to inventory.");
    }

    public void processRemoveVehicleRequest(){
    }
}
