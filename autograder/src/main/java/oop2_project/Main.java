package oop2_project;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String zipFile = "/Users/jerrellejohnson/Desktop/tesing/submissions.zip";

        UnzipUtility unzipper = new UnzipUtility();
        
        String unzippedFolder = unzipper.unzip(zipFile);

        GetUnzippedPaths zippedSubmissionsPaths = new GetUnzippedPaths();
        List<String> filepaths = zippedSubmissionsPaths.traversefolder(unzippedFolder);

        for(String path : filepaths)
            System.out.println(path);

    }
}