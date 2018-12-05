package semantic;

import core.AnalysisErrorResolver;
import gals.AnalysisError;

public class SemanticErrorResolver extends AnalysisErrorResolver {

    private AnalysisError error;
    private String code;

    public SemanticErrorResolver(String code, AnalysisError e) {
        super (code, e);
        this.code = code;
        this.error = e;
    }

    @Override
    public String resolve() {
        return String.format("Erro na linha %d - %s", getLine(),  error.getLocalizedMessage());
    }

}
