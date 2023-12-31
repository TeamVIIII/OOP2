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
        Copier copier = new CopyAll();
        Compiler compiler = new Compiler();
        RunTest executer = new RunAllTests();
        OverallReport overallReport;

        if(copier.copyAll(studentFolderPath))
        {
            if(compiler.compileTest())
            {
                List<Result> results = executer.runAll();
                overallReport = new OverallReport();
                Report passengerReport = new PassengerReport(results.get(0));
                Report luggageSlipReport = new LuggageSlipReport(results.get(1));
                Report luggageManifestReport = new LuggageManifestReport(results.get(2));
                Report flightReport = new FlightReport(results.get(3));

                overallReport.addReport(passengerReport);
                overallReport.addReport(luggageSlipReport);
                overallReport.addReport(luggageManifestReport);
                overallReport.addReport(flightReport);
                return overallReport;
            }
        }
        
        return null;
    }

    public void generatePDf(OverallReport report, String folderpath)
    {
        String fileName = FileNameExtractor.extractFileName(folderpath);
       
        if(report == null){
            PDFGenerator failedPDF = new PDFGenerator(report);
            failedPDF.generateFailedPDF(folderpath+"/"+fileName+".pdf");
            return;
        }
        
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

    public void delete()
    {
        DeleteClassFiles.deleteFiles();
    }

    public void resetState()
    {
        Copier copier = new CopyAll();
        copier.copyAll("requriedFiles");
    }

    public void emptyGarbage()
    {
        System.gc();
    }

    
}
