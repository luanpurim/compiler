package lexical;

import gals.Token;

import java.util.LinkedList;
import java.util.List;

public class LexicalResult {

    private StringBuilder log = new StringBuilder();
    private List<String> errors = new LinkedList<>();

    public void tokenProcessed(Token token) {
        log.append(token.getLexeme()).append("\n");
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

    public String getLog() {
        return log.toString();
    }

}
