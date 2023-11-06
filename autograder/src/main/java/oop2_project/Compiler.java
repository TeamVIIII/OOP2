package oop2_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compiler{
    public boolean compileTest(String filename, String folderPath) {
        String submissionFolder = folderPath;

        // Separate the command into individual arguments
        List<String> compileCommands = new ArrayList<>();
        compileCommands.add("javac");
        compileCommands.add("-cp");
        compileCommands.add(".:junit-4.13.2.jar");
        compileCommands.add(filename);

        try {
            ProcessBuilder compiler = new ProcessBuilder(compileCommands);
            compiler.directory(new File(submissionFolder));
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
