package oop2_project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses
(
    {
        CopierTest.class, 
        CompilerTest.class, 
        testRunAllTests.class,
        testReports.class,
        testOverallReport.class
    }
)

public class TestSuite 
{
    
}
