package services;

import models.Writing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileServices {
    public List<String> readTextFile(Path p) throws IOException {
        List<String> textLines = Files.readAllLines(p);
        return textLines;
    }
    public void writeFile(Writing writing) throws IOException {
        Files.writeString(writing.getP(),writing.getText(), StandardOpenOption.CREATE);
    }


    public void fileToCreate(String fToCreate) throws IOException {
        Path p = Path.of("target/",fToCreate);
        Files.createFile(p);
    }

    public void copyFile(Path p) throws IOException {
        Path newPath = Path.of("target/", p.toFile().getName());
        Files.copy(p, newPath);
    }
}
