package core;

import gals.LexicalError;
import gals.Lexico;
import gals.Token;

import java.util.Optional;

public class ErrorTokenIdentifier {

    private final String word;

    public ErrorTokenIdentifier(String code, int position) {
        this.word = new WordExtractor().extract(code, position);
    }

    public Optional<Token> identify() {
        try {
            return Optional.of(new Lexico(word).nextToken());
        } catch (LexicalError lexicalError) {
            return Optional.empty();
        }
    }

}
