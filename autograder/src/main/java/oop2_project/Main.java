package oop2_project;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Facade grade = new AutoGradeFacade();

       String zipFile = "/Users/jerrellejohnson/Desktop/tesing/submission.zip";
       
        // Scanner cin = new Scanner(System.in);
        // System.out.print("Enter the filepath of the zipped submissions: ");

        // String zipFile = cin.nextLine();
        // while(!grade.isValidZipFile(zipFile))
        // {
        //     System.out.print("Please enter a valid file that ends in .zip: ");
        //     zipFile = cin.nextLine();

        // }
        // cin.close();

        List<String> studentFolders = grade.getSubmissionFolders(zipFile);
        for(String s : studentFolders)
        { 
            System.out.println(s);
            OverallReport overallReport = grade.getReport(s);
        }

    }
}