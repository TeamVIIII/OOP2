package oop2_project;

import org.junit.runner.Result;


public class PassengerReport extends AbstractReport
{

    public PassengerReport(Result r)
    {
        super(r, 16);
    }
    
    protected void setMarksPerTest()
    {
        markPerTest.put("testPassportNumber", 1);
        markPerTest.put("testFlightNo", 1);
        markPerTest.put("testFirstName", 1);
        markPerTest.put("testLastName", 1);
        markPerTest.put("testNumLuggage", 1);
        markPerTest.put("testCabinClass", 1);
        markPerTest.put("testConstructor", 7);
        markPerTest.put("testToStringFormat", 3);
    }

    protected void setRecommendationsPerTest()
    {
        recommendationPerTest.put("testFlightNo", "Ensure variable name is flightNo, a String and private of the Passenger Class");
        recommendationPerTest.put("testNumLuggage", "Ensure variable name is numLuggage, a String and private of the Passenger Class");
        recommendationPerTest.put("testFirstName", "Ensure variable name is firstName, a String and private of the Passenger Class");
        recommendationPerTest.put("testPassportNumber", "Ensure variable name is passportNumber, a String and private of the Passenger Class");
        recommendationPerTest.put("testLastName", "Ensure variable name is lastName, a String and private of the Passenger Class");
        recommendationPerTest.put("testCabinClass", "Ensure variable name is cabinClass, a String and private of the Passenger Class");
        recommendationPerTest.put("testConstructor", "Ensure the Passenger constructor uses the 4 input parameters correctly, sets the numLuggage variable randomly and sets the cabinClass variable randomly");
        recommendationPerTest.put("testToStringFormat", "Passenger to String wasn't in this form 'PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: 3 CLASS: E'");
    }
}
