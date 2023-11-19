import java.time.LocalDateTime;
/**
 * Write a description of class Flight here.
 *
 * @author (Jardel Mitchell)
 * @version (10/02/2023)
 */
public class Flight{
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LuggageManifest manifest;
    
    //Accessors    
    public String getFlightNo(){
        return flightNo;
    }
    public String getDestination(){
        return flightNo;
    }
    public String getOrigin(){
        return flightNo;
    }
    public LocalDateTime getFlightDate(){
        return flightDate;
    }
    public LuggageManifest getManifest(){
        return manifest;
    }
    
    //Constructor
    public Flight (String flightNo, String destination, 
                    String origin, LocalDateTime flightDate){
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        this.manifest = new LuggageManifest();
    }
    
    public Flight(String flightNo){
        this.flightNo = flightNo;
    }
    
    public String checkInLuggage(Passenger p){
        if(p.getFlightNo().equals(this.flightNo)){
            return getManifest().addLuggage(p, this);
        }
        else
            return "Invalid Flight";
    }
    
    public String printLuggageManifest(){
        return manifest.toString();
    }

    public int getAllowedLuggage(char cabinClass){
        int numAllowedPieces = 0;
        if(cabinClass == 'F'){
            numAllowedPieces = 3;
        }
        else if(cabinClass == 'B'){
            numAllowedPieces = 2;
        }
        else if(cabinClass == 'P'){
            numAllowedPieces = 1;
        }
        else if(cabinClass == 'E'){
            numAllowedPieces = 0;
        }
        return numAllowedPieces;       
    }
    
    public String toString(){
        return getFlightNo() + " Destination: " + getDestination() + " Origin: " 
        + getOrigin() + " " + getFlightDate();
    }
    
    

}
