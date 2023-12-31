package oop2_project;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class CopierTest 
{
    private CopyAll copier;
    
    @Before
    public void setUp()
    {
        copier = new CopyAll();
    }

    @After
    public void tearDown()
    {
        Facade grade = new AutoGradeFacade();
        grade.resetState();
    }

    @Test
    public void testEmptyFolder() // shouldn't try to copy items from a file thats empty
    {
        String emptyFolderPath = "testData/emptyFolder";

        boolean result = copier.copyAll(emptyFolderPath);
        assertFalse(result);
    } 

    @Test
    public void testFolderMissingItems()    // should only copy items from a file if all items are present
    {
        String emptyFolderPath = "testData/2Items";

        boolean result = copier.copyAll(emptyFolderPath);
        assertFalse(result);
        
    }

    @Test
    public void testCopyAll()
    {
        String submissionFolder = "testData/FailingSubmission";
        DeleteClassFiles.deleteFiles();

        assertTrue(copier.copyAll(submissionFolder));
        assertTrue(copier.isAllFilesContainedInFolder("src/main/java/oop2_project"));

    }
}