package gals;

public class SemanticError extends AnalysisError
{

    public SemanticError(String msg, Token token)
    {
        super(msg, token.getPosition());
    }

}
