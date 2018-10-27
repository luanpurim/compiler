package core;

import gals.*;
import lexical.LexicalErrorResolver;
import semantic.SemanticErrorResolver;
import syntatic.SyntaticErrorResolver;

import java.util.Optional;

public class Analyser {

    public Optional<AnalyseErrorMessage> analyse(String code) {
        return Optional.ofNullable(analyseCode(code))
                .map(AnalysisErrorResolver::resolve)
                .map(AnalyseErrorMessage::new);
    }

    private AnalysisErrorResolver analyseCode(String code) {
        try {
            doAnalysis(code);
        } catch (LexicalError lexicalError) {
            return new LexicalErrorResolver(code, lexicalError);
        } catch (SemanticError semanticError) {
            new SemanticErrorResolver(code, semanticError);
        } catch (SyntaticError syntaticError) {
            new SyntaticErrorResolver(code, syntaticError);
        }
        return null;
    }

    private void doAnalysis(String code) throws LexicalError, SemanticError, SyntaticError {
        Lexico lexical = new Lexico(code);
        Sintatico syntatic = new Sintatico();
        Semantico semantic = new Semantico();

        try {
            syntatic.parse(lexical, semantic);
        } catch (SyntaticError syntaticError) {
            Optional<LexicalError> lexicalError = new ErrorTokenIdentifier(code, syntaticError.getPosition())
                    .identify()
                    .filter(token -> token.getId() == Constants.t_reservada)
                    .map(t -> new LexicalError("palavra reservada inválida", syntaticError.getPosition()));

            if (lexicalError.isPresent()) {
                throw lexicalError.get();
            }
            throw syntaticError;
        }

    }

}
