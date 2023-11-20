package oop2_project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

public class AutoGradeFacadeTest {
    private Facade autoGradeFacade;

    @Before
    public void setup() 
    {
        autoGradeFacade = new AutoGradeFacade();
    }

    @After
    public void tearDown()
    {
        DeleteClassFiles.deleteFiles();
        Copier copier = new CopyAll();
        copier.copyAll("requriedFiles");
    }

    @Test
    public void testGetSubmissionFolders() {
        String submissionsZippedPath = "path/to/submissions.zip";
        List<String> folders = autoGradeFacade.getSubmissionFolders(submissionsZippedPath);
        assertNotNull(folders);
    }

    @Test
    public void testIsValidZip(){
        String validZipFilePath = "testData/FailingSubmission";
        boolean isValid = autoGradeFacade.isValidZipFile(validZipFilePath);
        assertFalse(isValid);

        String invalidZipFilePath = "testData/Submission1.zip";
        isValid = autoGradeFacade.isValidZipFile(invalidZipFilePath);
        assertTrue(isValid);

    }

    @Test
    public void testGetReport() 
    {
        OverallReport report = autoGradeFacade.getReport("testData/emptyFolder");
        assertNull(report);

        report = autoGradeFacade.getReport("testData/FailingSubmission");
    }

    @Test
    public void testDelete() 
    {
        autoGradeFacade.delete();
        String[] filesToDelete = {
            "src/main/java/oop2_project/Flight.class",
            "src/main/java/oop2_project/FlightTest.class",
            "src/main/java/oop2_project/LuggageManifest.class",
            "src/main/java/oop2_project/LuggageManifestTest.class",
            "src/main/java/oop2_project/LuggageSlip.class",
            "src/main/java/oop2_project/LuggageSlipTest.class",
            "src/main/java/oop2_project/Passenger.class",
            "src/main/java/oop2_project/PassengerTest.class",
            "target/classes/oop2_project/Flight.class",
            "target/classes/oop2_project/LuggageSlip.class",
            "target/classes/oop2_project/LuggageManifest.class",
            "target/classes/oop2_project/Passenger.class",


            "src/main/java/oop2_project/Flight.java",
            "src/main/java/oop2_project/LuggageSlip.java",
            "src/main/java/oop2_project/LuggageManifest.java",
            "src/main/java/oop2_project/Passenger.java",

        };

        for (String filePath : filesToDelete) 
        {
            File file = new File(filePath);
            assertFalse(file.exists());
        }
    }

    @Test
    public void testResetState() 
    {
        DeleteClassFiles.deleteFiles();
        autoGradeFacade.resetState();

        String[] filesToDelete = 
        {
            "src/main/java/oop2_project/Flight.java",
            "src/main/java/oop2_project/LuggageSlip.java",
            "src/main/java/oop2_project/LuggageManifest.java",
            "src/main/java/oop2_project/Passenger.java",
        };

        for (String filePath : filesToDelete) 
        {
            File file = new File(filePath);
            assertTrue(file.exists());
        }
    }
    
    @Test
    public void testGeneratePDf() 
    {
        OverallReport report = new OverallReport();
        String folderPath = "testData/PerfectSubmission";
        autoGradeFacade.generatePDf(report, folderPath);
        String pdfPath = "testData/PerfectSubmission/PerfectSubmission.pdf";
        File file = new File(pdfPath);
        assertTrue(file.exists());


        // tests for the failed pdf
        report = null;
        folderPath = "testData/FailingSubmission";
        autoGradeFacade.generatePDf(report, folderPath);
        pdfPath = "testData/FailingSubmission/FailingSubmission.pdf";
        file = new File(pdfPath);
        assertTrue(file.exists());
    }
}