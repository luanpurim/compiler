package view;

import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.List;

public class Shortcut {

    private List<Integer> modifiers;
    private int key;

    public Shortcut(int key) {
        this(Collections.emptyList(), key);
    }

    public Shortcut(List<Integer> modifiers, int key) {
        this.modifiers = modifiers;
        this.key = key;
    }

    public boolean is(KeyEvent e) {
        boolean allModifiersActive = modifiers.stream()
                .allMatch(modifier -> (e.getModifiersEx() & modifier) != 0);
        return (e.getKeyCode() == key) && allModifiersActive;
    }

}
