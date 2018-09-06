package view;

import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CopyAction implements Action {

    private JTextPane content;

    public CopyAction(JTextPane content) {
        this.content = content;
    }

    @Override
    public void execute() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection selection = new StringSelection(content.getSelectedText());
        clipboard.setContents(selection, selection);
    }

}
