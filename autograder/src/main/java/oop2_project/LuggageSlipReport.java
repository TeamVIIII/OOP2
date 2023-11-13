package oop2_project;

import org.junit.runner.Result;

public class LuggageSlipReport extends AbstractReport
{
    public LuggageSlipReport(Result r)
    {
        super(r, 14);
    }

    protected void setMarksPerTest()
    {
        markPerTest.put("testOwner", 1);
        markPerTest.put("testLuggageSlipIDCounter", 1);
        markPerTest.put("testLuggageSlipID", 1);
        markPerTest.put("testLabel", 1);
        markPerTest.put("testNoLabelConstructor", 3);
        markPerTest.put("testLabelConstructor", 3);
        markPerTest.put("testHasOwner", 2);
        markPerTest.put("testToStringFormat", 2);
    }
    
    protected void setRecommendationsPerTest()
    {
        recommendationPerTest.put("testOwner", "Ensure variable name is owner, an instance of Passenger and private in the LuggageSlip Class");
        recommendationPerTest.put("testLuggageSlipIDCounter", "Ensure variable name is luggageSlipIDCounter,static, of type int, and private in the LuggageSlip class");
        recommendationPerTest.put("testLuggageSlipID", "Ensure variable name is luggageSlipID, a String and private in the LuggageSlip Class. Also it is set to a combination of the flightNo, passenger last name and the luggageSlipIDCounter");
        recommendationPerTest.put("testLabel", "Ensure variable name is label, an instance of String and private in the LuggageSlip class");
        recommendationPerTest.put("testNoLabelConstructor", "This constructor should initialise the variables of the class with the parameters parsed in and set label to an empty String");
        recommendationPerTest.put("testLabelConstructor", "This constructor should include String label as a parameter and  initialise the variables of the class with the parameters parsed in");
        recommendationPerTest.put("testHasOwner", "This method should check if the if owner of this LuggageSlip passportNumber equals to one parsed in. If it natches return true else return false");
        recommendationPerTest.put("testToStringFormat", "This should be the format if a label is present: 'BW600_Bean_1 PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: 3 CLASS: E $105'. If a label is not present it is not present it should be 'BW600_Bean_1 PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: 3 CLASS: E'.");
    }
}
