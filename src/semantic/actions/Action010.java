package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;
import semantic.Variable;

public class Action010 implements SemanticActionHandler{

	@Override
	public int id() {
		return 10;
	}

	@Override
	public void handle(Token token, Context context) throws SemanticError {
		VarType t1 = context.getTypeQueue().poll();
		VarType t2 = context.getTypeQueue().poll();
		if(t1 != t2) {
			throw new SemanticError("Tipos incompatíveis em operação relacional", token);
		} 
		context.getTypeQueue().add(VarType.LOGICAL);
		switch ((String) context.getVariables().get(Variable.RELATIONAL_OPERATOR)) {
		case ">":
			context.getCode().add(MsilCommand.GREATER_THAN);
			break;
		case "<":
			context.getCode().add(MsilCommand.LESS_THAN);
			break;
		case "=":
			context.getCode().add(MsilCommand.EQUALS);
			break;
		default:
			throw new SemanticError("Operador não encontrado", token);
		}
	}

}
