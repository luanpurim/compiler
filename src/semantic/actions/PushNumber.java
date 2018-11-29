package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class PushNumber implements SemanticActionHandler {

    @Override
    public int id() {
        return 6;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        context.getTypeQueue().add(VarType.NUMBER);
        context.getCode().add(MsilCommand.PUSH_NUMBER, token.getLexeme());
    }

}
