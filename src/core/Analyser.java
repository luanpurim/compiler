package core;

import gals.*;
import lexical.LexicalErrorResolver;
import semantic.SemanticErrorResolver;
import syntatic.SyntaticErrorResolver;

import java.util.Optional;

public class Analyser {

    public AnalyseResult analyse(String code) {
        try {
            return new AnalyseResult(doAnalysis(code.replaceAll("\\r", "")));
        } catch (LexicalError lexicalError) {
            return new AnalyseResult(new LexicalErrorResolver(code, lexicalError).resolve());
        } catch (SyntaticError syntaticError) {
            return new AnalyseResult(new SyntaticErrorResolver(code, syntaticError).resolve());
        } catch (SemanticError semanticError) {
            return new AnalyseResult(new SemanticErrorResolver(code, semanticError).resolve());
        }
    }

    private String doAnalysis(String code) throws LexicalError, SemanticError, SyntaticError {
        Lexico lexical = new Lexico(code);
        Sintatico syntatic = new Sintatico();
        Semantico semantic = new Semantico();
        try {
            syntatic.parse(lexical, semantic);
            return semantic.getContext().getCode().get();
        } catch (SyntaticError syntaticError) {
            if (syntaticError.getToken().getId() == Constants.t_reservada) {
                throw new LexicalError("palavra reservada inválida", syntaticError.getPosition());
            }
            throw syntaticError;
        }

    }

}
