package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class DivAction implements SemanticActionHandler {

    @Override
    public int id() {
        return 4;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        VarType type1 = context.getTypeQueue().poll();
        VarType type2 = context.getTypeQueue().poll();

        if (type1 != VarType.NUMBER || type2 != VarType.NUMBER) {
            throw new SemanticError("Mensagem de erro de multiplicação");
        }
        context.getTypeQueue().add(VarType.NUMBER);
        context.getCode().add(MsilCommand.DIV);
    }

}
