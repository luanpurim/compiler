package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action106 implements SemanticActionHandler{

	@Override
	public int id() {
		return 106;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		String id = context.getIdentifiersList().poll();
		if(!context.getSymbolTable().containsKey(id)) {
			throw new SemanticError(String.format("Identificador '%s' não declarado", id));
		}
		VarType type = context.getSymbolTable().get(id);
		VarType typeExp = context.getTypeQueue().poll();
		if(type!=typeExp) {
			throw new SemanticError("Tipo incompatível em comando de atribuição");
		}
		context.getCode().add(MsilCommand.SAVE_VAR, id);
	}

}
