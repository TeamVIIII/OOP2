package oop2_project;

// Student ID: 816031173
// Student Name: Zachary Rampersad

import java.util.Random; 

public class Passenger{
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage ;
    private char cabinClass;
    
    Passenger(String passportNumber, String firstName, String lastName, String flightNo){
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNo = flightNo;
        assignRandomCabinClass();
        Random r = new Random();
        setNumLuggage(r.nextInt(4));
    }
    
    public void setNumLuggage(int numLuggage){
        this.numLuggage = numLuggage;
    }
    
    public String getPassportNumber(){
        return passportNumber;
    }
    
    public String getFlightNo(){
        return flightNo;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getNumLuggage(){
        return numLuggage;
    }
    
    public char getCabinClass(){
        return cabinClass;
    }
    
    public void assignRandomCabinClass(){
        char[] classes = {'F','B','P','E'};
        Random r = new Random();
        
        cabinClass = classes[(r.nextInt(4))];
        
    }
    
    public String toString(){
        return("PP NO. "+getPassportNumber()+" NAME: "+(getFirstName()).charAt(0)+
        "."+getLastName()+" NUMLUGGAGE: "+getNumLuggage()+" CLASS: "+
        getCabinClass());
    }
    
    
}
