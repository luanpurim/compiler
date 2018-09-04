package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TextShortcutBlocker {

    private JTextPane textPane;

    public TextShortcutBlocker(JTextPane textPane) {
        this.textPane = textPane;
    }

    public void block(ShortcutBlock... blockers) {
        for (ShortcutBlock block : blockers) {
            textPane.getInputMap().put(KeyStroke.getKeyStroke(block.getShortcut()), block.getBlockName());
            textPane.getActionMap().put(block.getBlockName(), new AbstractAction(){
                public void actionPerformed(ActionEvent e) {
                }
            });
        }
    }

}
