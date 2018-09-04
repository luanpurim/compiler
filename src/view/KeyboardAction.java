package view;

import java.awt.*;
import java.awt.event.KeyEvent;

public final class KeyboardAction implements KeyEventDispatcher {

    private Shortcut shortcut;
    private Action action;

    public KeyboardAction(Shortcut shortcut, Action action) {
        this.shortcut = shortcut;
        this.action = action;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_RELEASED) {
            if (shortcut.is(e)) {
                action.execute();
                return true;
            }
            return false;
        }
        return false;
    }
}
