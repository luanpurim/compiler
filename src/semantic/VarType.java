package semantic;

import static java.lang.String.format;

public enum VarType {

    NUMBER("float64", "Double"),
    LITERAL("string", "String"),
    LOGICAL("bool", "Boolean");

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

    public static VarType getByDeclaration(String msilType) {
        for (VarType varType : values()) {
            if (varType.name().equalsIgnoreCase(msilType)) {
                return varType;
            }
        }
        throw new IllegalArgumentException(format("Tipo %s não definido."));
    }

}
