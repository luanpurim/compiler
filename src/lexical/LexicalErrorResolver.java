package lexical;

import gals.LexicalError;

public class LexicalErrorResolver {

    private String code;
    private LexicalError error;

    public LexicalErrorResolver(String code, LexicalError error) {
        this.code = code;
        this.error = error;
    }

    public String resolve() {
        int line = 1;
        char[] chars = code.toCharArray();
        int position = error.getPosition();
        if (position > chars.length) {
            throw new RuntimeException("A posição está maior do que a quantidade de characteres");
        }
        for (int i = 0; i < position; i++) {
            if (isLineBreak(chars[i])) {
                line++;
            }
        }
        StringBuilder uncognizedChar = new StringBuilder();
        for (int i = position; i < chars.length; ++i) {
            char character = chars[i];
            if (!isBreakCharacter(character)) {
                uncognizedChar.append(character);
            }
        }
        return String.format("Erro na linha %d - %s %s", line, uncognizedChar.toString(), error.getLocalizedMessage());
    }

    private boolean isLineBreak(char character) {
        return character == '\n';
    }

    private boolean isBreakCharacter(char character) {
        return character == '\n' || character == '\t' || character == ' ';
    }

}
