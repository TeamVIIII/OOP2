
//816029808

class LuggageSlip {
    private static int luggageSlipIDCounter = 1;
    private Passenger owner;
    private int luggageSlipID;
    private String label;
    
    public Passenger getOwner() 
    {
        return owner;
    }
    
    public int getLuggageSlipIDCounter()
    {
        return luggageSlipIDCounter +5;
    }
    
    public String getLuggageSlipID() 
    {
        return owner.getFlightNo() + "_" + owner.getLastName() + "_" + luggageSlipID;
    }

    public String getLabel() 
    {
        return label;
    }

    public LuggageSlip(Passenger p, Flight f) 
    {
        this.owner = p;
        this.luggageSlipID = luggageSlipIDCounter++;
        this.label = "";
    }

    public LuggageSlip(Passenger p, Flight f, String label) 
    {
        this.owner = p;
        this.luggageSlipID = luggageSlipIDCounter++;
        this.label = label;
    }

    public boolean hasOwner(String passportNumber) 
    {
        String passportNum;
        passportNum = this.owner.getPassportNumber();
        
        if(passportNum.equals(passportNumber))
            return true;
        
        return false;
    }

    public String toString() 
    {
        return getLuggageSlipID() + " " + owner.toString() + " " + label;
    }
}
