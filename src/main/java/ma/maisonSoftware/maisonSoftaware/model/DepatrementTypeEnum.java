package ma.maisonSoftware.maisonSoftaware.model;

public enum DepatrementTypeEnum {
    Juridique("Juridique"),
    CAC("CAC"),
    Conseil("Conseil"),
    Rh("Rh"),
    Expertise("Expertise");


    private final String value;
    private DepatrementTypeEnum(String val) {
        this.value = val;
    }
    public String value() {
        return this.value;
    }
}
