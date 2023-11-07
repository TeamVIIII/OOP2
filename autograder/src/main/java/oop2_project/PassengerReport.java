package oop2_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PassengerReport implements Report
{
    public int highestPossible = 16;
    public int acquiredMark = 16;
    public List<String> recommendations = new ArrayList<>();
    private Map<String, Integer> markPerTest = new HashMap<>(8);
    private Map<String, String> recommendationPerTest = new HashMap<>(8);


    public PassengerReport(Result r)
    {
        setMarks();
        setRecommendations();

        if(r.wasSuccessful())
        {
            recommendations.add("All tests passed");
        }
        else
        {
            for(Failure f: r.getFailures())
            {
                acquiredMark -= markPerTest.get(f.getDescription().getMethodName());
                recommendations.add(recommendationPerTest.get(f.getDescription().getMethodName()));
            }
        }

        
    }
    
    private void setMarks()
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
    private void setRecommendations()
    {
        recommendationPerTest.put("testFlightNo", "Ensure variable name is FlightNo, a String and private");
        recommendationPerTest.put("testNumLuggage", "Ensure variable name is numLuggage, a String and private");
        recommendationPerTest.put("testFirstName", "Ensure variable name is firstName, a String and private");
        recommendationPerTest.put("testPassportNumber", "Ensure variable name is passportNumber, a String and private");
        recommendationPerTest.put("testLastName", "Ensure variable name is lastName, a String and private");
        recommendationPerTest.put("testCabinClass", "Ensure variable name is cabinClass, a String and private");
        recommendationPerTest.put("testConstructor", "Ensure constructor uses the 4 input parameters correctly, sets the numLuggage variable randomly and sets the cabinClass variable randomly");
        recommendationPerTest.put("testToStringFormat", "String wasn't in this form 'PP NO. TA890789 NAME: J.BEAN NUMLUGGAGE: 3 CLASS: E'");
    }


    public void viewDetails()
    {
        System.out.println("Total Mark: " + highestPossible + "Mark Obtained: " + acquiredMark);
    }
    
}
