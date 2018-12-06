package view;

import java.io.FileWriter;

import javax.swing.JTextPane;
import java.io.File;

import core.AnalyseResult;
import core.Analyser;

public class CompileAction implements Action {

    private JTextPane code;
	private JTextPane messages;
	private JTextPane textPaneStatus;

    public CompileAction(JTextPane code, JTextPane messages, JTextPane textPaneStatus) {
        this.code = code;
        this.messages = messages;
        this.textPaneStatus = textPaneStatus;
    }

    @Override
    public void execute() {
        AnalyseResult result = new Analyser().analyse(code.getText());
        if(result.hasError()) {
        	this.messages.setText(result.getError().getMessage());
        } else {        	
    		this.messages.setText("Programa compilado com sucesso!");
    		File file = Compiler.FILE;
    		if(file == null) {
    			SaveAction save = new SaveAction(code, messages, textPaneStatus);
    			save.execute();
    			file = Compiler.FILE;
    			createFile(result.getCode(), file);
    		} else {
    			createFile(result.getCode(), file);
    		}
            System.out.println(result.getCode());
        }
    }
    
    private void createFile(String code, File file){
    	try {
    		String path = file.getAbsolutePath();
    		String finalPath = "";
    		if(path.indexOf(".") == -1) {
    			finalPath = path + ".il"; 
    		} else {    			
    			finalPath = path.replaceAll("[.][^.]+$", ".il");
    		}
    		FileWriter writer = new FileWriter(finalPath);
    		writer.write(code);
    		writer.close();    		
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
