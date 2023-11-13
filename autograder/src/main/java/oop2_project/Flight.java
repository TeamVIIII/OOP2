package oop2_project;

// Student ID: 816031173
// Student Name: Zachary Rampersad

import java.time.LocalDateTime;

public class Flight{
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LuggageManifest manifest;
    
    public Flight(String flightNo, String destination, String origin, 
    LocalDateTime flightDate){
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        manifest = new LuggageManifest();
    }
    
    public String getFlightNo(){
        return flightNo;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public String getOrigin(){
        return origin;
    }

    public LocalDateTime getFlightDate(){
        return flightDate;
    }
    
    public LuggageManifest getLuggageManifest(){
        return manifest;
    }
    
    public String checkInLuggage(Passenger p){
        
        if(getFlightNo().equals(p.getFlightNo()))
            return getLuggageManifest().addLuggage(p,this);
        
        else
            return "Invalid Flight";
    }
    
    public String printLuggageManifest(){
        return manifest.toString();
    }
    
    public int getAllowedLuggage(char cabinClass){
        switch(cabinClass){
            case 'F': return 3;
            case 'B': return 2;
            case 'P': return 1;
            case 'E': return 0;
        }
        
        return 0;
    }
    
    public String toString(){
        return (getFlightNo()+" DESTINATION:"+getDestination()+" ORIGIN:"
        +getOrigin()+" "+getFlightDate());
    }
    
}

