package lexical;

import gals.Constants;
import gals.LexicalError;
import gals.Lexico;
import gals.Token;

public class LexicalAnalyser {

    public LexicalResult analyse(String code) {
        int initialPosition = 0;
        int line = 1;
        LexicalResult result = new LexicalResult();
        Lexico lexicalAnalyser = new Lexico(code);
        Token token;
        try {
            while ((token = lexicalAnalyser.nextToken()) != null) {
                if (token.getId() == Constants.t_reservada) {
                    throw new LexicalError("palavra reservada inválida", token.getPosition());
                }
                line += countLines(code.substring(initialPosition, token.getPosition()));

                initialPosition = token.getPosition();
                result.tokenProcessed(token, line);
            }
        } catch (LexicalError e) {
            result.addError(new LexicalErrorResolver(code, e).resolve());
            return result;
        }
        return result;
    }

    private int countLines(String segment) {
        int total = 0;
        for (char c : segment.toCharArray()) {
            if (c == '\n') {
                total++;
            }
        }
        return total;
    }

}
