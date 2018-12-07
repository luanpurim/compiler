package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action002 implements SemanticActionHandler {

    @Override
    public int id() {
        return 2;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        VarType type1 = context.getTypeStack().removeLast();
        VarType type2 = context.getTypeStack().removeLast();

        if (type1 != VarType.NUMBER || type2 != VarType.NUMBER) {
            throw new SemanticError("Tipos incompatíveis em operação aritmética binária", token);
        }
        context.getTypeStack().add(VarType.NUMBER);
        context.getCode().add(MsilCommand.SUB);
    }
}
