package oop2_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compiler{
    public boolean compileTest(String folderPath) {
        List<String> compileCommands = new ArrayList<>();
        compileCommands.add("javac");
        compileCommands.add("-cp");
        compileCommands.add("junit-4.13.2.jar");
        compileCommands.add("Passenger.java"); // Filename must be in form "Passenger.java" not "/Passenger.java"
        compileCommands.add("LuggageSlip.java");
        compileCommands.add("LuggageManifest.java");
        compileCommands.add("Flight.java");
        compileCommands.add("PassengerTest.java");
        compileCommands.add("FlightTest.java");
        compileCommands.add("LuggageSlipTest.java");
        compileCommands.add("LuggageManifestTest.java");

        try {
            ProcessBuilder compiler = new ProcessBuilder(compileCommands);
            compiler.directory(new File("src/main/java/oop2_project"));
            Process compileProcess = compiler.start();
            int compileExitCode = compileProcess.waitFor();

            if (compileExitCode == 0)
                return true;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }
}
