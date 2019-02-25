package by.group12.zhylin.task2.parser;

import by.group12.zhylin.task2.composite.Component;
import by.group12.zhylin.task2.exception.CustomException;

public interface ParserTemplate {
    void parse(Component component, String text) throws CustomException;
}