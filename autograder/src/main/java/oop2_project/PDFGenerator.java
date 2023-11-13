package oop2_project;

import java.io.FileOutputStream;
import java.util.List;


import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;


public class PDFGenerator extends ReportGeneratorTemplate{
    private final List<String[]> testCases;
    private final List<String[]> improvementText;

    public PDFGenerator(List<String[]> testCases, List<String[]> improvementText){
        this.testCases = testCases;
        this.improvementText = improvementText;
    }

    protected void generate(String outputPath){
        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();
            createTable(document);
            createDescription(document);
            document.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void createTable(Document document) {
        PdfPTable table = new PdfPTable(3);
        // Set table alignment
        table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

        //Table table = new Table(3); // create a table with 3 columns

        // Add table headers
        table.addCell("Class");
        table.addCell("Total");
        table.addCell("Mark");

        // Add table data
        for (String[] testCase : testCases) {
            for (String cell : testCase) {
                // Set cell alignment
                table.addCell(new Paragraph(cell, getCellFont()));
            }
        }
        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    protected void createDescription(Document document) {
        Paragraph paragraph = new Paragraph();
        // Set paragraph alignment
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);

        /* paragraph.add("This is a description.");
        paragraph.add(Chunk.NEWLINE);
        paragraph.add("More description text here.");
        paragraph.add(Chunk.NEWLINE);
        paragraph.add("Even more description text.");
 */
        for(String[] improvemets : improvementText){
            for(String text : improvemets){
                paragraph.add(Chunk.NEWLINE);
                paragraph.add(text);
            }
        }


        try {
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private com.itextpdf.text.Font getCellFont() {
        // Set font properties for the cells
        com.itextpdf.text.Font font = new com.itextpdf.text.Font();
        font.setSize(10);
        return font;
    }
}
