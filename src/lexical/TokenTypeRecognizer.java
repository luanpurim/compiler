package lexical;

import gals.Constants;
import gals.ScannerConstants;
import gals.Token;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TokenTypeRecognizer {

    private List<String> keywords = Stream.of(ScannerConstants.SPECIAL_CASES_KEYS).collect(Collectors.toList());
    private final List<Integer> keywordsIds = new LinkedList<>();
    {
        for (int specialCasesValue : ScannerConstants.SPECIAL_CASES_VALUES) {
            keywordsIds.add(specialCasesValue);
        }
    }

    public String getType(Token token) {
        int id = token.getId();
        if (keywords.contains(token.getLexeme()) && keywordsIds.contains(id)) {
            return "palavra reservada";
        } else if (id == Constants.t_identificador) {
            return "identificador";
        } else if (id == Constants.t_constante_numerica) {
            return "constante numérica";
        } else if (id == Constants.t_constante_caractere) {
            return "constante caractere";
        } else if (id == Constants.t_constante_literal) {
            return "constante literal";
        } else if (id >= 23 && id <= 41) {
            return "símbolo especial";
        } else if (id == Constants.t_reservada) {
            return "palavra reservada inválida";
        }
        return "unknown";
    }

}
