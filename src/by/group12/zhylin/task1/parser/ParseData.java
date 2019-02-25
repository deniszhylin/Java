package by.group12.zhylin.task1.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseData {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_NUMBER = "\\d{1,3}\\.\\d{1,3}";

    public ArrayList<Double> parseDataList(List<String> arrayStringData) {
        ArrayList<Double> arrayListDataPoints = new ArrayList();
        if (arrayStringData.isEmpty()) {
            LOGGER.log(Level.FATAL, "No valid data to process!");
        } else {
            Pattern regex = Pattern.compile(REGEX_NUMBER);
            for (int i = 0; i < arrayStringData.size(); i++) {
                Matcher matcher = regex.matcher(arrayStringData.get(i));
                while (matcher.find()) {
                    arrayListDataPoints.add(Double.parseDouble(matcher.group()));
                }
            }
        }
        return arrayListDataPoints;
    }
}