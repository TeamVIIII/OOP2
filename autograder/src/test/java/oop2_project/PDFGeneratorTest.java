package oop2_project;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class PDFGeneratorTest {

    private OverallReport overallReport;
    private AbstractReport ar;

    @Before
    public void setup(){

        overallReport = new OverallReport();
        
    }

    @Test
    public void testPDFGenerator(){

        String extractedText = "";
        String filePath = "testData/2Items/LuggageManagementSystem.pdf";
        String[] expectedToContainText = {"Failed Test/s","Recommendation","Passenger","LuggageSlip","LuggageManifest","Flight"};
        boolean pdfContainsAll = true;
        File pdfFile=new File(filePath);

        try{    
            PDDocument document = Loader.loadPDF(pdfFile);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            extractedText = pdfTextStripper.getText(document);
            document.close();
            }catch(Exception e) {
             if (e instanceof IOException) {
                 System.out.println("Completed!");
             }
        }

        for(int i=0;i<expectedToContainText.length;i++){

            if(!extractedText.contains(expectedToContainText[i])){
                pdfContainsAll = false;
                break;
            }

        }

        // Assert that the extracted text contains the expected text
        assertTrue(pdfContainsAll);
        
        
    }

    @Test
    public void testFailedPDFGenerator(){

        String extractedText = "";
        String filePath = "testData/2Items/New_folder.pdf";
        String expectedText = "Class Total Mark\nSome or all java files\nwere missing\n"+"0 "+"0\n"+"Compiled "+"5"+" 0\n"+"Total Mark Acquired: "+"0 "+"0";
        expectedText = expectedText.strip();
        File pdfFile=new File(filePath);

        try{    
            PDDocument document = Loader.loadPDF(pdfFile);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            extractedText = pdfTextStripper.getText(document);
            document.close();
            }catch(Exception e) {
             if (e instanceof IOException) {
                 System.out.println("Completed!");
             }
        }
        extractedText = extractedText.strip();
        assertEquals("PDF file was not created correctly.",expectedText,extractedText);
    }
}