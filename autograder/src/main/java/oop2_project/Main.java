package oop2_project;

import java.util.List;
import java.util.Scanner;

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