package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action020 implements SemanticActionHandler{

	@Override
	public int id() {
		return 20;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		context.getTypeQueue().add(VarType.LITERAL);
        context.getCode().add(MsilCommand.PUSH_LITERAL, token.getLexeme());
	}

}
