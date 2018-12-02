package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.Variable;

public class Action9 implements SemanticActionHandler{

	@Override
	public int id() {
		return 9;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		context.getVariables().set(Variable.RELATIONAL_OPERATOR, token.getLexeme());
	}

}
