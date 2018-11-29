package semantic;

public class Code {

    private StringBuilder content = new StringBuilder();

    public void add(String code) {
        this.content.append(code);
    }

    public String get() {
        return content.toString();
    }

}
