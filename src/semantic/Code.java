package semantic;

public class Code {

    private StringBuilder content = new StringBuilder();

    public void add(MsilCommand command, Object... params) {
        this.content.append(command.get(params));
        if (command != MsilCommand.PROGRAM_TAIL) {
            this.content.append("\n");
        }
    }

    public String get() {
        return content.toString();
    }

}
