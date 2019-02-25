package by.group12.zhylin.Tetrahedron.read;

import by.group12.zhylin.Tetrahedron.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.group12.zhylin.Tetrahedron.validation.FileDataValidation;

public class FileReading {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String FILE_PATH_DEFAULT = ".\\data\\data.txt";

    public List<String> dataFileRead(String filePath) throws CustomException {
        if (filePath.trim().isEmpty()) {
            filePath = FILE_PATH_DEFAULT;
            LOGGER.log(Level.INFO, "Applied FILE_PATH_DEFAULT");
        }
        String source;
        List<String> arrayStringData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            do {
                source = bufferedReader.readLine();
                FileDataValidation fileDataValidation = new FileDataValidation();
                if (fileDataValidation.dataValidation(source)) {
                    arrayStringData.add(source);
                }
            } while (source != null);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FATAL, "File reader error ..." + filePath, e);
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "Error opening file...", e);
            throw new RuntimeException("Error opening file...", e);
        }
        return arrayStringData;
    }
}