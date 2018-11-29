package semantic;

public enum VarType {

    NUMBER("float64"),
    LITERAL("bool"),
    LOGICAL("string");

    VarType(String msilType) {
        this.msilType = msilType;
    }

    private String msilType;

    private String msilType() {
        return msilType;
    }

}
