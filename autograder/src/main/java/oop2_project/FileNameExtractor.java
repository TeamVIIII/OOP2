package oop2_project;

import java.io.File;

public class FileNameExtractor {
    public static String extractFileName(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf('.');

        if (lastDotIndex > 0) {
            // If there is a file extension, extract the name without it
            return fileName.substring(0, lastDotIndex);
        } else {
            // If there is no file extension, return the whole file name
            return fileName;
        }
    }

    public static void main(String[] args) {
        String filePath = "/Users/jerrellejohnson/Desktop/tesing/submissions/LuggageManagementSystem";
        String extractedFileName = extractFileName(filePath);
        System.out.println("Extracted file name: " + extractedFileName);
    }
}