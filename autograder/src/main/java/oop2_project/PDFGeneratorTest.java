package oop2_project;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;

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
        String filePath = "C:\\Users\\kiran\\Desktop\\OOP2\\autograder\\testData\\submissions5.pdf";
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
        assertTrue( "PDF file was not created correctly.",pdfContainsAll);
        
        
    }

    @Test
    public void testFailedPDFGenerator(){

        String extractedText = "";
        String filePath = "C:\\Users\\kiran\\Desktop\\OOP2\\autograder\\testData\\submissions5.pdf";
        String expectedText = "Some or all java files were missing"+"0"+"0"+"Compiled"+"5"+"0"+"Total Mark Acquired:"+"0"+"0";
        
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

        assertEquals("PDF file was not created correctly.",expectedText,extractedText);
        

    }

    // @Test
    // public void testGenerate(){
        
    // }

    // @Test
    // public void testGenerateFailedPDF(){
        
    // }

    // @Test
    // public void testCreateFailedTable(){

    // }

    // @Test
    // public void testCreatedTable(){
        
    // }

    // @Test
    // public void testAddRecommendationsTable(){
        
    // }
    
}
