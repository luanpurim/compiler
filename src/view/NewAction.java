package view;

import javax.swing.*;

public class NewAction implements Action {

    private JTextPane content;

    public NewAction(JTextPane content) {
        this.content = content;
    }

    @Override
    public void execute() {
        content.setText("");
    }

}
