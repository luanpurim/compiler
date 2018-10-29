package syntatic;

import core.AnalysisErrorResolver;
import gals.SyntaticError;

public final class SyntaticErrorResolver extends AnalysisErrorResolver {

    private SyntaticError error;

    public SyntaticErrorResolver(String code, SyntaticError e) {
        super (code, e);
        this.error = e;
    }

    @Override
    public String resolve() {
        String tokenType = new TokenTypeTranslator().translate(error.getToken());
        return String.format("Erro na linha %d - encontrado %s %s", getLine(), tokenType, error.getMessage());
    }

}
