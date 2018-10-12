package lexical;

import gals.LexicalError;
import gals.Lexico;
import gals.ScannerConstants;
import gals.Token;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LexicalAnalyser {

    private final List<Integer> keywordsIds = new LinkedList<>();
    {
        for (int specialCasesValue : ScannerConstants.SPECIAL_CASES_VALUES) {
            keywordsIds.add(specialCasesValue);
        }
    }

    public LexicalResult analyse(String code) {
        List<String> keywords = Stream.of(ScannerConstants.SPECIAL_CASES_KEYS)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        int initialPosition = 0;
        int line = 1;
        LexicalResult result = new LexicalResult();
        Lexico lexicalAnalyser = new Lexico(code);
        Token token;
        try {
            while ((token = lexicalAnalyser.nextToken()) != null) {
                if (keywords.contains(token.getLexeme()) && !keywordsIds.contains(token.getId())) {
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
