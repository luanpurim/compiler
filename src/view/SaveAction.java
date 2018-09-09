package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveAction implements Action {
	
	private JTextPane textPane;
	private JTextPane messages;
	private JTextPane status;

	public SaveAction(JTextPane textPane, JTextPane messages, JTextPane status) {
		this.textPane = textPane;
		this.messages = messages;
		this.status = status;
	}

	@Override
    public void execute() {
		File file = Compiler.FILE;
		String text = textPane.getText();
		if(file == null) {
			System.out.println("Arquivo  novo");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de texto", "txt"));
			fileChooser.setMultiSelectionEnabled(false);
			int option = fileChooser.showSaveDialog(null);
			if (option == JFileChooser.APPROVE_OPTION) {				
				try {
					File newFile = fileChooser.getSelectedFile();
					String filePath = newFile.getAbsolutePath() + (newFile.exists() ? "" : ".txt");
					FileWriter writer = new FileWriter(filePath);
					writer.write(text);
					writer.close();
					this.messages.setText("");
					this.status.setText(filePath);
					Compiler.FILE = newFile;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		} else {
			try {
				FileWriter writer = new FileWriter(file.getAbsolutePath());
				writer.write(text);
				writer.close();
				this.messages.setText("");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }

}
