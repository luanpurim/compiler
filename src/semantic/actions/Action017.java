package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action017 implements SemanticActionHandler{

	@Override
	public int id() {
		return 17;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		VarType t1 = context.getTypeStack().removeLast();
		VarType t2 = context.getTypeStack().removeLast();
		
		if(t1 != VarType.LOGICAL || t2 != VarType.LOGICAL) {
			throw new SemanticError("Tipos incompatíveis em operação lógica binária", token);
		}
		
		context.getTypeStack().add(VarType.LOGICAL);
		context.getCode().add(MsilCommand.AND);
	}
	
}
