package oop2_project;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipFile;

import org.junit.runner.Result;

public class AutoGradeFacade implements Facade 
{
    public List<String> getSubmissionFolders(String submissionsZippedPath)
    {
        UnzipUtility unzipper = new UnzipUtility();
        GetUnzippedPaths zippedSubmissionsPaths = new GetUnzippedPaths();
        String unzippedFolder = unzipper.unzip(submissionsZippedPath);

        return zippedSubmissionsPaths.traversefolder(unzippedFolder);
    }

    public OverallReport getReport(String studentFolderPath)
    {
        CopyAll copier = new CopyAll();
        Compiler compiler = new Compiler();
        RunAllTests executer = new RunAllTests();

        copier.copyAll(studentFolderPath);
        compiler.compileTest(studentFolderPath);
        
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

        return overallReport;
    }

    public void generatePDf(OverallReport report, String folderpath)
    {
        String fileName = FileNameExtractor.extractFileName(folderpath);
        ReportGeneratorTemplate pdf = new PDFGenerator(report);
            
        pdf.generatePDF(folderpath + "/" + fileName + ".pdf");
    }

    public boolean isValidZipFile(String submissionsZippedPath) 
    {
        Path filePath = Path.of(submissionsZippedPath);
        if (Files.exists(filePath)) 
        {
            try (ZipFile zipFile = new ZipFile(filePath.toFile())) 
            {
                return true; // If opening the ZipFile succeeds, it is a valid ZIP file
            } 
            catch (Exception e) 
            {
                System.out.println("Not a valid zipfile! \n " + e);
                return false; // Opening the ZipFile failed, indicating it is not a valid ZIP file
            }
        } else 
        {  
            System.out.println("Not a valid file!");
            return false; // The file does not exist, so it cannot be a valid ZIP file
        }
    }

    
}
