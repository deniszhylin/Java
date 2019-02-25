package by.group12.zhylin.Composite.composite;

public enum ComponentType {
    TEXT(""),
    PARAGRAPH("(?sm)^[^\\s]+.*?\\.\\s*$"),
    SENTENCE("(?:[^!?.]|\\.(?=\\d))+[!?.]"),
    LEXEM("\\s"),
    EXPRESSION("[\\d|&<{2}>2()~^]+"),
    WORD("([A-Za-z]*)\\b"),
    SYMBOL("\\w");

    private String description;

    ComponentType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}