package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class PushTrue implements SemanticActionHandler {

    @Override
    public int id() {
        return 11;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        context.getTypeQueue().add(VarType.LOGICAL);
        context.getCode().add(MsilCommand.PUSH_LOGICAL, 1);
    }

}
