package semantic;

import core.AnalyseErrorMessage;
import core.AnalysisErrorResolver;
import gals.AnalysisError;

public class SemanticErrorResolver extends AnalysisErrorResolver {

    public SemanticErrorResolver(String code, AnalysisError e) {
        super (code, e);
    }

    @Override
    public AnalyseErrorMessage resolve() {
        return new AnalyseErrorMessage("Erro semântico");
    }

}
