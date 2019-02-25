package by.group12.zhylin.task4.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SAXValidator {
    private static final Logger LOGGER = LogManager.getLogger();
    private Path filePath;
    private Path schemaPath;

    public SAXValidator(Path filePath, Path schemaPath) {
        this.filePath = filePath;
        this.schemaPath = schemaPath;
    }

    public boolean validate() {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema;
        try {
            schema = factory.newSchema(schemaPath.toFile());
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(filePath.toFile(), new PaperErrorHandler());
            return true;
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.ERROR, "Invalid FileParseConfiguration to schema");
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "It's not a valid file");
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "It's not a valid file to SAX");
        }
        return false;
    }
}