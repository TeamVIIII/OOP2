package oop2_project;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compiler{
    public boolean compileTest(String folderPath) {

        if(!containsJavaFiles(folderPath)){
            return false;
        }

        List<String> compileCommands = new ArrayList<>();
        compileCommands.add("javac");
        compileCommands.add("-cp");
        compileCommands.add("junit-4.13.2.jar");
        compileCommands.add("Passenger.java");
        compileCommands.add("LuggageSlip.java");
        compileCommands.add("LuggageManifest.java");
        compileCommands.add("Flight.java");
        compileCommands.add("PassengerTest.java");
        compileCommands.add("FlightTest.java");
        compileCommands.add("LuggageSlipTest.java");
        compileCommands.add("LuggageManifestTest.java");

        try 
        {
            ProcessBuilder compiler = new ProcessBuilder(compileCommands);
            compiler.directory(new File("src/main/java/oop2_project"));
            Process compileProcess = compiler.start();
            int compileExitCode = compileProcess.waitFor();

            if (compileExitCode == 0)
                return true;

            if(compileExitCode !=0){
                System.out.println("Error compiling tests");
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return false;
    }

    public boolean containsJavaFiles(String folderPath){
        File submissionFile = new File(folderPath);
        FilenameFilter javaFileFilter = (dir, name) -> name.endsWith(".java");
        String[] files = submissionFile.list(javaFileFilter);
        return files.length > 0;
    }    

}
