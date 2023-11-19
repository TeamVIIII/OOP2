//816029808

import java.util.Random;

public class Passenger 
{
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage;
    private char cabinClass;
    
    public String getPassportNumber() 
    {
        return passportNumber;
    }

    public String getFlightNo() 
    {
        return flightNo;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public int getNumLuggage() 
    {
        return numLuggage;
    }

    public char getCabinClass() 
    {
        return cabinClass;
    }

    public Passenger(String passportNumber, String firstName, String lastName, String flightNo) 
    {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNo = flightNo;
        assignRandomNumLuggage();
        assignRandomCabinClass();
    }

    private void assignRandomNumLuggage() 
    {
        Random rand = new Random();
        this.numLuggage = rand.nextInt(4);
    }

    public void assignRandomCabinClass() 
    {
        Random rand = new Random();
        char[] cabinClasses = {'F', 'B', 'P', 'E'};
        int x = rand.nextInt(4);
        this.cabinClass = cabinClasses[x];
    }

    public String toString() 
    {
        return "PP NO. " + passportNumber + " NAME: " + firstName.charAt(0) + "." + getLastName().toUpperCase()
                + " NUMLUGGAGE: " + numLuggage + " CLASS: " + getCabinClass() + "\n";
    }
}
