package oop2_project;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;

public class CopierTest 
{
    private CopyAll copier;
    
    public CopierTest()
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
    public void testEmptyFolder() // shouldnt try to copy items from a file thats empty
    {
        String emptyFolderPath = "testData/DataToTestCopier/emptyfolder";

        boolean result = copier.copyAll(emptyFolderPath);
        assertFalse(result);
    } 

    @Test
    public void testFolderMissingItems()    // should only copy items from a file if all items are present
    {
        String emptyFolderPath = "testData/DataToTestCopier/2Items";

        boolean result = copier.copyAll(emptyFolderPath);
        assertFalse(result);
        
    }

    @Test
    public void testCopyAll()
    {
        String submissionFolder = "testData/DataToTestCopier/Jardel_Mitchell_816027213_A1";
        DeleteClassFiles.deleteFiles();

        assertTrue(copier.copyAll(submissionFolder));
        assertTrue(copier.isAllFilesContainedInFolder("src/main/java/oop2_project"));

    }
}
