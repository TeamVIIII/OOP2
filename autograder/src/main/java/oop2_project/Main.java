package oop2_project;

import java.util.List;

import org.junit.runner.Result;

public class Main {
    public static void main(String[] args) {
        String zipFile = "/Users/jerrellejohnson/Desktop/tesing/submissions.zip";

        UnzipUtility unzipper = new UnzipUtility();
        
        String unzippedFolder = unzipper.unzip(zipFile);

        GetUnzippedPaths zippedSubmissionsPaths = new GetUnzippedPaths();
        List<String> filepaths = zippedSubmissionsPaths.traversefolder(unzippedFolder);

        RunAllTests executer = new RunAllTests();
        List<Result> results = executer.runAll();

        Report report = new PassengerReport(results.get(0));
        report.viewDetails();
    }
}