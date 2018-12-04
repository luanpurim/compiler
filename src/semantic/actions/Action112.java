package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;

public class Action112 implements SemanticActionHandler {

    @Override
    public int id() {
        return 112;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        String label1 = context.getLabelManager().poll();
        String label2 = context.getLabelManager().poll();
        context.getCode().add(MsilCommand.JUMP, label1);
        context.getCode().add(MsilCommand.ADD_LABEL, label2);
    }
}
