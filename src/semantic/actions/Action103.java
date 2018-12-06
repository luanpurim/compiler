package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;
import semantic.Variable;

public class Action103 implements SemanticActionHandler{

	@Override
	public int id() {
		return 103;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {		
		for (int i = 0; i < context.getIdentifiersList().size(); i++ ) {
			String id = context.getIdentifiersList().get(i);
			if (context.getSymbolTable().containsKey(id)) {
				throw new SemanticError(String.format("Identificador '%s' já declarado", id));
			}
			context.getSymbolTable().put(id, context.getVariables().get(Variable.VAR_TYPE));
			VarType type = context.getVariables().get(Variable.VAR_TYPE);
			context.getCode().add(MsilCommand.LOCALS, type.msilType(), id);
			
		}
		context.getIdentifiersList().clear();
	}
	
}
