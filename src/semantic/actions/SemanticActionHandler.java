package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;

public interface SemanticActionHandler {

    int id();

    void handle(Token token, Context context) throws SemanticError;

}
