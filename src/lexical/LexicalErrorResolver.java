package lexical;

import core.AnalyseErrorMessage;
import core.AnalysisErrorResolver;
import core.WordExtractor;
import gals.LexicalError;

import java.util.Arrays;
import java.util.List;

public final class LexicalErrorResolver extends AnalysisErrorResolver {

    private static final List<String> DETAILED_MESSAGES = Arrays.asList(
            "símbolo inválido",
            "palavra reservada inválida"
    );

    private String code;
    private LexicalError error;

    public LexicalErrorResolver(String code, LexicalError error) {
        super(code, error);
        this.code = code;
        this.error = error;
    }

    @Override
    public AnalyseErrorMessage resolve() {
        String message = error.getLocalizedMessage();
        if (DETAILED_MESSAGES.contains(message)) {
            String unknownToken = new WordExtractor().extract(code, error.getPosition());
            return new AnalyseErrorMessage(String.format("Erro na linha %d - %s %s", getLine(), unknownToken, message));
        }
        return new AnalyseErrorMessage(String.format("Erro na linha %d - %s", getLine(),  message));
    }

}
