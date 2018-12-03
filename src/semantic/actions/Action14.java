package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action14 implements SemanticActionHandler{

	@Override
	public int id() {
		return 14;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		VarType type = context.getTypeQueue().poll();
		context.getCode().add(MsilCommand.WRITE_LINE, type.msilType());
	}

}
