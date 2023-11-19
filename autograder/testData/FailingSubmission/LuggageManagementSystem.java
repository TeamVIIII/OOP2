import java.time.LocalDateTime;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException; 
import java.util.Scanner;
import java.util.ArrayList;

public class LuggageManagementSystem{   
    public static void main(String[] args){
        LocalDateTime time = LocalDateTime.now();
        String flightNo = "";
        String destination = "";
        String origin = "";
        int counter = 0;
        String passportNo = "";
        String firstName = "";
        String lastName = "";
        
        String passenger = "PassengerList.txt";
        String flight = "FlightList.txt";
        
        try(BufferedReader br = new BufferedReader(new FileReader(flight));
            BufferedReader br2 = new BufferedReader(new FileReader(passenger))){
           String flightData = null;
           String passengerData = null;
           
           while((flightData = br.readLine()) != null){
               String fTemp[] = flightData.split(" ");
               flightNo = fTemp[0];
               destination = fTemp[1];
               origin = fTemp[2];
               
               Flight f = new Flight(flightNo, destination, origin, time);
               System.out.println(f);
               System.out.println(f.printLuggageManifest());
               System.out.println(f.toString());
           }
            Flight f = new Flight(flightNo, destination, origin, time);

           while((passengerData = br2.readLine())!= null){
                  String pTemp[] = passengerData.split(" ");
                  passportNo = pTemp[0];
                  firstName = pTemp[1];
                  lastName = pTemp[2];
              
                  Passenger passengerText = new Passenger(passportNo, firstName,
                                                      lastName, flightNo);
                  
                  System.out.println(f.checkInLuggage(passengerText));
                  System.out.println(passengerText.toString());
                  
                  
                counter++;
              }
        }
    
        catch(Exception e){
            System.out.println("error: " + e);
        }
        
        
    }
}
