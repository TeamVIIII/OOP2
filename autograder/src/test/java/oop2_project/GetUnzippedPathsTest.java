package oop2_project;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class GetUnzippedPathsTest {
   private GetUnzippedPaths getUnzippedPaths;

   @Before
   public void setUp() {
       getUnzippedPaths = new GetUnzippedPaths();
   }

   @Test
   public void testTraverseFolder_DirectoryExists() {
    Path directoryPath = Paths.get("testDirectory");
    Path subdirectoryPath = Paths.get("testDirectory", "subDirectory");
    try {
        Files.createDirectories(directoryPath);
        Files.createDirectories(subdirectoryPath);
        List<String> result = getUnzippedPaths.traversefolder(directoryPath.toString());
        assertTrue(result.contains(subdirectoryPath.toString()));
    } catch (IOException e) {
        fail("IOException occurred: " + e.getMessage());
    } finally {
        try {
            Files.walkFileTree(directoryPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
    } catch (IOException e) {
        fail("Failed to delete directory: " + e.getMessage());
    }
   }
}


   @Test
   public void testTraverseFolder_DirectoryDoesNotExist() {
       List<String> result = getUnzippedPaths.traversefolder("nonExistentDirectory");
       assertTrue(result.isEmpty());
   }
}
