package semantic;

public class LabelManager {

    private int count = 0;

    public String generate() {
        return String.format("label_%s", ++count);
    }

}
