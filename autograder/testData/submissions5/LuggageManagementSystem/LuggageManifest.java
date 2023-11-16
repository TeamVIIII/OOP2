import java.util.ArrayList;
//816029808

import java.util.Iterator;

public class LuggageManifest 
{
  private ArrayList<LuggageSlip> slips;

  public LuggageManifest() 
  {
    slips = new ArrayList<LuggageSlip>();
  }

  public String addLuggage(Passenger p, Flight f) 
  {
    int allowedLuggage = Flight.getAllowedLuggage(p.getCabinClass());
    int numLuggage = p.getNumLuggage();
    int excessPieces = numLuggage - allowedLuggage;
    double cost = getExcessLuggageCost(numLuggage, allowedLuggage);
    
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

  private double getExcessLuggageCost(int numPieces, int numAllowedPieces) 
  {
    int excessPieces = numPieces - numAllowedPieces;
    
    if(excessPieces > 0)
        return excessPieces * 35;
    
    return 0;
  }

  public String getExcessLuggageCostByPassenger(String passportNumber) {
    Iterator<LuggageSlip> iter = this.slips.iterator();
    
    while (iter.hasNext()) 
    {
      LuggageSlip l = iter.next();
      Passenger p = l.getOwner();
      String ppNumber = p.getPassportNumber();

      if (ppNumber.equals(passportNumber))
        return l.getLabel();
    }

    String str = "No Cost";
    return str;
  }

  public String toString() {
    String str = "LUGGAGE MANIFEST:\n";
    
    for (LuggageSlip slip : slips) 
    {
      str = str + slip.toString() + "\n";
    }
    
    return str.toString();
  }
}
