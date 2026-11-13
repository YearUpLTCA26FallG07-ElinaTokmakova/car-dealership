package com.pluralsight;

public class UserInterface {
    private Dealership dealership;

    private UserInterface() {
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display() {
       new UserInterface();
        int selectedOption;

       do {
           selectedOption = com.pluralsight.models.Console.promptForInt("""
                                 \\n╔════════════════════════════════════════╗
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

    public void processGetByPriceRequest(){
    }

    public void processGetByMakeModelRequest(){
    }

    public void processGetByYearRequest(){
    }

    public void processGetByColorRequest(){

    }

    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }

    public void processGetAllVehiclesRequest(){

    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest(){
    }
}
