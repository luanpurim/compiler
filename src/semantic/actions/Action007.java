package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.VarType;

public class Action007 implements SemanticActionHandler {

    @Override
    public int id() {
        return 7;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        VarType type = context.getTypeStack().removeLast();
        if (type != VarType.NUMBER) {
            throw new SemanticError("Tipo incompatível em operação aritmética unária", token);
        }
        context.getTypeStack().add(type);
    }

}
