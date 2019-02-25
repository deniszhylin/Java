package by.group12.zhylin.Composite.parser;

import by.group12.zhylin.Composite.composite.Component;
import by.group12.zhylin.Composite.composite.ComponentType;
import by.group12.zhylin.Composite.composite.Composite;
import by.group12.zhylin.Composite.exception.CustomException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParse implements ParserTemplate {
    private LexemParse lexemParse;

    public SentenceParse(LexemParse lexemParse) {
        this.lexemParse = lexemParse;
    }

    @Override
    public void parse(Component paragraphComposite, String paragraph) throws CustomException {
        String sentence;
        Pattern pattern = Pattern.compile(ComponentType.SENTENCE.getDescription());
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            if (lexemParse != null) {
                sentence = matcher.group().trim();
                Component sentenceComposite = new Composite(ComponentType.SENTENCE);
                lexemParse.parse(sentenceComposite, sentence);
                paragraphComposite.addComponent(sentenceComposite);
            }
        }
    }
}