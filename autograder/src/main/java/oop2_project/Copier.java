package oop2_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Copier 
{
    protected void copyTest(String testFilePath, String submissionFilePath)
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(testFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(submissionFilePath));

            // Write the package declaration at the top
            writer.write("package oop2_project;");
            writer.newLine();
            writer.newLine();

            // Copies the rest of the original .java file
            String line;
            while ((line = reader.readLine()) != null) 
            {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}

