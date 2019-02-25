package by.group12.zhylin.task4.builder;

import by.group12.zhylin.task4.entity.Paper;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class PapersSAXBuilder {
    private static final Logger LOGGER = LogManager.getLogger();
    private List<Paper> papers;
    private PaperHandler paperHandler;
    private XMLReader reader;

    public PapersSAXBuilder() {
        paperHandler = new PaperHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
  //          reader.getContentHandler(paperHandler);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "Error while creating XMLReader", e);
        }
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void buildPapersList(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Error in filename", e);
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "Parsing error", e);
        }
        papers = paperHandler.getPapers();
    }
}