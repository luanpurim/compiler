package gals;

import semantic.Context;
import semantic.actions.SemanticActionHandler;
import semantic.actions.SemanticActions;

import java.util.Optional;

public class Semantico implements Constants
{

    private Context context = new Context();

    public void executeAction(int action, Token token) throws SemanticError
    {
        Optional<SemanticActionHandler> semanticActionHandler = SemanticActions.get(action);
        if (semanticActionHandler.isPresent()) {
            semanticActionHandler.get().handle(token, context);
        } else {
            System.out.println(String.format("Ação %s não implementada. Token: %s", action, token));
        }
    }

    public Context getContext() {
        return context;
    }

}
