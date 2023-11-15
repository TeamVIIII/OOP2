package oop2_project;


/**
 * Write a description of class LuggageSlip here.
 *
 * @author (Jardel Mitchell)
 * @version (10/02/2023)
 */
public class LuggageSlip{
    //Attributes
    private Passenger owner;
    static int luggageSlipIDCounter = 1;
    private String luggageSlipID;
    private String label;
    
    //Accessors
    public Passenger getOwner(){
        return owner;
    }    
    public int getLuggageSlipIDCounter(){
        return luggageSlipIDCounter++;
    }
    public String getLuggageSlipID(){
        return luggageSlipID;
    }
    public String getLabel(){
        return luggageSlipID;
    }
    
    //Constructor
    public LuggageSlip(Passenger p, Flight f){
        this.label = "";
        this.owner = p;
        this.luggageSlipID = f.getFlightNo() + "_" + p.getLastName()
        + " "+ luggageSlipIDCounter++;
    }

    public LuggageSlip(Passenger p, Flight f, String label){
        this.owner = p;
        this.label = label;
        this.luggageSlipID = f.getFlightNo() + "_" + p.getLastName()
        + " "+ getLuggageSlipIDCounter() + " " + label;
    }
    
    

    public boolean hasOwner(String passportNumber){
        if (owner.getPassportNumber().equals(passportNumber)){
            return owner.getPassportNumber().equals(passportNumber);
        }
        else{
            return false;
        }
    }

    public String toString(){
        String output;
        output = getLuggageSlipID() +" PP NO." + "_" + owner.getPassportNumber() +
        " Name: " + owner.getCharacter(owner.getFirstName()) + "." + 
        owner.getLastName()+ " " + + owner.getNumLuggage()+ " Class: " +
        owner.getCabinClass() + " " + getLabel();        
        return output;
    }


}

