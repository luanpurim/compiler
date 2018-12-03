package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.VarType;

public class Action107 implements SemanticActionHandler {

    @Override
    public int id() {
        return 107;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        VarType type = context.getTypeQueue().poll();
        if (type != VarType.LOGICAL) {
            throw new SemanticError("Tipo não é um booleano");
        }
        context.getTypeQueue().add(VarType.LOGICAL);
        context.getLabelManager().pushNew()
        context.getCode().add();
    }
}
