package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;

public class Action108 implements SemanticActionHandler {

    @Override
    public int id() {
        return 108;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        String label = context.getLabelManager().poll();
        context.getCode().add(MsilCommand.ADD_LABEL, label);
    }

}
