package oop2_project;

import java.time.LocalDateTime;
//816029808


public class Flight {
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LuggageManifest manifest;

    public String getFlightNo() 
    {
        return flightNo;
    }

    public String getDestination() 
    {
        return destination;
    }

    public String getOrigin() 
    {
        return origin;
    }

    public LocalDateTime getFlightDate() 
    {
        return flightDate;
    }

    public LuggageManifest getManifest() 
    {
        return manifest;
    }

    public Flight(String flightNo, String destination, String origin, LocalDateTime flightDate) 
    {
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        this.flightDate = flightDate;
        this.manifest = new LuggageManifest();

    }

    public String checkInLuggage(Passenger p) 
    {
        String passFlight = p.getFlightNo();
        String num = getFlightNo();
        String ticket;

        if (passFlight.equals(num)) 
            ticket = manifest.addLuggage(p, this);
        else 
            ticket = "Invalid flight";
        

        return ticket;
    }

    public String printLuggageManifest() 
    {
        return this.manifest.toString();
    }

    public int getAllowedLuggage(char CabinClass) 
    {
        if (Character.compare(CabinClass, 'F') == 0)
            return 3;
        else if (Character.compare(CabinClass, 'B') == 0)
            return 2;
        else if (Character.compare(CabinClass, 'P') == 0)
            return 1;

        return 0;
    }

    public String toString() 
    {
        String str = getFlightNo() + " DESTINATION: " + getDestination() + " ORIGIN: " + getOrigin() + " "
                     + getFlightDate();
        return str;
    }

}
