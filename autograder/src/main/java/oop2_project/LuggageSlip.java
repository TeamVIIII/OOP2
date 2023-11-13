package oop2_project;

// Student ID: 816031173
// Student Name: Zachary Rampersad

public class LuggageSlip{
    private Passenger owner;
    private int luggageSlipIDCounter;
    private String luggageSlipID;
    private String label;
    
    public LuggageSlip(Passenger p, Flight f){
        owner = p;
        luggageSlipID = "";
        
        for(luggageSlipIDCounter = 1; luggageSlipIDCounter<=p.getNumLuggage(); 
            luggageSlipIDCounter++)
            luggageSlipID += f.getFlightNo()+"_"+p.getLastName()+"_"+
            luggageSlipIDCounter+"\n";
        label = "";
    }
    
    public LuggageSlip(Passenger p, Flight f, String label){
        owner = p;
        luggageSlipID = "";
        
        for(luggageSlipIDCounter = 1; luggageSlipIDCounter<=p.getNumLuggage(); 
            luggageSlipIDCounter++)
            luggageSlipID += f.getFlightNo()+"_"+p.getLastName()+"_"+
            luggageSlipIDCounter+"\n";
        this.label = label;
    }
    
    public Passenger getOwner(){
        return owner;
    }
    
    public int getLuggageSlipIDCounter(){
        return luggageSlipIDCounter;
    }
    
    public String getLuggageSlipID(){
        return luggageSlipID;
    }
    
    public String getLabel(){
        return label;
    }
    
    public boolean hasOwner(String passportNumber){
        if(passportNumber.equals(getOwner().getPassportNumber()))
            return true;
        else    
            return false;
    }
    
    public String toString(){
        String output = "";
        if(getOwner().getNumLuggage()>0){
        String [] luggageSlips = getLuggageSlipID().split("\n"); // ^1
        
        for(String str : luggageSlips)    
            output += str+" "+getOwner().toString()+" "+getLabel()+"\n";
        }
        return output;
        
    }
    
    // public static void main(String[] args){
        // LocalDateTime d = LocalDateTime.of(2023,2,10,10,00,00);
        // Flight f = new Flight("CC1235","POS","HELL",d);
        // Passenger p = new Passenger("TT155612","Big","Waste","CC1235");
        
        // LuggageSlip s = new LuggageSlip(p,f);
        // System.out.println(s.toString());
    // }
    
    // ^1 : https://www.geeksforgeeks.org/split-string-java-examples/
}
