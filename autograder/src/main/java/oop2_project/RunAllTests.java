package oop2_project;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.Result;


public class RunAllTests extends RunTest
{
    
    private final List<Class<?>> testClasses;

    public RunAllTests()
    {
        testClasses = new ArrayList<>();
        testClasses.add(PassengerTest.class);
        testClasses.add(LuggageSlipTest.class);
        testClasses.add(LuggageManifestTest.class);
        testClasses.add(FlightTest.class);
    }

    public final List<Result> runAll()
    {   
        List<Result> results = new ArrayList<>();

        for(Class<?> testname: testClasses)
        {
            Result result = runTest(testname);
            results.add(result);
        }
        
        return results;
    }
    
}
