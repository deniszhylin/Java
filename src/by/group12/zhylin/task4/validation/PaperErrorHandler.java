package by.group12.zhylin.task4.validation;


import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaperErrorHandler extends DefaultHandler {
    private static Logger LOGGER = LogManager.getLogger();

    public PaperErrorHandler() {
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        LOGGER.log(Level.WARN, "", e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        LOGGER.log(Level.ERROR, "", e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        LOGGER.log(Level.FATAL, "", e);
    }
}