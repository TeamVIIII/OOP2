package oop2_project;

import java.util.ArrayList;
import java.util.List;

public class CopyAll extends Copier
{
    public void copy(String folderPath)
    {
        List<String> destinations = new ArrayList<>();
        List<String> sources = new ArrayList<>();
        
        String thisFolder = "/Users/jerrellejohnson/Desktop/OOP2 project/OOP2/autograder/src/main/java/oop2_project/";
        destinations.add(thisFolder + "Passenger.java");
        destinations.add(thisFolder + "LuggageSlip.java");
        destinations.add(thisFolder + "LuggageManifest.java");
        destinations.add(thisFolder + "Flight.java");

        sources.add(folderPath + "/Passenger.java");
        sources.add(folderPath + "/LuggageSlip.java");
        sources.add(folderPath + "/LuggageManifest.java");
        sources.add(folderPath + "/Flight.java");

        for(int i = 0; i<4; i++)
            copyFile(sources.get(i), destinations.get(i));
    }
}
