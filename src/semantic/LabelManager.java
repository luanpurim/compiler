package semantic;

import java.util.LinkedList;
import java.util.Queue;

public class LabelManager {

    private Queue<String> labelQueue = new LinkedList<>();
    private int count = 0;

    public String pushNew() {
        String newLabel = generate();
        labelQueue.add(newLabel);
        return newLabel;
    }

    public String poll() {
        return labelQueue.poll();
    }

    private String generate() {
        return String.format("label_%s", ++count);
    }

}
