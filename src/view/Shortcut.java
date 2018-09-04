package view;

import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Set;

public class Shortcut {

    private Set<Integer> modifiers;
    private int key;

    public Shortcut(int key) {
        this(Collections.emptySet(), key);
    }

    public Shortcut(Set<Integer> modifiers, int key) {
        this.modifiers = modifiers;
        this.key = key;
    }

    public boolean is(KeyEvent e) {
        boolean allModifiersActive = modifiers.stream()
                .allMatch(modifier -> (e.getModifiersEx() & modifier) != 0);
        return (e.getKeyCode() == key) && allModifiersActive;
    }

}
