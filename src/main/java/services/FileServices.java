package services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServices {
    public List<String> readTextFile(Path p) throws IOException {
        List<String> textLines = Files.readAllLines(p);
        return textLines;
    }
}
