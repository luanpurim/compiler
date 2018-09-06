package view;

import javax.swing.*;

public class CutAction implements Action {

    private JTextPane content;

    public CutAction(JTextPane content) {
        this.content = content;
    }

    @Override
    public void execute() {
        new CopyAction(content).execute();
        content.replaceSelection("");
    }

}
