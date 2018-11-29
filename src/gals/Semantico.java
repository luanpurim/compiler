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
        semanticActionHandler.ifPresent(actionHandler -> actionHandler.handle(token, context));
        if (!semanticActionHandler.isPresent()) {
            System.out.println(String.format("Ação %s não implementada. Token: %s", action, token));
        }
    }	
}
