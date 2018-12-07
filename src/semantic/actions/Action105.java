package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action105 implements SemanticActionHandler{

	@Override
	public int id() {
		return 105;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		String id = token.getLexeme();
		if(!context.getSymbolTable().containsKey(id)) {
			throw new SemanticError(String.format("Identificador '%s' não declarado", id), token);
		}
		VarType tipo = context.getSymbolTable().get(id);
		context.getTypeStack().add(tipo);
		context.getCode().add(MsilCommand.READ_VAR, id);
	}
	
}
