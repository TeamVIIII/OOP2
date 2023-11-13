package oop2_project;

import org.junit.runner.Result;

public class LuggageManifestReport extends AbstractReport 
{
    public LuggageManifestReport(Result r)
    {
        super(r,20);
    }

    protected void setMarksPerTest()
    {
        markPerTest.put("testSlips", 1);
        markPerTest.put("testConstructor", 1);
        markPerTest.put("testAddLuggage", 6);
        markPerTest.put("testGetExcessLuggageCost", 3);
        markPerTest.put("testGetExcessLuggageCostByPassenger", 5);
        markPerTest.put("testToString", 3);
    }
    
    protected void setRecommendationsPerTest()
    {
        recommendationPerTest.put("testSlips", "Ensure variable name is slips, of type ArrayList<LuggageSlip> and private in the LuggageManifest Class");
        recommendationPerTest.put("testConstructor", "Incorrectly initializes the slips correctly, should be slips = new ArrayList<LuggageSlip>(); ");
        recommendationPerTest.put("testAddLuggage", "This method should add a LuggageSlip to the slips collection and return a string in this format: 'Pieces Added: (2). Excess Cost: $35' if the passenger has luggages to add or 'No Luggage to add' if they don't.");
        recommendationPerTest.put("testGetExcessLuggageCost", "This method should've returned a double representing the cose of the excess luggage. Each excess piece of luggage should've been multiplied by 35");
        recommendationPerTest.put("testGetExcessLuggageCostByPassenger", "This method suppose to taken in a passportNumber and return the excess cost this passenger is required to pay by iterating through the slips collection and checking to see if the passportNumber parsed in equals to the owner's passportNumber of that slip. The method should've then returned label attached to that slip if any, otherwise returned 'No Cost'");
        recommendationPerTest.put("testToString", "This method should've iterated through the slips collection calling the toString method of the LuggageSlip class");
    }
}
