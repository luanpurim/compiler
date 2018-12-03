package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;

public class Action101 implements SemanticActionHandler{

	@Override
	public int id() {
		return 101;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		// TODO: Implementar porra :), usar  a variavel Variable.TYPE_DECLARATION
	}

}
