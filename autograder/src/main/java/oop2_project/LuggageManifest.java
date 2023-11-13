package oop2_project;

// Student ID: 816031173
// Student Name: Zachary Rampersad

import java.util.ArrayList;

public class LuggageManifest{
    private ArrayList<LuggageSlip> slips;
    
    public LuggageManifest(){
        slips = new ArrayList<LuggageSlip>();
    }
    
    public ArrayList<LuggageSlip> getSlips(){
        return slips;
    }
    
    public String addLuggage(Passenger p, Flight f){
        String label = String.valueOf(getExcessLuggageCost(p.getNumLuggage(),
        f.getAllowedLuggage(p.getCabinClass())));
        
        if(p.getNumLuggage() == 0){
            LuggageSlip s = new LuggageSlip(p,f);
        
            slips.add(s);
        
            return p.toString()+"\nNo Luggage to add.";
        }
        else if (label.equals("0.00")){
            LuggageSlip s = new LuggageSlip(p,f);
            
            slips.add(s);
            
            return p.toString()+"\n"+"Pieces Addeded: ("+
            p.getNumLuggage()+") Excess Cost: $"+label;
        }
        else{
            LuggageSlip s = new LuggageSlip(p,f,label);
            
            slips.add(s);
            
            return p.toString()+"\n"+"Pieces Addeded: ("+
            p.getNumLuggage()+ ") Excess Cost: $"+label;
        }
    }
    
    public double getExcessLuggageCost(int numPieces, int numAllowedPieces){
        if(numPieces>numAllowedPieces)   
            return ((numPieces - numAllowedPieces)*35.00);
        else
            return 0.00;
    }
    
    public String getExcessLuggageCostByPassenger(String passportNumber){
        for(LuggageSlip s : slips){
            
            if(passportNumber.equals(s.getOwner().getPassportNumber())){
                if(s.getLabel().equals(""))
                    return "No Cost";
                else
                    return s.getLabel();
            }
        
        }
        
        return "No Cost";
    }
    
    public String toString(){
        String aggregate = "LUGGAGE MANIFEST:\n";
        
        // for(int i = 0; i<slips.size(); i++){
            // LuggageSlip s = slips.get(i);
            // aggregate += s.toString();
        // }
        
        for(LuggageSlip s : slips)
            aggregate += s.toString();
        return aggregate;
    }
    
}
