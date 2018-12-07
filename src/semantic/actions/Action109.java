package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;

public class Action109 implements SemanticActionHandler {

    @Override
    public int id() {
        return 109;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        String falseCodeLabel = context.getLabelManager().pop();
        String trueCodeLabel = context.getLabelManager().pushNew();
        context.getCode().add(MsilCommand.JUMP, trueCodeLabel);
        context.getCode().add(MsilCommand.ADD_LABEL, falseCodeLabel);
    }

}
