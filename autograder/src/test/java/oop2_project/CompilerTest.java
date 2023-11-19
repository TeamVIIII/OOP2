package oop2_project;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import org.junit.Before;

public class CompilerTest 
{
    Compiler compiler;

    @Before
    public void setup()
    {
        compiler = new Compiler();
    }

    @Test
    public void testCompiler()
    {
        assertTrue(compiler.compileTest());
        String folderPath = "src/main/java/oop2_project";

        assertClassFilesExist(folderPath, "Passenger.class");
        assertClassFilesExist(folderPath, "LuggageSlip.class");
        assertClassFilesExist(folderPath, "LuggageManifest.class");
        assertClassFilesExist(folderPath, "Flight.class");
        assertClassFilesExist(folderPath, "PassengerTest.class");
        assertClassFilesExist(folderPath, "FlightTest.class");
        assertClassFilesExist(folderPath, "LuggageSlipTest.class");
        assertClassFilesExist(folderPath, "LuggageManifestTest.class");

    }

    private void assertClassFilesExist(String folderPath, String fileName) 
    {
        File classFile = new File(folderPath, fileName);
        assertTrue(fileName, classFile.exists());
    }
    
}
