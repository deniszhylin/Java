package by.group12.zhylin.task2.parser;

import by.group12.zhylin.task2.composite.Component;
import by.group12.zhylin.task2.composite.ComponentType;
import by.group12.zhylin.task2.composite.Composite;
import by.group12.zhylin.task2.exception.CustomException;
import by.group12.zhylin.task2.interpretator.Interpreter;
import by.group12.zhylin.task2.validator.ExpressionValidator;

import java.util.regex.Pattern;

public class LexemParse implements ParserTemplate {
    private SimbolParse simbolParse;

    public LexemParse(SimbolParse simbolParse) {
        this.simbolParse = simbolParse;
    }

   /* static boolean isBitExpression(String string) {
        return Pattern.compile(ComponentType.EXPRESSION.getDescription()).matcher(string).matches();
    }*/

    @Override
    public void parse(Component sentenceComposite, String sentense) throws CustomException {
        Component lexemComposite;
        String[] lexemArray = sentense.split(ComponentType.LEXEM.getDescription());
        ExpressionValidator expressionValidator = new ExpressionValidator();
        for (String lexem : lexemArray) {
            if (expressionValidator.isBitExpression(lexem)) {
                Interpreter interpreter = new Interpreter();
                int rezult = interpreter.bitExpressionCalc(lexem);
                lexemComposite = new Composite(ComponentType.LEXEM);
                simbolParse.parse(lexemComposite, String.valueOf(rezult));
                sentenceComposite.addComponent(lexemComposite);
            } else {
                lexemComposite = new Composite(ComponentType.WORD);
                simbolParse.parse(lexemComposite, lexem);
                sentenceComposite.addComponent(lexemComposite);
            }
        }
    }
}