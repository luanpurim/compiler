package semantic;

import java.util.LinkedList;

public class LabelManager {

    private LinkedList<String> labelStack = new LinkedList<>();
    private int count = 0;

    public String pushNew() {
        String newLabel = generate();
        labelStack.add(newLabel);
        return newLabel;
    }

    public String pop() {
        return labelStack.removeLast();
    }

    private String generate() {
        return String.format("label_%s", ++count);
    }

}
