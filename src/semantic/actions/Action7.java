package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.VarType;

public class Action7 implements SemanticActionHandler {

    @Override
    public int id() {
        return 7;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        VarType type = context.getTypeQueue().poll();
        if (type != VarType.NUMBER) {
            throw new SemanticError("Valor não é um número");
        }
        context.getTypeQueue().add(type);
    }

}
