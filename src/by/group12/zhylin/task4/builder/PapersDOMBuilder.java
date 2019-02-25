package by.group12.zhylin.task4.builder;

import by.group12.zhylin.task4.entity.Booklet;
import by.group12.zhylin.task4.entity.Magazine;
import by.group12.zhylin.task4.entity.Newspaper;
import by.group12.zhylin.task4.entity.Paper;
import by.group12.zhylin.task4.exception.IncorrectValueException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PapersDOMBuilder {
    private static final Logger LOGGER = LogManager.getLogger();
    private List<Paper> papers;
    private DocumentBuilder documentBuilder;

    private static final String DASH = "-";
    private static final String UNDERLINE = "_";

    public PapersDOMBuilder() {
        papers = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.FATAL, e);
        }
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void buldPapersList(String fileName) {
        Document document;
        try {
            document = documentBuilder.parse(fileName);
            Element rootElement = document.getDocumentElement();

            NodeList newspaperList = rootElement.getElementsByTagName(PapersCharacteristic.NEWSPAPER.getValue());
            NodeList magazineList = rootElement.getElementsByTagName(PapersCharacteristic.MAGAZINE.getValue());
            NodeList bookletList = rootElement.getElementsByTagName(PapersCharacteristic.BOOKLET.getValue());
            Element newspaperElement;
            Element magazineElement;
            Element bookletElement;

            for (int i = 0; i < newspaperList.getLength(); i++) {
                newspaperElement = (Element) newspaperList.item(i);
                papers.add(buildNewspaper(newspaperElement));
            }
            for (int i = 0; i < magazineList.getLength(); i++) {
                magazineElement = (Element) magazineList.item(i);
                papers.add(buildMagazine(magazineElement));
            }
            for (int i = 0; i < bookletList.getLength(); i++) {
                bookletElement = (Element) bookletList.item(i);
                papers.add(buildBooklet(bookletElement));
            }

        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "Error in document parsing");
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "Error in filename");
        } catch (IncorrectValueException e) {
            LOGGER.log(Level.ERROR, "Invalid value element");
        }
    }

    public Newspaper buildNewspaper(Element paperElement) throws IncorrectValueException {
        Newspaper paper = (Newspaper) buildPaper(new Newspaper(), paperElement);
        paper.setIndex(Integer.parseInt(getElementValue(paperElement, PapersCharacteristic.INDEX.getValue())));
        return paper;
    }

    public Magazine buildMagazine(Element paperElement) throws IncorrectValueException {
        Magazine paper = (Magazine) buildPaper(new Magazine(), paperElement);
        paper.setIndex(Integer.parseInt(getElementValue(paperElement, PapersCharacteristic.INDEX.getValue())));
        paper.setMonthly(Boolean.parseBoolean(getElementValue(paperElement, PapersCharacteristic.MONTHLY.getValue())));
        return paper;
    }

    public Booklet buildBooklet(Element paperElement) throws IncorrectValueException {
        Booklet paper = (Booklet) buildPaper(new Booklet(), paperElement);
        paper.setMonthly(Boolean.parseBoolean(getElementValue(paperElement, PapersCharacteristic.MONTHLY.getValue())));
        return paper;
    }

    public Paper buildPaper(Paper paper, Element paperElement) throws IncorrectValueException {
        Element specications = (Element) paperElement.getElementsByTagName(PapersCharacteristic.SPECIFICATIONS.getValue()).item(0);
        paper.setName(paperElement.getAttribute(PapersCharacteristic.NAME.getValue()));
        paper.setId(paperElement.getAttribute(PapersCharacteristic.ID.getValue()));
        paper.setDate(LocalDate.parse(paperElement.getAttribute(PapersCharacteristic.DATE.getValue())));
        paper.getSpecications().setColor(getElementValue(specications, PapersCharacteristic.COLOR.getValue()));
        paper.getSpecications().setCoated(Boolean.parseBoolean(getElementValue(specications, PapersCharacteristic.COATED.getValue())));
        paper.getSpecications().setPages(Integer.parseInt(getElementValue(specications, PapersCharacteristic.PAGES.getValue())));
        return paper;
    }

    private static String getElementValue(Element parentElement, String tagName) {
        return parentElement.getElementsByTagName(tagName).item(0).getTextContent().replace(DASH, UNDERLINE);
    }
}