package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.Variable;

public class Action103 implements SemanticActionHandler{

	@Override
	public int id() {
		// TODO Auto-generated method stub
		return 103;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		context.getIdentifiersList().forEach(id -> {
			if(context.getSymbolTable().containsKey(id)) {
				throw new SemanticError("Simbolo já existe na tabela de simbolos");
			}
			context.getSymbolTable().put(token.getLexeme(), context.getVariables().get(Variable.TYPE_DECLARATION));
			String code = token.getLexeme() + context.getVariables().get(Variable.TYPE_DECLARATION);
			context.getCode().add(MsilCommand.LOCALS, code);
		});
		context.getIdentifiersList().clear();
	}
	
}
