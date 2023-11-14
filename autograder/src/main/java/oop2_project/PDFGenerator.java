package oop2_project;

import java.util.List;
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream; 


public class PDFGenerator extends ReportGeneratorTemplate{
    private final List<String[]> testCases;

    public PDFGenerator(List<String[]> testCases){
        this.testCases = testCases;
    }

    protected  void generate(String outputPath)
    {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            System.out.print(outputPath);
            document.open();
            createTable(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void createTable(Document document) {
        
        PdfPTable table = new PdfPTable(3);
        //Table table = new Table(3); // create a table with 3 columns

        // Add table headers
        table.addCell("Class");
        table.addCell("Total");
        table.addCell("Mark");

        // Add table data
        for (String[] testCase : testCases) {
            for (String cell : testCase) {
                table.addCell(cell);
            }
        }
        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
