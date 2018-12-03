package semantic.actions;

import gals.SemanticError;
import gals.Token;
import semantic.Context;
import semantic.MsilCommand;
import semantic.VarType;

public class Action104 implements SemanticActionHandler {

    @Override
    public int id() {
        return 104;
    }

    @Override
    public void handle(Token token, Context context) throws SemanticError {
        for (String identifier : context.getIdentifiersList()) {
            VarType varType = context.getSymbolTable().get(identifier);
            if (varType == null) {
                throw new SemanticError(String.format("Variável '%s' não declarada", identifier));
            }
            switch (varType) {
                case NUMBER:
                    generateReadNumber(context);
                    break;
                case LITERAL:
                    generateReadLiteral(context);
                    break;
                case LOGICAL:
                    generateReadLogical(context);
                    break;
            }
            context.getCode().add(MsilCommand.SAVE_VAR, identifier);
        }
        context.getIdentifiersList().clear();
    }

    private void generateReadNumber(Context context) {
        context.getCode().add(MsilCommand.READ_LINE);
        VarType type = VarType.NUMBER;
        context.getCode().add(MsilCommand.PARSE_STRING, type.msilType(), type.getClassName());
    }

    private void generateReadLiteral(Context context) {

    }

    private void generateReadLogical(Context context) {

    }

}
