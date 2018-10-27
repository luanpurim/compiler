package view;

import core.Analyser;

import java.util.stream.Collectors;

import javax.swing.JTextPane;

public class CompileAction implements Action {

    private JTextPane code;
	private JTextPane messages;

    public CompileAction(JTextPane code, JTextPane messages) {
        this.code = code;
        this.messages = messages;
    }

    @Override
    public void execute() {
        LexicalResult result = new Analyser().analyse(code.getText().replaceAll("\\r", ""));
        if(result.hasErrors()) {
        	String text = result.getErrors().stream().map(error -> error + "\n").collect(Collectors.joining(""));
        	this.messages.setText(text);
        } else {        	
    		String text = String.format("%1$-"+7+"s", "linha") +  String.format("%1$-"+31+"s", "classe") + String.format("%1$-"+6+"s", "lexema") + " \n"
    				+ result.geTokens().stream().map(token -> 
    					String.format("%1$-"+8+"s", token.getLine()) + " " + 
    					String.format("%1$-"+31+"s", token.getType()) + " " + 
    					String.format("%1$"+6+"s", token.getLexema()) + " \n")
    				.collect(Collectors.joining(""));
    		this.messages.setText(text);
        }
    }

}
