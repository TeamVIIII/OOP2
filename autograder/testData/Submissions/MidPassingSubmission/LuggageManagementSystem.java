import java.time.LocalDateTime;
//816029808

import java.util.Scanner;
import java.io.File;

public class LuggageManagementSystem {
    public static void main(String[] args) 
    {
        String name1 = "FlightList.txt";
        
        String flightNo = "";
        String desti = "";
        String origin = "";
        String strDate = "1111-11-11T11:11:11";
        
        LocalDateTime d = LocalDateTime.parse(strDate);
        Flight yyz = new Flight(flightNo, desti, origin, d);
        
        try
        {
            File file = new File(name1);
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNext())
            {
                flightNo = scanner.next();
                desti = scanner.next();
                origin = scanner.next();
                strDate = scanner.next();
                
                d = LocalDateTime.parse(strDate);
                yyz = new Flight(flightNo, desti, origin, d);
                
                System.out.println(yyz);
            }
        }
        catch (Exception e)
        {
            System.out.println("File not found");
        }
        
        
        String name2 = "PassengerList.txt";
        
        String ppNum = "";
        String fName = "";
        String lName = "";
        String passFlightNo = "";
        
        try
        {
            File file2 = new File(name2);
            Scanner scanner2 = new Scanner(file2);
            
            while(scanner2.hasNext())
            {
                ppNum = scanner2.next();
                fName = scanner2.next();
                lName = scanner2.next();
                passFlightNo = scanner2.next();
                
                Passenger p = new Passenger(ppNum, fName, lName, passFlightNo);
                System.out.println(p);
                System.out.println(yyz.checkInLuggage(p));
            }
        }
        catch (Exception e)
        {
            System.out.println("File not found");
        }
        
         System.out.println(yyz.printLuggageManifest());
    }
}
