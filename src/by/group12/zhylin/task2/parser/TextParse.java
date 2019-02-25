package by.group12.zhylin.task2.parser;

import by.group12.zhylin.task2.composite.Component;
import by.group12.zhylin.task2.exception.CustomException;

public class TextParse implements ParserTemplate {

    private ParagraphParse paragraphParse;
    private Component textComposite;

    public TextParse() {
        SimbolParse simbolParse = new SimbolParse();
        LexemParse lexemParse = new LexemParse(simbolParse);
        SentenceParse sentenceParse = new SentenceParse(lexemParse);
        this.paragraphParse = new ParagraphParse(sentenceParse);
    }

    public Component getTextComposite() {
        return textComposite;
    }

    @Override
    public void parse(Component textComposite, String text) throws CustomException {
        if (paragraphParse != null) {
            paragraphParse.parse(textComposite, text);
        }
        this.textComposite = textComposite;
    }
}