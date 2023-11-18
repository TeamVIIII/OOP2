import java.util.ArrayList;

/**
 * Write a description of class LuggageManifest here.
 *
 * @author (Jardel Mitchell)
 * @version (10/02/2023)
 */
public class LuggageManifest {
    private ArrayList<LuggageSlip> slips;
    private Flight flight;

    public LuggageManifest(){
        this.slips = new ArrayList<LuggageSlip>();
        this.flight = flight;
    }

    public String addLuggage(Passenger p, Flight f) 
  {
    int allowedLuggage = f.getAllowedLuggage(p.getCabinClass());
    int numLuggage = p.getNumLuggage();
    int excessPieces = numLuggage - allowedLuggage;
    double cost = getExcessLuggageCost(excessPieces);
    
    if (numLuggage == 0)
      return "No Luggage to add.\n";
    
    else if (excessPieces > 0) 
    {
      for (int i = 1; i <= numLuggage; i++) 
      {
        String exCost = Double.toString(cost);
        slips.add(new LuggageSlip(p, f, exCost));
      }
      
      return "Pieces Added: (" + numLuggage + "). Excess Cost: $" + cost + "\n";
    } 
    else if (excessPieces <= 0) 
    {
      for (int i = 1; i <= numLuggage; i++) 
      {
        slips.add(new LuggageSlip(p, f));
      }
      
      return "Pieces Added: (" + numLuggage + "). Excess Cost: $0\n";
    } 
          
    return "";
  }

    public double getExcessLuggageCost(int excess){
        double cost = excess * 35.00;
        return cost;
    }

    public String getExcessLuggageCostByPassenger(String passportNumber){
        double cost = 0;
        
        for (LuggageSlip slip : this.slips) {
            if (slip.getOwner().getPassportNumber().equals(passportNumber)) {
                int numPieces = slip.getOwner().getNumLuggage();
                char cabinclassowner = slip.getOwner().getCabinClass();
                int excess = numPieces;
                if (excess > 0) {
                    cost += getExcessLuggageCost(excess);
                }
            }
        }
        String luggageData = cost > 0 ? "Total Cost: $" + cost : "No Excess Luggage Cost";
        return luggageData;
    }
}

