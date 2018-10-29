package view;

import java.util.Optional;

import javax.swing.JTextPane;

import core.AnalyseErrorMessage;
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
        Optional<AnalyseErrorMessage> result = new Analyser().analyse(code.getText().replaceAll("\\r", ""));
        if(result.isPresent()) {
        	this.messages.setText(result.get().getMessage());
        } else {        	
    		this.messages.setText("Programa compilado com sucesso!");
        }
    }

}
