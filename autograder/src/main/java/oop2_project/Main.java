package oop2_project;

import java.util.List;
import java.util.Scanner;

import org.junit.runner.Result;

/*
error testing for copier
for compiling

 */


public class Main {
    public static void main(String[] args) 
    {
        Facade grade = new AutoGradeFacade();

        String zipFile = "/Users/jerrellejohnson/Desktop/tesing/submissions3.zip";
       
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
        for(String folderpath : studentFolders)
        { 
            System.out.println(folderpath);
            OverallReport overallReport = grade.getReport(folderpath);

            // CopyAll copier = new CopyAll();
            // Compiler compiler = new Compiler();
            // RunAllTests executer = new RunAllTests();

            // copier.copyAll(folderpath);
            // compiler.compileTest(folderpath);
            
            // List<Result> results = executer.runAll();
            
            // Report passengerReport = new PassengerReport(results.get(0));
            // Report luggageSlipReport = new LuggageSlipReport(results.get(1));
            // Report luggageManifestReport = new LuggageManifestReport(results.get(2));
            // Report flightReport = new FlightReport(results.get(3));

            // OverallReport overallReport = new OverallReport();
            // overallReport.addReport(passengerReport);
            // overallReport.addReport(luggageSlipReport);
            // overallReport.addReport(luggageManifestReport);
            // overallReport.addReport(flightReport);

            // grade.generatePDf(overallReport,studentFolders.get(0));
            // grade.generatePDf(overallReport,folderpath);

            
        }
    }
}