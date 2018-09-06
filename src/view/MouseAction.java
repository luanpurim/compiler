package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAction extends MouseAdapter {

    private Action action;

    public MouseAction(Action action) {
        this.action = action;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        action.execute();
    }
}
