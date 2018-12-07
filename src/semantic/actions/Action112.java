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
        String labelExit = context.getLabelManager().pop();
        String labelWhile = context.getLabelManager().pop();
        context.getCode().add(MsilCommand.JUMP, labelWhile);
        context.getCode().add(MsilCommand.ADD_LABEL, labelExit);
    }
}
