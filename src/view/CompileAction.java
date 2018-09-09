package view;

import javax.swing.JTextPane;

public class CompileAction implements Action {

	private JTextPane messages;
	
    public CompileAction(JTextPane messages) {
		this.messages = messages;
	}

	@Override
    public void execute() {
        String text = this.messages.getText();
        if(!text.isEmpty()) {
        	text = text + "\n";
        }
        text = text + "Compilação de programas ainda não foi implementada";
        this.messages.setText(text);
    }

}
