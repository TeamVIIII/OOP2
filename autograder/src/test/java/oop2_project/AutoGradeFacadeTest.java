package oop2_project;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.List;

public class AutoGradeFacadeTest {
    private AutoGradeFacade autoGradeFacade;

    @Before
    public void setup() {
    autoGradeFacade = new AutoGradeFacade();
    }

    @Test
    public void testGetSubmissionFolders() {
        String submissionsZippedPath = "path/to/submissions.zip";
        List<String> folders = autoGradeFacade.getSubmissionFolders(submissionsZippedPath);
        assertNotNull(folders);
    }

    //is AssertTue returns java.lang.AssertionError: path/to/test.zip at oop2_project.AutoGradeFacadeTest.testIsValidZip(AutoGradeFacadeTest.java:38)

    @Test
    public void testIsValidZip(){
        String validZipFilePath = "path/to/valid";
        boolean isValid = autoGradeFacade.isValidZipFile(validZipFilePath);
        assertFalse(isValid);

        String invalidZipFilePath = "path/to/test.zip";
        isValid = autoGradeFacade.isValidZipFile(invalidZipFilePath);
        assertTrue("path/to/test.zip" ,isValid);

    }

    //current unknown type Report Java error
    @Test
    public void testGetReport() {
        // Arrange
        String studentFolderPath = "path/to/studentFolder";
        Copier copier = mock(Copier.class);
        Compiler compiler = mock(Compiler.class);
        RunTest executer = mock(RunTest.class);
        //List<Result> results = Arrays.asList(new Result(), new Result(), new Result(), new Result());

        when(copier.copyAll(studentFolderPath)).thenReturn(true);
        when(compiler.compileTest()).thenReturn(true);
        //when(executer.runAll()).thenReturn(results);

        // Act
        OverallReport overallReport = autoGradeFacade.getReport(studentFolderPath);

        // Assert
        assertNotNull(overallReport);
        //assertEquals(4, overallReport.getReports().size());
    }

    

    @Test
    public void testDelete() {
        autoGradeFacade.delete();
    // Check if files have been deleted
    }

    @Test
    public void testResetState() {
        autoGradeFacade.resetState();
    // Check if files have been copied
    }

    @Test
    public void testEmptyGarbage() {
        autoGradeFacade.emptyGarbage();
    // Check if garbage collector has been called
    }

    @Test
    public void testGeneratePDf() {
        OverallReport report = new OverallReport();
        String folderPath = "path/to/folder";
        autoGradeFacade.generatePDf(report, folderPath);
    }


}
