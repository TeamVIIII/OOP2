package oop2_project;

import java.util.ArrayList;
import java.util.List;

public class CopyAll extends Copier
{
    public void copyAll(String folderPath)
    {
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
            copyFile(sources.get(i), destinations.get(i));
    }
}
