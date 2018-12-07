package semantic;

import java.util.LinkedList;
import java.util.Queue;

public class LabelManager {

    private LinkedList<String> labelQueue = new LinkedList<>();
    private int count = 0;

    public String pushNew() {
        String newLabel = generate();
        labelQueue.add(newLabel);
        return newLabel;
    }

    public String pop() {
        return labelQueue.removeLast();
    }

    private String generate() {
        return String.format("label_%s", ++count);
    }

}
