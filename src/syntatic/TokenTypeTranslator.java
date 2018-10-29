package syntatic;

import gals.Constants;
import gals.Token;

public class TokenTypeTranslator {

    public String translate(Token token) {
        switch (token.getId()) {
            case Constants.DOLLAR:
                return "fim de programa";
            case Constants.t_constante_caractere:
                return "constante caractere";
            case Constants.t_constante_numerica:
                return "constante numerica";
            case Constants.t_constante_literal:
                return "constante literal";
        }
        return token.getLexeme();
    }

}
