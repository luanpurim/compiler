package lexical;

public class ProcessedToken {

    private String lexema;
    private int line;
    private String type;

    public ProcessedToken(String lexema, int line, String type) {
        this.lexema = lexema;
        this.line = line;
        this.type = type;
    }

    public String getLexema() {
        return lexema;
    }

    public int getLine() {
        return line;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ProcessedToken{" +
                "lexema='" + lexema + '\'' +
                ", line=" + line +
                ", type='" + type + '\'' +
                '}';
    }

}
