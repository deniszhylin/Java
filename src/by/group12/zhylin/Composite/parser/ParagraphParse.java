package by.group12.zhylin.Composite.parser;

import by.group12.zhylin.Composite.composite.Component;
import by.group12.zhylin.Composite.composite.ComponentType;
import by.group12.zhylin.Composite.composite.Composite;
import by.group12.zhylin.Composite.exception.CustomException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.group12.zhylin.Composite.composite.ComponentType.PARAGRAPH;

public class ParagraphParse implements ParserTemplate {
    private SentenceParse sentenceParse;

    ParagraphParse(SentenceParse sentenceParse) {
        this.sentenceParse = sentenceParse;
    }

    @Override
    public void parse(Component textComposite, String text) throws CustomException {
        Pattern pattern = Pattern.compile(PARAGRAPH.getDescription());
        Matcher matcher = pattern.matcher(text);
        String[] paragraphArray = text.split(PARAGRAPH.getDescription());

        for (String paragraph : paragraphArray) {
            paragraph = paragraph.trim();
            if (matcher.find() && !matcher.group().isEmpty()) {
                paragraph = paragraph + " " + matcher.group();
            }
            if (sentenceParse != null) {
                Component paragraphComposite = new Composite(ComponentType.PARAGRAPH);
                sentenceParse.parse(paragraphComposite, paragraph);
                textComposite.addComponent(paragraphComposite);
            }
        }
    }
}