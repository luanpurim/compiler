package lexical;

import gals.Token;

import java.util.LinkedList;
import java.util.List;

public class LexicalResult {

    private List<ProcessedToken> tokens = new LinkedList<>();
    private List<String> errors = new LinkedList<>();
    private TokenTypeRecognizer typeRecognizer = new TokenTypeRecognizer();

    public void tokenProcessed(Token token, int line) {
        tokens.add(new ProcessedToken(token.getLexeme(), line, typeRecognizer.getType(token)));
    }

    public void addError(String error) {
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<ProcessedToken> geTokens() {
        return tokens;
    }

}
