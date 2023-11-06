package oop2_project;
import java.io.*;
import java.util.zip.*;

public class UnzipUtility {

    public String unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                    if (filePath.endsWith(".zip")) {
                        // If the file is a zip file, recursively unzip it
                        unzip(filePath, filePath.substring(0, filePath.length() - 4));
                    }
                } else {
                    File dir = new File(filePath);
                    dir.mkdir();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
        return destDirectory;
    }

    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        File outFile = new File(filePath);
        File parentDir = outFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }
    
    
}
