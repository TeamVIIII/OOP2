package oop2_project;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UnzipUtilityTest {

    @Test
    public void testUnzip() throws IOException {
        // Mocking the FileInputStream and ZipInputStream
        FileInputStream fileInputStream = Mockito.mock(FileInputStream.class);
        ZipInputStream zipInputStream = Mockito.mock(ZipInputStream.class);

        // Mocking the behavior of zipInputStream to simulate a real scenario
        when(zipInputStream.getNextEntry()).thenReturn(null);

        // Mocking the behavior of fileInputStream to return our mocked ZipInputStream
        when(fileInputStream.read()).thenReturn(-1);

        UnzipUtility unzipUtility = new UnzipUtility();

        String zipFilePath = "path/to/zip/file.zip";
        String expectedOutput = new File(zipFilePath).getParent() + File.separator + new File(zipFilePath).getName().replace(".zip", "");

        String actualOutput = unzipUtility.unzip(zipFilePath);

        assertEquals(expectedOutput, actualOutput);
    }
}
