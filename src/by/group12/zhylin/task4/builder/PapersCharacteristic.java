package by.group12.zhylin.task4.builder;

public enum PapersCharacteristic {
    PAPERS("papers"),
    PAPER("paper"),
    NEWSPAPER("newspaper"),
    MAGAZINE("magazine"),
    BOOKLET("booklet"),
    NAME("name"),
    ID("id"),
    DATE("date"),
    INDEX("index"),
    MONTHLY("Monthly"),
    SPECIFICATIONS("specications"),
    COLOR("color"),
    COATED("coated"),
    PAGES("pages"),
    EMPTY_TAG("");

    private String value;

    PapersCharacteristic(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}