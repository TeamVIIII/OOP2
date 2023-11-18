package oop2_project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CopyAll extends Copier
{

    ArrayList<String> fileNames = new ArrayList<>();

    public boolean copyAll(String folderPath)
    {
        

        fileNames.add("Passenger.java");
        fileNames.add("LuggageSlip.java");
        fileNames.add("LuggageManifest.java");
        fileNames.add("Flight.java");

        if(!isAllFilesContainedInFolder(folderPath)){

            return false;
        }

        List<String> destinations = new ArrayList<>(4);
        List<String> sources = new ArrayList<>(4);
        
        String thisFolder = "src/main/java/oop2_project";
        
        destinations.add(thisFolder + "/Passenger.java");
        destinations.add(thisFolder + "/LuggageSlip.java");
        destinations.add(thisFolder + "/LuggageManifest.java");
        destinations.add(thisFolder + "/Flight.java");

        sources.add(folderPath + "/Passenger.java");
        sources.add(folderPath + "/LuggageSlip.java");
        sources.add(folderPath + "/LuggageManifest.java");
        sources.add(folderPath + "/Flight.java");

        for(int i = 0; i<4; i++)
        {
            copyFile(sources.get(i), destinations.get(i));
        }
        
        return true;
    }
    
    public boolean isAllFilesContainedInFolder(String folderPath){

        for(String file: fileNames){
            if(!isFileContainedInFolder(folderPath, file)){
                return false;
            }
        }


        return true;
    }

    public static boolean isFileContainedInFolder(String folderPath, String fileName) {
        File folder = new File(folderPath);

        if (!folder.isDirectory()) {
            return false;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            return false;
        }

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return true;
            }
        }

        return false;
    }


}
