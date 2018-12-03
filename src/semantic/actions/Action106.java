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
		String id = context.getIdentifiersList().get(0);
		if(!context.getSymbolTable().containsKey(id)) {
			throw new SemanticError("Erro 106");
		}
		VarType type = context.getSymbolTable().get(id);
		VarType typeExp = context.getTypeQueue().poll();
		if(type!=typeExp) {
			throw new SemanticError("Erro 106 - 2");
		}
		context.getCode().add(MsilCommand.DIV, id);
	}

}
