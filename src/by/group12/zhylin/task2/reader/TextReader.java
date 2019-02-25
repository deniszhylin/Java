package by.group12.zhylin.task2.reader;

import by.group12.zhylin.task2.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public String readText(String filePath) throws CustomException {
        if (filePath == null || filePath.isEmpty() || !new File(filePath).exists() || !new File(filePath).isFile()) {
            throw new CustomException("Invalid file path or file not found: " + filePath);
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> stringBuilder.append(s).append("\n"));
        } catch (IOException e) {
            throw new CustomException("Cannot reader file", e);
        }
        LOGGER.log(Level.INFO, "File is reader");
        return stringBuilder.toString();
    }
}