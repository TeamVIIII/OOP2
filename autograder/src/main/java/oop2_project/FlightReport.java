package oop2_project;

import org.junit.runner.Result;

public class FlightReport extends AbstractReport{
    public FlightReport(Result r)
    {
        super(r, 16);
    }

    protected void setMarksPerTest()
    {
        markPerTest.put("testFlightNo", 1);
        markPerTest.put("testDestination", 1);
        markPerTest.put("testOrigin", 1);
        markPerTest.put("testFlightDate", 1);
        markPerTest.put("testManifest", 1);
        markPerTest.put("testConstructor", 2);
        markPerTest.put("testCheckInLuggage", 5);
        markPerTest.put("testPrintLuggageManifest", 1);
        markPerTest.put("testgetAllowedLuggage", 2);
        markPerTest.put("testToString", 1);
    }
    
    protected void setRecommendationsPerTest()
    {
        recommendationPerTest.put("testFlightNo", "Ensure variable name is flightNo, a String and private of the Flight Class");
        recommendationPerTest.put("testDestination", "Ensure variable name is destination,is a String and private of the Flight Class");
        recommendationPerTest.put("testOrigin", "Ensure variable name is origin, a String and private of the Flight Class");
        recommendationPerTest.put("testFlightDate", "Ensure variable name is origin, an instance of LocalDateTime and private in the FLight class");
        recommendationPerTest.put("testManifest", "Ensure variable name is manifest, a private instance of LuggageManifest in the Flight Class");
        recommendationPerTest.put("testConstructor", "Ensure the constructor creates a new LuggageManifest object and initializes the class variables");
        recommendationPerTest.put("testCheckInLuggage", "Check if a passenger.flightNo matches flight.flighNo. If it does return the string which is returened from the call of addLuggage of LuggageSlip class else return Invalid flight");
        recommendationPerTest.put("testPrintLuggageManifest", "This method return the string from the call of manifest.toString()");
        recommendationPerTest.put("testgetAllowedLuggage", "Ensure this method returns the correct integer based on the char parsed in and is a static method. Eg. if 'F' is parsed it should return 3. This method should also be static.");
        recommendationPerTest.put("testToString", "Ensure Flight's toString method returns the string in this format: BW817 DESTINATION: TOBAGO ORIGIN: TRINIDAD 2017-01-13T17:09:42.411");

    }
}
