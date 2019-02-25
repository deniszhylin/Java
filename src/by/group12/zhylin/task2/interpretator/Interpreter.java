package by.group12.zhylin.task2.interpretator;

import by.group12.zhylin.task2.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptException;
import javax.script.ScriptEngineManager;

public class Interpreter {
    private static final Logger LOGGER = LogManager.getLogger();

    public int bitExpressionCalc(String str) throws CustomException {
        int rez = 0;
        try {
            rez = (int) new ScriptEngineManager().getEngineByName("JavaScript").eval(str);
        } catch (ScriptException e) {
            LOGGER.log(Level.WARN, "Bit expression incorrect", e);
            throw new CustomException("Bit expression incorrect", e);
        } finally {
            LOGGER.log(Level.INFO, "Method bitExpressionCalc processed.");
        }
        return rez;
    }
}