package oop2_project;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.Result;


public class RunAllTests extends RunTest
{
    List<Result> results = new ArrayList<>();
    public List<Result> runAll()
    {
        List<Class<?>> testClasses = new ArrayList<>();
        testClasses.add(FlightTest.class);
        testClasses.add(PassengerTest.class);
        testClasses.add(LuggageSlipTest.class);
        testClasses.add(LuggageManifestTest.class);
        
        for(Class<?> testname: testClasses)
        {
            org.junit.runner.Result result = runTest(testname);
            results.add(result);
        }
        
        return results;
    }
    
}
