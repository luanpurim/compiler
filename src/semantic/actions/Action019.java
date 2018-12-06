package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action019 implements SemanticActionHandler{

	@Override
	public int id() {
		return 19;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		context.getTypeQueue().add(VarType.LITERAL);
		String lexeme = token.getLexeme()
							.replace("\\s", " ")
							.replaceAll("'", "\"");
        context.getCode().add(MsilCommand.PUSH_LITERAL, lexeme);
	}

}
