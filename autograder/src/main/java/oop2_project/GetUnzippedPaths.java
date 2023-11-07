package oop2_project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GetUnzippedPaths {
    public List<String> traversefolder(String filepath)
    {
        List<String> submissionPaths = new ArrayList<>();
        Path directoryPath = Paths.get(filepath);

        try (Stream<Path> filePath = Files.list(directoryPath)) {
            filePath.filter(path -> Files.isDirectory(path) && !path.getFileName().toString().equals("__MACOSX"))
                    .forEach(path -> submissionPaths.add(path.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return submissionPaths;
    }
    
}
