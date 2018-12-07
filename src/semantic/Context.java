package semantic;

import java.util.*;

public class Context {

    private Map<String, VarType> symbolTable = new HashMap<>();
    private LinkedList<VarType> typeStack = new LinkedList<>();
    private LinkedList<String> identifiersList = new LinkedList<>();
    private Code code = new Code();
    private Variables variables = new Variables();
    private LabelManager labelManager = new LabelManager();

    public Map<String, VarType> getSymbolTable() {
        return symbolTable;
    }

    public LinkedList<VarType> getTypeStack() {
        return typeStack;
    }

    public Code getCode() {
        return code;
    }

    public Variables getVariables() {
        return variables;
    }

    public LinkedList<String> getIdentifiersList() {
        return identifiersList;
    }

    public LabelManager getLabelManager() {
        return labelManager;
    }

}
