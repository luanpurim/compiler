package syntatic;

import core.AnalysisErrorResolver;
import gals.SyntaticError;

public final class SyntaticErrorResolver extends AnalysisErrorResolver {

    private String code;
    private SyntaticError error;

    public SyntaticErrorResolver(String code, SyntaticError e) {
        super (code, e);
        this.code = code;
        this.error = e;
    }

    @Override
    public String resolve() {
        return "Erro sintático";
    }

}
