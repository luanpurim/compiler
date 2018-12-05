package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action008 implements SemanticActionHandler {

    @Override
    public int id() {
        return 8;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        VarType type = context.getTypeQueue().poll();
        if (type != VarType.NUMBER) {
            throw new SemanticError("Tipo incompatível em operação aritmética unária");
        }
        context.getTypeQueue().add(type);
        context.getCode().add(MsilCommand.PUSH_INTEGER, -1);
        context.getCode().add(MsilCommand.CONVERT_TO_NUMBER);
        context.getCode().add(MsilCommand.MUL);
    }

}
