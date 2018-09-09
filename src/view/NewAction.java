package view;

import java.util.List;

import javax.swing.JTextPane;

public class NewAction implements Action {

    private List<JTextPane> contents;

    public NewAction(List<JTextPane> contents) {
        this.contents = contents;
    }

    @Override
    public void execute() {
    	Compiler.FILE = null;
    	this.contents.forEach(el -> el.setText(""));
    }

}
