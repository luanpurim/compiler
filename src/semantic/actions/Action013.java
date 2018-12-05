package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action013 implements SemanticActionHandler {

    @Override
    public int id() {
        return 13;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        VarType type = context.getTypeQueue().poll();
        if (type != VarType.LOGICAL) {
            throw new SemanticError("Tipo incompatível em operação lógica unária");
        }
        context.getTypeQueue().add(VarType.LOGICAL);
        context.getCode().add(MsilCommand.PUSH_LOGICAL, 1);
        context.getCode().add(MsilCommand.XOR);
    }

}
