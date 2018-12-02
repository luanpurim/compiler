package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;

public class Action102 implements SemanticActionHandler{

	@Override
	public int id() {
		// TODO Auto-generated method stub
		return 102;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		context.getIdentifiersList().add(token.getLexeme());
	}

}
