package oop2_project;

import com.itextpdf.text.Document;  

public abstract class ReportGeneratorTemplate{
    
    public final void generatePDF(String outputPath) {
        generate(outputPath);
    }

    protected abstract void generate(String outputPath);
    protected abstract void createTable(Document document);
    
}
