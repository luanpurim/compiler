package semantic;

import core.AnalysisErrorResolver;
import gals.AnalysisError;

public class SemanticErrorResolver extends AnalysisErrorResolver {

    public SemanticErrorResolver(String code, AnalysisError e) {
        super (code, e);
    }

    @Override
    public String resolve() {
        return "Erro semântico";
    }

}
