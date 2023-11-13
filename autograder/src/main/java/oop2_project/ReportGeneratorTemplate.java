package oop2_project;

import java.io.FileOutputStream;  
import com.itextpdf.text.Document;   
import com.itextpdf.text.pdf.PdfWriter; 

public abstract class ReportGeneratorTemplate{
    public final void generatePDF(String outputPath) {
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

    protected abstract void createTable(Document document);
    
}
