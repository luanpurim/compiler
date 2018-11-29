package gals;

import semantic.Context;
import semantic.actions.SemanticActions;

public class Semantico implements Constants
{

    private Context context = new Context();

    public void executeAction(int action, Token token)	throws SemanticError
    {
        SemanticActions.get(action).handle(token, context);
    }	
}
