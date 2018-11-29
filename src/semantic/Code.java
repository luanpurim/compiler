package semantic;

public class Code {

    private StringBuilder content = new StringBuilder();

    public void add(MsilCommand command, Object... params) {
        this.content.append(command.get(params)).append("\n");
    }

    public String get() {
        return content.toString();
    }

}
