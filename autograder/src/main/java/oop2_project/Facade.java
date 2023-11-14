package oop2_project;

import java.util.List;

public interface Facade 
{
    public List<String> getSubmissionFolders(String submissionsZippedPath);
    public OverallReport getReport(String studentFolderPath);
    public void generatePDf(OverallReport report, String folderpath);
    public  boolean isValidZipFile(String submissionsZippedPath);
    
}
