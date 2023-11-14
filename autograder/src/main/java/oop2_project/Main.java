package oop2_project;

import java.util.List;
import org.junit.runner.Result;

/*
 get the name of folder
 attach the name of the folder to .pdf eg(/Users/jerrellejohnson/Desktop/tesing/submissions/LuggageManagementSystem/LuggageManagementSystem.pdf)
 create in the pdf in this /Users/jerrellejohnson/Desktop/tesing/submissions/LuggageManagementSystem
 */


public class Main {
    public static void main(String[] args) {
        String zipFile = "C:\\Users\\kiran\\Downloads\\submissions.zip";

        UnzipUtility unzipper = new UnzipUtility();
        GetUnzippedPaths zippedSubmissionsPaths = new GetUnzippedPaths();
        CopyAll copier = new CopyAll();
        Compiler compiler = new Compiler();
        RunAllTests executer = new RunAllTests();
        String unzippedFolder = unzipper.unzip(zipFile);

        // ArrayList<Report> idk = new ArrayList<>();

        
        List<String> unzippedSubmissionFoldersPath = zippedSubmissionsPaths.traversefolder(unzippedFolder);
        for(String s : unzippedSubmissionFoldersPath)
        {
            System.out.println(s);
            copier.copyAll(s);
            compiler.compileTest(s);

            List<Result> results = executer.runAll(); 

            Report passengerReport = new PassengerReport(results.get(0));
            Report luggageSlipReport = new LuggageSlipReport(results.get(1));
            Report luggageManifestReport = new LuggageManifestReport(results.get(2));
            Report flightReport = new FlightReport(results.get(3));

            OverallReport overallReport = new OverallReport();

            overallReport.addReport(passengerReport);
            overallReport.addReport(luggageSlipReport);
            overallReport.addReport(luggageManifestReport);
            overallReport.addReport(flightReport);

            // /Users/jerrellejohnson/Desktop/tesing/submissions/Zachary_Rampersad_816031173_A1/Zachary_Rampersad_816031173_A1.pdf
            // System
            // System.out.println("Recommendations: " + overallReport.recommendationsToString());
            

        }
    }
}