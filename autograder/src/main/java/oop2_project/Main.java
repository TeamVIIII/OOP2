package oop2_project;

import java.util.List;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

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
        


        //System.out.println(unzippedFolder);
        //====================================================================

        // ArrayList<Report> idk = new ArrayList<>();
        /* 
        
         *///====================================================================
        
       List<String> unzippedSubmissionFoldersPath = zippedSubmissionsPaths.traversefolder(unzippedFolder);
        //for(String s : unzippedSubmissionFoldersPath)
        //{ 
            //System.out.println(s);


            System.out.println(unzippedSubmissionFoldersPath.get(1));
            copier.copyAll(unzippedSubmissionFoldersPath.get(1));
            compiler.compileTest(unzippedSubmissionFoldersPath.get(1)); 

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
            System.out.println(overallReport.recommendationsToString());

            List<String[]> failedTests = new ArrayList<>();
            List<String[]> description = new ArrayList<>();
            List<String> fails = new ArrayList<>();
            //testCases.add(new String[]{"Passenger", "8", "7"});
            //testCases.add(new String[]{"Flight", "12", "10"});
            //description.add(new String[]{"Checking the desccription text"});
            //description.add(new String[]{"Checking the desccription text #2"});
            String fileName = FileNameExtractor.extractFileName(unzippedSubmissionFoldersPath.get(1));
            ReportGeneratorTemplate pdf = new PDFGenerator(failedTests, description,overallReport);
            pdf.generatePDF(unzippedSubmissionFoldersPath.get(1) + "\\" + fileName + ".pdf");

            

            // /Users/jerrellejohnson/Desktop/tesing/submissions/Zachary_Rampersad_816031173_A1/Zachary_Rampersad_816031173_A1.pdf
            // System
            // System.out.println("Recommendations: " + overallReport.recommendationsToString());
            // "C:\\Users\\jmitc\\Downloads\\submissions\\Zachary_Rampersad_816031173_A1.zip"
            // C:\\Users\\jmitc\\Downloads\\submissions\\Zachary_Rampersad_816031173_A1
            // "C:\\Users\\jmitc\\Downloads\\submissions.zip"
            //"C:\\Users\\jmitc\\Downloads\\submissions.zip"
        //}
 
        

    }
}