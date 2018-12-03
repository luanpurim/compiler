package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;

public class Action15 implements SemanticActionHandler{

	@Override
	public int id() {
		return 15;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		context.getCode().add(MsilCommand.PROGRAM_HEAD);
	}

}
