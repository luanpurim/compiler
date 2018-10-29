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
        } catch (SyntaticError syntaticError) {
            return new SyntaticErrorResolver(code, syntaticError);
        } catch (SemanticError semanticError) {
            return new SemanticErrorResolver(code, semanticError);
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
            if (syntaticError.getToken().getId() == Constants.t_reservada) {
                throw new LexicalError("palavra reservada inválida", syntaticError.getPosition());
            }
            throw syntaticError;
        }

    }

}
