package com.employee.payroll;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WatchServiceTesting {
    @Test
    public void eventsMustBeListedAndLogged() throws IOException {
        Path dir = Paths.get("TestDirectory");
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new WatchService(dir).processEvents();
    }
}
