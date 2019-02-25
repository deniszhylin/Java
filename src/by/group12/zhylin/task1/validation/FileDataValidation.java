package by.group12.zhylin.task1.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDataValidation {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_TEMPLATE =
      "^\\d{1,3}.\\d{1,3},\\d{1,3}.\\d{1,3},\\d{1,3}.\\d{1,3},\\d{1,3}.\\d{1,3},\\d{1,3}.\\d{1,3},\\d{1,3}.\\d{1,3}$";

    public boolean dataValidation(String source) {
        boolean flag = false;
        Pattern regex = Pattern.compile(REGEX_TEMPLATE);
        Matcher matcher = regex.matcher(source);
        if (matcher.find()) {
            flag = true;
        } else {
            LOGGER.log(Level.WARN, "Invalid string." + source);
        }
        return flag;
    }
}