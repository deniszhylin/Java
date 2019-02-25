package by.group12.zhylin.XMLParsingWeb.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XMLValidator {
    private static final Logger LOGGER = LogManager.getLogger();
    private Path filePath;
    private Path schemaPath;

    public XMLValidator(Path filePath, Path schemaPath) {
        this.filePath = filePath;
        this.schemaPath = schemaPath;
    }

    public boolean validate() {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);

        Schema schema;
        try {
            schema = factory.newSchema(schemaPath.toFile());
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filePath.toFile());
            validator.validate(source);
            LOGGER.log(Level.INFO, filePath.getFileName() + " is valid.");
            return true;
        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "validation of " + filePath.getFileName() + " is not valid");
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "wrong" + filePath.getFileName());
        }
        LOGGER.log(Level.INFO, filePath.getFileName() + " is not valid.");
        return false;
    }
}