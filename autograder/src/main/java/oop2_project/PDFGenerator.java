package oop2_project;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import javax.naming.spi.DirStateFactory.Result;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;



public class PDFGenerator extends ReportGeneratorTemplate{
    private final List<String[]> testCases;
    private final List<String[]> improvementText;
    private OverallReport overallReport;
    private AbstractReport ar;
    //private String fileName;

    public PDFGenerator(List<String[]> testCases, List<String[]> improvementText,OverallReport overallReport){
        this.testCases = testCases;
        this.improvementText = improvementText;
        this.overallReport = overallReport;
        //this.fileName = fileName;
    }

    protected void generate(String outputPath){
        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();
            createTable(document);
            createDescription(document);
            addRecommendationsTable(document);
            document.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void addRecommendationsTable(Document document){
        
        Map<String,String> recsPerTest = new HashMap<>();

        for(int i=0;i<overallReport.getNumReports();i++){

            if(overallReport.getReport(i) instanceof AbstractReport){
                AbstractReport rep=(AbstractReport)overallReport.getReport(i);
                ar = rep; 
                recsPerTest = ar.getRecommendationPerTest();
            }

            Paragraph subPara = new Paragraph(overallReport.getReportName(i)+"\n\n", getCellFont());
            
            PdfPTable table = new PdfPTable(2);
            // Set table alignment
            table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            PdfPCell c1 =new PdfPCell(new Phrase("Failed Test/s"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 =new PdfPCell(new Phrase("Recommendation"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            for (Map.Entry<String,String> entry : recsPerTest.entrySet())
            {
                c1 =new PdfPCell(new Phrase(entry.getKey()));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                c1 = new PdfPCell(new Phrase(entry.getValue()));
                table.addCell(c1);

            }
            
            try {
                document.add(subPara);
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }


    }

    protected void createTable(Document document) {
        PdfPTable table = new PdfPTable(3);
        // Set table alignment
        table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

        PdfPCell c1 =new PdfPCell(new Phrase("Class"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 =new PdfPCell(new Phrase("Total"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 =new PdfPCell(new Phrase("Mark"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        for(int i=0;i<overallReport.getNumReports();i++){

            c1 = new PdfPCell(new Phrase(overallReport.getReportName(i)));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase(Integer.toString(overallReport.getTotalMarkbyReport(i))));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase(Integer.toString(overallReport.getAcquiredMarkbyReport(i))));
            table.addCell(c1);
        }

        c1 = new PdfPCell(new Phrase("Compiled"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("5"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("5"));
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Total Mark Acquired:"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase(Integer.toString(overallReport.getTotalMark())));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase(Integer.toString(overallReport.getAcquiredMark())));
        table.addCell(c1);



        // Add table headers
        // table.addCell("Class");
        // table.addCell("Total");
        // table.addCell("Mark");

        // Add table data
        // for (String[] testCase : testCases) {
        //     for (String cell : testCase) {
        //         // Set cell alignment
        //         table.addCell(new Paragraph(cell, getCellFont()));
        //     }
        // }
        

        
        
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
