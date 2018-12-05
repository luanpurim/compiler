package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.Variable;

public class Action103 implements SemanticActionHandler{

	@Override
	public int id() {
		return 103;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {		
		for(int i = 0; i <= context.getIdentifiersList().size(); i++ ) {
			String id = context.getIdentifiersList().get(i);
			if(context.getSymbolTable().containsKey(id)) {
				throw new SemanticError(String.format("Identificador '%s' já declarado", id));
			}
			context.getSymbolTable().put(token.getLexeme(), context.getVariables().get(Variable.TYPE_DECLARATION));
			context.getCode().add(MsilCommand.LOCALS, context.getVariables().get(Variable.TYPE_DECLARATION), token.getLexeme());
			
		}
		context.getIdentifiersList().clear();
	}
	
}
