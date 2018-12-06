package core;

public class AnalyseResult {

    private boolean hasError;
    private AnalyseErrorMessage errorResolver;
    private String code;

    public AnalyseResult(AnalyseErrorMessage errorResolver) {
        this.hasError = true;
        this.errorResolver = errorResolver;
    }

    public AnalyseResult(String code) {
        this.code = code;
    }

    public boolean hasError() {
        return hasError;
    }

    public AnalyseErrorMessage getError() {
        return errorResolver;
    }

    public String getCode() {
        return code;
    }

}
