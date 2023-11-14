package oop2_project;

import java.util.List;
import org.junit.runner.Result;

public class Main {
    public static void main(String[] args) {
        String zipFile = "/Users/jerrellejohnson/Desktop/tesing/submissions.zip";
        UnzipUtility unzipper = new UnzipUtility();
        GetUnzippedPaths zippedSubmissionsPaths = new GetUnzippedPaths();
        CopyAll copier = new CopyAll();
        Compiler compiler = new Compiler();
        RunAllTests executer = new RunAllTests();
        String unzippedFolder = unzipper.unzip(zipFile);
        
       List<String> unzippedSubmissionFoldersPath = zippedSubmissionsPaths.traversefolder(unzippedFolder);
        for(String s : unzippedSubmissionFoldersPath)
        { 
            System.out.println(s);
            copier.copyAll(s);
            compiler.compileTest(s); 


            // System.out.println(unzippedSubmissionFoldersPath.get(1));
            // copier.copyAll(unzippedSubmissionFoldersPath.get(1));
            // compiler.compileTest(unzippedSubmissionFoldersPath.get(1)); 

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

        }
    }
}