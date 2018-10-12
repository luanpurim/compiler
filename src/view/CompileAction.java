package view;

import lexical.LexicalAnalyser;
import lexical.LexicalResult;

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
        LexicalResult result = new LexicalAnalyser().analyse(code.getText().replaceAll("\\r", ""));
        System.out.println(result.hasErrors());
        System.out.println(result.getErrors());
        result.geTokens().forEach(System.out::println);
    }

}