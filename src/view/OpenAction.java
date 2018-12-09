package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenAction implements Action {

	private File file;
	private JTextPane editor;
	private JTextPane messages;
	private JTextPane status;
 
	public OpenAction(JTextPane editor, JTextPane messages, JTextPane status) {
		this.editor = editor;
		this.messages = messages;
		this.status = status;
	}

	@Override
	public void execute() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de texto", "txt"));
		fileChooser.setMultiSelectionEnabled(false);
		int option = fileChooser.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			try {
				this.file = fileChooser.getSelectedFile();
				FileReader fileReader = new FileReader(this.file);
				this.editor.read(fileReader, null);
				this.messages.setText("");
				this.status.setText(this.file.getAbsolutePath());
				Compiler.FILE = this.file;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
