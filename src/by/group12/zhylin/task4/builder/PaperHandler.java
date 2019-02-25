package by.group12.zhylin.task4.builder;

import by.group12.zhylin.task4.entity.Booklet;
import by.group12.zhylin.task4.entity.Magazine;
import by.group12.zhylin.task4.entity.Newspaper;
import by.group12.zhylin.task4.entity.Paper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaperHandler extends DefaultHandler {
    private List<Paper> papers;
    private Paper currentPaper;
    private PapersCharacteristic currentElement = PapersCharacteristic.EMPTY_TAG;

    private static final String DASH = "-";
    private static final String UNDERLINE = "_";

    public PaperHandler() {
        papers = new ArrayList<>();
    }

    public List<Paper> getPapers() {
        return papers;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        PapersCharacteristic characteristic = PapersCharacteristic.valueOf(localName.toUpperCase().replace(DASH, UNDERLINE));
        switch (characteristic) {
            case NEWSPAPER:
                currentPaper = new Newspaper();
                setNameAttribute(attributes);
                break;
            case MAGAZINE:
                currentPaper = new Magazine();
                setNameAttribute(attributes);
                break;
            case BOOKLET:
                currentPaper = new Booklet();
                setNameAttribute(attributes);
                break;
            case PAPER:
            case PAPERS:
            case SPECIFICATIONS:
                currentElement = PapersCharacteristic.EMPTY_TAG;
                break;
            default:
                currentElement = PapersCharacteristic.valueOf(localName.toUpperCase().replace(DASH, UNDERLINE));
        }
    }

    private void setNameAttribute(Attributes attributes) {
        currentPaper.setName(attributes.getValue(PapersCharacteristic.NAME.getValue()));
        currentPaper.setId(attributes.getValue(PapersCharacteristic.ID.getValue()));
        currentPaper.setDate(LocalDate.parse(attributes.getValue(PapersCharacteristic.DATE.getValue())));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (PapersCharacteristic.NEWSPAPER.getValue().equals(localName) ||
                PapersCharacteristic.MAGAZINE.getValue().equals(localName) ||
                PapersCharacteristic.BOOKLET.getValue().equals(localName)) {
            papers.add(currentPaper);
        }
        currentElement = PapersCharacteristic.EMPTY_TAG;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length).trim().replace(DASH, UNDERLINE);
        if (currentElement != PapersCharacteristic.EMPTY_TAG) {
            switch (currentElement) {
                case COLOR:
                    currentPaper.getSpecications().setColor(text);
                    break;
                case COATED:
                    currentPaper.getSpecications().setCoated(Boolean.parseBoolean(text));
                    break;
                case PAGES:
                    currentPaper.getSpecications().setPages(Integer.parseInt(text));
                    break;
                case INDEX:
                    ((Newspaper) currentPaper).setIndex(Integer.parseInt(text));
                    ((Magazine) currentPaper).setIndex(Integer.parseInt(text));
                    break;
                case MONTHLY:
                    ((Magazine) currentPaper).setMonthly(Boolean.parseBoolean(text));
                    ((Booklet) currentPaper).setMonthly(Boolean.parseBoolean(text));
                    break;
                default:
                    throw new SAXException("Tag was not recognized");
            }
        }
    }
}