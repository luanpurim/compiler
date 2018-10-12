package lexical;

import gals.LexicalError;
import gals.Lexico;
import gals.ScannerConstants;
import gals.Token;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LexicalAnalyser {

    private int KEYWORD_ID_START = 7;
    private int KEYWORD_ID_END = 22;

    public LexicalResult analyse(String code) {
        List<String> keywords = Stream.of(ScannerConstants.SPECIAL_CASES_KEYS)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        LexicalResult result = new LexicalResult();
        Lexico lexicalAnalyser = new Lexico(code);
        Token token;
        try {
            while ((token = lexicalAnalyser.nextToken()) != null) {
                if (keywords.contains(token.getLexeme()) && !(token.getId() >= KEYWORD_ID_START && token.getId() <= KEYWORD_ID_END)) {
                    throw new LexicalError("palavra reservada inválida", token.getPosition());
                }
                result.tokenProcessed(token);
            }
        } catch (LexicalError e) {
            result.addError(new LexicalErrorResolver(code, e).resolve());
            return result;
        }
        return result;
    }

}
