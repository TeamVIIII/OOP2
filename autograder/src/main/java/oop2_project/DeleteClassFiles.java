package oop2_project;

import java.io.File;

public class DeleteClassFiles {
    public static void deleteFiles()
    {
        String[] filesToDelete = {
            "src/main/java/oop2_project/Flight.class",
            "src/main/java/oop2_project/FlightTest.class",
            "src/main/java/oop2_project/LuggageManifest.class",
            "src/main/java/oop2_project/LuggageManifestTest.class",
            "src/main/java/oop2_project/LuggageSlip.class",
            "src/main/java/oop2_project/LuggageSlipTest.class",
            "src/main/java/oop2_project/Passenger.class",
            "src/main/java/oop2_project/PassengerTest.class",
            "target/classes/oop2_project/Flight.class",
            "target/classes/oop2_project/LuggageSlip.class",
            "target/classes/oop2_project/LuggageManifest.class",
            "target/classes/oop2_project/Passenger.class",


            "src/main/java/oop2_project/Flight.java",
            "src/main/java/oop2_project/LuggageSlip.java",
            "src/main/java/oop2_project/LuggageManifest.java",
            "src/main/java/oop2_project/Passenger.java",

        };

        for (String filePath : filesToDelete) {
            File file = new File(filePath);

            if (file.exists()) {
                if (file.delete()) {
                    // System.out.println("Deleted: " + filePath);
                } else {
                    // System.out.println("Failed to delete: " + filePath);
                }
            } else {
                // System.out.println("File not found: " + filePath);
            }
        }

    }
    
}



