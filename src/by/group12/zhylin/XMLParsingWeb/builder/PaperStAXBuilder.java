package by.group12.zhylin.XMLParsingWeb.builder;

import by.group12.zhylin.XMLParsingWeb.entity.Booklet;
import by.group12.zhylin.XMLParsingWeb.entity.Magazine;
import by.group12.zhylin.XMLParsingWeb.entity.Newspaper;
import by.group12.zhylin.XMLParsingWeb.entity.Paper;
import by.group12.zhylin.XMLParsingWeb.exception.IncorrectValueException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaperStAXBuilder {
    private static final Logger LOGGER = LogManager.getLogger();
    private List<Paper> papers;
    private XMLInputFactory inputFactory;
    private static final String DASH = "-";
    private static final String UNDERLINE = "_";

    public PaperStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        papers = new ArrayList<>();
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void buildPapersList(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (PapersCharacteristic.NEWSPAPER.getValue().equals(name)) {
                        Paper paper = buildPaper(new Newspaper(), reader);
                        papers.add(paper);
                    } else if (PapersCharacteristic.MAGAZINE.getValue().equals(name)) {
                        Paper paper = buildPaper(new Magazine(), reader);
                        papers.add(paper);
                    } else if (PapersCharacteristic.BOOKLET.getValue().equals(name)) {
                        Paper paper = buildPaper(new Booklet(), reader);
                        papers.add(paper);
                    }
                }
            }
        } catch (IncorrectValueException e) {
            LOGGER.log(Level.ERROR, "Invalid value element", e);
        } catch (XMLStreamException e) {
            LOGGER.log(Level.ERROR, e);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FATAL, e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.log(Level.FATAL, e);
            }
        }
    }

    private Paper buildPaper(Paper paper, XMLStreamReader reader) throws XMLStreamException, IncorrectValueException {
        String name;
        PapersCharacteristic characteristic;
        while (reader.hasNext()) {
            int type = reader.getEventType();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    characteristic = PapersCharacteristic.valueOf(name.toUpperCase().replace(DASH, UNDERLINE));
                    switch (characteristic) {
                        case NEWSPAPER:
                        case MAGAZINE:
                        case BOOKLET:
                            paper.setName(reader.getAttributeValue(null, PapersCharacteristic.NAME.getValue()));
                            paper.setId(reader.getAttributeValue(null, PapersCharacteristic.ID.getValue()));
                            paper.setDate(LocalDate.parse(reader.getAttributeValue(null, PapersCharacteristic.DATE.getValue())));
                            break;
                        case INDEX:
                            ((Newspaper) paper).setIndex(Integer.parseInt(getElementValue(reader)));
                            ((Magazine) paper).setIndex(Integer.parseInt(getElementValue(reader)));
                            break;
                        case MONTHLY:
                            ((Magazine) paper).setMonthly(Boolean.parseBoolean(getElementValue(reader)));
                            ((Booklet) paper).setMonthly(Boolean.parseBoolean(getElementValue(reader)));
                            break;
                        case COLOR:
                            paper.getSpecications().setColor(getElementValue(reader));
                            break;
                        case COATED:
                            boolean coated = Boolean.parseBoolean(getElementValue(reader));
                            paper.getSpecications().setCoated(coated);
                            break;
                        case PAGES:
                            int pages = Integer.parseInt(getElementValue(reader));
                            paper.getSpecications().setPages(pages);
                            break;
                        default:
                            throw new IncorrectValueException("Tag was not recognized");
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    characteristic = PapersCharacteristic.valueOf(name.toUpperCase().replace(DASH, UNDERLINE));
                    if (characteristic == PapersCharacteristic.NEWSPAPER || characteristic == PapersCharacteristic.MAGAZINE ||
                            characteristic == PapersCharacteristic.BOOKLET) {
                        return paper;
                    }
                    break;
            }
            reader.next();
        }
        throw new XMLStreamException("Unknown element in tag Flower");
    }

    private String getElementValue(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText().replace(DASH, UNDERLINE);
        }
        return text;
    }
}