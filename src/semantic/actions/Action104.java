package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action104 implements SemanticActionHandler {

    @Override
    public int id() {
        return 104;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        for (String identifier : context.getIdentifiersList()) {
            VarType varType = context.getSymbolTable().get(identifier);
            if (varType == null) {
                throw new SemanticError(String.format("Identificador '%s' não declarado", identifier));
            }
            context.getCode().add(MsilCommand.READ_LINE);
            if (needConvertion(varType)) {
                context.getCode().add(MsilCommand.PARSE_STRING, varType.msilType(), varType.getClassName());
            }
            context.getCode().add(MsilCommand.SAVE_VAR, identifier);
        }
        context.getIdentifiersList().clear();
    }

    private boolean needConvertion(VarType varType) {
        return varType == VarType.NUMBER || varType == VarType.LOGICAL;
    }

}
