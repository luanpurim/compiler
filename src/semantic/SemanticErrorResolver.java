package semantic;

import core.AnalyseErrorMessage;
import core.AnalysisErrorResolver;
import gals.AnalysisError;

public class SemanticErrorResolver extends AnalysisErrorResolver {

    private AnalysisError error;

    public SemanticErrorResolver(String code, AnalysisError e) {
        super (code, e);
        this.error = e;
    }

    @Override
    public AnalyseErrorMessage resolve() {
        return new AnalyseErrorMessage(String.format("Erro na linha %d - %s", getLine(),  error.getLocalizedMessage()));
    }

}
