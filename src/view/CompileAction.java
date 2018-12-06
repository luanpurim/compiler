package view;

import javax.swing.JTextPane;

import core.AnalyseResult;
import core.Analyser;

public class CompileAction implements Action {

    private JTextPane code;
	private JTextPane messages;

    public CompileAction(JTextPane code, JTextPane messages) {
        this.code = code;
        this.messages = messages;
    }

    @Override
    public void execute() {
        AnalyseResult result = new Analyser().analyse(code.getText());
        if(result.hasError()) {
        	this.messages.setText(result.getError().getMessage());
        } else {        	
    		this.messages.setText("Programa compilado com sucesso!");
            System.out.println(result.getCode());
        }
    }

}
