package semantic;

public enum VarType {

    NUMBER("float64", "Double"),
    LITERAL("string", ""),
    LOGICAL("bool", "");

    private String msilType;
    private String className;

    VarType(String msilType, String className) {
        this.msilType = msilType;
        this.className = className;
    }

    public String msilType() {
        return msilType;
    }

    public String getClassName() {
        return className;
    }

}
