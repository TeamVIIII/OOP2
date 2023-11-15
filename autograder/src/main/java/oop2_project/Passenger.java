package oop2_project;

import java.util.Random;
/**
 * Write a description of class Passenger here.
 *
 * @author (Jardel Mitchell)
 * @version (......... 02/09/2023)
 */
public class Passenger{
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage;
    private char cabinClass;
    
    //Accessors
    public String getPassportNumber(){
        return flightNo;
    }
    public String getFlightNo(){
        return flightNo;
    }
    public String getFirstName(){
        return flightNo;
    }
    public String getLastName(){
        return flightNo;
    }
    public int getNumLuggage(){
        return numLuggage;
    }
    public char getCabinClass(){
        return cabinClass;
    }
    
    
    public Passenger(String passportNumber, String firstName,
                                String lastName, String flightNo){
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNo = flightNo;
        getRandomLuggage();
        assignRandomCabinClass();

    }
    
    public void getRandomLuggage(){
        Random random = new Random();
        this.numLuggage = random.nextInt(4);
    }
    
    public void assignRandomCabinClass(){
            char[] cabinClass = {'F','B','P','E'}; 
            Random randomCabin = new Random(4);
            int randomCabinClass = randomCabin.nextInt(cabinClass.length);
            this.cabinClass = cabinClass[randomCabinClass];
             
        }
    
    public char getCharacter(String firstName){
        return firstName.charAt(0) ;
    }
        
    public String toString(){
        String output = "PP No. : " + getPassportNumber() + " Name: " 
        + getCharacter(getFirstName()) + "." + getLastName() + " NUMLUGGAGE "
        + getNumLuggage() + " Class: " + getCabinClass() + "\n";
        return output;
    }
                
    
    
    
}

 
