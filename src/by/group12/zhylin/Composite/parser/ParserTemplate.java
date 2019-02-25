package by.group12.zhylin.Composite.parser;

import by.group12.zhylin.Composite.composite.Component;
import by.group12.zhylin.Composite.exception.CustomException;

public interface ParserTemplate {
    void parse(Component component, String text) throws CustomException;
}