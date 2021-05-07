package com.employee.payroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class FileApiTest {
    private String Home = System.getProperty("user.home");
    private String testDirectory = "TestDirectory";

    @Test
    void checkDirectoryAlreadyPresent() throws IOException {
        Path path = Paths.get(Home);
        Assertions.assertTrue(Files.exists(path));

        /**
         * if the directory already exists then delete method
         */
        Path newDirectoryPath = Paths.get(Home + "/" + testDirectory);
        if(Files.exists(newDirectoryPath)) FilesUtility.deleteFiles(newDirectoryPath.toFile());
        Assertions.assertTrue(Files.notExists(newDirectoryPath));

        /**
         * to create new directory
         */
        Files.createDirectory(newDirectoryPath);
        Assertions.assertTrue(Files.exists(newDirectoryPath));

        /**
         * for fixed loop , used IntStream
         */
        IntStream.range(1, 10).forEach(fileNumber -> {
            String filePath = testDirectory + "/" + "TempFile" + fileNumber;
            Path tempPath = Paths.get(filePath);
            try {
                Files.createFile(tempPath);
            } catch (IOException e) {
                Assertions.assertTrue(Files.exists(tempPath));
            }
        });

        Files.list(newDirectoryPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(newDirectoryPath).forEach(System.out::println);
        Files.newDirectoryStream(newDirectoryPath, pathOne -> pathOne.toFile().isFile() &&
                pathOne.toString().startsWith("Temp")).forEach(System.out::println);
    }

    @Test
    public void givenDirectoryWhenWatchedListsAllTheActivities() throws IOException {
        Path dir = Paths.get(Home + "/" + testDirectory);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new WatchService(dir).processEvents();
    }
}
