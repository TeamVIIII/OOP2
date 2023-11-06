package oop2_project;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

public class Copier 
{
    public boolean copyFile(String fileToCopy, String DestinationOfFile)
    {
        Path sourcePath = Paths.get(fileToCopy);
        Path destinationDirectory = Paths.get(DestinationOfFile);
        Path destinationFilePath = destinationDirectory.resolve(sourcePath.getFileName());

        try 
        {
            Files.copy(sourcePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error copying the file.");
        }
        return false;
    }
}
