package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.VarType;
import semantic.Variable;

public class Action101 implements SemanticActionHandler{

	@Override
	public int id() {
		return 101;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		context.getVariables().set(Variable.VAR_TYPE, VarType.NUMBER);
	}

}
