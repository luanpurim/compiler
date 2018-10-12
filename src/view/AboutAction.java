package view;

import javax.swing.JTextPane;

public class AboutAction implements Action {

	private JTextPane messages;
	
    public AboutAction(JTextPane messages) {
		this.messages = messages;
	}

	@Override
    public void execute() {
        String text = this.messages.getText();
        if(!text.isEmpty()) {
        	text = text + "\n";
        }
        text = text + "Membros do grupo: \n";
        text = text + "- Luan Carlos Purim (luancarlospurim@gmail.com) \n";
        text = text + "- Adriner Maranho de Andrade (adriner_andrade@hotmail.com) \n";
    	text = text + "Repositorio GitHub: https://github.com/Feenux/compiler";
        this.messages.setText(text);
    }

}
