package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;

public class Action110 implements SemanticActionHandler{
    @Override
    public int id() {
        return 110;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        String label = context.getLabelManager().pushNew();
        context.getCode().add(MsilCommand.ADD_LABEL, label);
    }
}
