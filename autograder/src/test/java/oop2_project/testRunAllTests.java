package oop2_project;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.Result;

public class testRunAllTests 
{
    private RunTest executer;

    public testRunAllTests()
    {
        executer = new RunAllTests();
    }

    @Test
    public void testingExecuter()
    {
        List<Result> results = executer.runAll();
        assertEquals(4,results.size());

    }


    
}
