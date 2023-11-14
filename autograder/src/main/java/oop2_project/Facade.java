package oop2_project;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

public interface Facade 
{
    public List<String> getSubmissionFolders(String submissionsZippedPath);
    public OverallReport getReport(String studentFolderPath);
    public void generatePDf(OverallReport report);
    public  boolean isValidZipFile(String submissionsZippedPath);
    
}
