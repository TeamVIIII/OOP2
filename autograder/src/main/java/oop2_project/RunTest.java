package oop2_project;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public abstract class RunTest{
    protected Result runTest(Class<?> testname) 
    {
        JUnitCore core = new JUnitCore();
        Result result = core.run(testname);
        return result;
    }
}
