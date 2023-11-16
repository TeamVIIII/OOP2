package oop2_project;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Facade grade = new AutoGradeFacade();

        String zipFile = "testData/submissions5.zip";
       
        Scanner cin = new Scanner(System.in);
        // System.out.print("Enter the filepath of the zipped submissions: ");

        // String zipFile = cin.nextLine();
        // while(!grade.isValidZipFile(zipFile))
        // {
        //     System.out.print("Please enter a valid file that ends in .zip: ");
        //     zipFile = cin.nextLine();

        // }
        cin.close();
        
        List<String> studentFolders = grade.getSubmissionFolders(zipFile);
        grade.delete();
        for(String folderpath : studentFolders)
        { 
            OverallReport overallReport = grade.getReport(folderpath);

            grade.generatePDf(overallReport,folderpath);
            grade.delete();
            grade.emptyGarbage();
        }
        
        grade.resetState();
    }
}