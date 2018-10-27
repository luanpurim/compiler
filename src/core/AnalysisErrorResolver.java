package core;

import gals.AnalysisError;

public abstract class AnalysisErrorResolver {

    private final int line;

    protected AnalysisErrorResolver(String code, AnalysisError e) {
        line = countLines(code, e);
    }

    private int countLines(String code, AnalysisError error) {
        int line = 1;
        char[] chars = code.toCharArray();
        int position = error.getPosition();
        if (position > chars.length) {
            throw new RuntimeException("A posição está maior do que a quantidade de characteres");
        }
        for (int i = 0; i < position; i++) {
            if (CharacterUtils.isLineBreak(chars[i])) {
                line++;
            }
        }
        return line;
    }

    protected int getLine() {
        return line;
    }

    public abstract String resolve();

}
