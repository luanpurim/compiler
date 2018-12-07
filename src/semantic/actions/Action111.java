package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action111 implements SemanticActionHandler {

    @Override
    public int id() {
        return 111;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        VarType type = context.getTypeStack().removeLast();
        if (type != VarType.LOGICAL) {
            throw new SemanticError("Tipo não é um booleano", token);
        }
        String label = context.getLabelManager().pushNew();
        context.getCode().add(MsilCommand.JUMP_TRUE, label);
    }
}
