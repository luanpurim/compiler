package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import utils.TextLineNumber;

import java.awt.Color;

public class Compiler {

    private JFrame frame;
    public static File FILE;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Compiler window = new Compiler();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Compiler() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBackground(UIManager.getColor("Panel.background"));
        frame.getContentPane().setBackground(UIManager.getColor("OptionPane.background"));
        frame.setBounds(100, 100, 945, 744);
        frame.setMinimumSize(new Dimension(930, 670));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new MigLayout("gap rel 5", "[145px][grow]", "[480px:n,grow][105px:105px:105px][30px:30px:30px]"));

        JPanel toolBar = new JPanel();
        toolBar.setMaximumSize(new Dimension(160, Integer.MAX_VALUE));
        frame.getContentPane().add(toolBar, "cell 0 0 1 2,grow");
        GridBagLayout gbl_toolBar = new GridBagLayout();
        gbl_toolBar.columnWidths = new int[] {150, 0};
        gbl_toolBar.rowHeights = new int[]{59, 59, 59, 59, 59, 59, 59, 59, 0};
        gbl_toolBar.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_toolBar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        toolBar.setLayout(gbl_toolBar);

        JButton btnNew = new JButton("new [ctrl + n]");        
        btnNew.setIcon(new ImageIcon(Compiler.class.getResource("/icons/new-icon.png")));
        GridBagConstraints gbc_btnNew = new GridBagConstraints();
        gbc_btnNew.fill = GridBagConstraints.BOTH;
        gbc_btnNew.insets = new Insets(0, 0, 5, 0);
        gbc_btnNew.gridx = 0;
        gbc_btnNew.gridy = 0;
        toolBar.add(btnNew, gbc_btnNew);

        JButton btnOpen = new JButton("open [ctrl + o]");       
        btnOpen.setIcon(new ImageIcon(Compiler.class.getResource("/icons/open-folder-outline.png")));
        GridBagConstraints gbc_btnOpen = new GridBagConstraints();
        gbc_btnOpen.fill = GridBagConstraints.BOTH;
        gbc_btnOpen.insets = new Insets(0, 0, 5, 0);
        gbc_btnOpen.gridx = 0;
        gbc_btnOpen.gridy = 1;
        toolBar.add(btnOpen, gbc_btnOpen);

        JButton btnSave = new JButton("save [ctrl + s]");
        btnSave.setIcon(new ImageIcon(Compiler.class.getResource("/icons/save.png")));
        GridBagConstraints gbc_btnSave = new GridBagConstraints();
        gbc_btnSave.fill = GridBagConstraints.BOTH;
        gbc_btnSave.insets = new Insets(0, 0, 5, 0);
        gbc_btnSave.gridx = 0;
        gbc_btnSave.gridy = 2;
        toolBar.add(btnSave, gbc_btnSave);

        JButton btnCopy = new JButton("copy [ctrl + c]");
        btnCopy.setIcon(new ImageIcon(Compiler.class.getResource("/icons/copy-document.png")));
        GridBagConstraints gbc_btnCopy = new GridBagConstraints();
        gbc_btnCopy.fill = GridBagConstraints.BOTH;
        gbc_btnCopy.insets = new Insets(0, 0, 5, 0);
        gbc_btnCopy.gridx = 0;
        gbc_btnCopy.gridy = 3;
        toolBar.add(btnCopy, gbc_btnCopy);

        JButton btnPaste = new JButton("paste [ctrl + v]");
        btnPaste.setIcon(new ImageIcon(Compiler.class.getResource("/icons/clipboard.png")));
        GridBagConstraints gbc_btnPaste = new GridBagConstraints();
        gbc_btnPaste.fill = GridBagConstraints.BOTH;
        gbc_btnPaste.insets = new Insets(0, 0, 5, 0);
        gbc_btnPaste.gridx = 0;
        gbc_btnPaste.gridy = 4;
        toolBar.add(btnPaste, gbc_btnPaste);

        JButton btnCut = new JButton("cut [ctrl + x]");
        btnCut.setIcon(new ImageIcon(Compiler.class.getResource("/icons/scissors.png")));
        GridBagConstraints gbc_btnCut = new GridBagConstraints();
        gbc_btnCut.fill = GridBagConstraints.BOTH;
        gbc_btnCut.insets = new Insets(0, 0, 5, 0);
        gbc_btnCut.gridx = 0;
        gbc_btnCut.gridy = 5;
        toolBar.add(btnCut, gbc_btnCut);

        JButton btnCompile = new JButton("compile [F9]");
        btnCompile.setIcon(new ImageIcon(Compiler.class.getResource("/icons/play-button.png")));
        GridBagConstraints gbc_btnCompile = new GridBagConstraints();
        gbc_btnCompile.fill = GridBagConstraints.BOTH;
        gbc_btnCompile.insets = new Insets(0, 0, 5, 0);
        gbc_btnCompile.gridx = 0;
        gbc_btnCompile.gridy = 6;
        toolBar.add(btnCompile, gbc_btnCompile);

        JButton btnAbout = new JButton("about [F1]");
        btnAbout.setIcon(new ImageIcon(Compiler.class.getResource("/icons/about-us.png")));
        GridBagConstraints gbc_btnAbout = new GridBagConstraints();
        gbc_btnAbout.fill = GridBagConstraints.BOTH;
        gbc_btnAbout.gridx = 0;
        gbc_btnAbout.gridy = 7;
        toolBar.add(btnAbout, gbc_btnAbout);

        JTextPane textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setMinimumSize(new Dimension(750, 480));
        frame.getContentPane().add(scrollPane, "cell 1 0,aligny top,grow");
        /**
         * Descomentar as proximas linhas para aparecer as linhas no editor
         */
		TextLineNumber tln = new TextLineNumber(textPane);
		scrollPane.setRowHeaderView( tln );
        
        JTextPane textPaneMessage = new JTextPane();
        textPaneMessage.setEditable(false);
        JScrollPane scrollPane_Messages = new JScrollPane(textPaneMessage);
        scrollPane_Messages.setMinimumSize(new Dimension(750, 105));
        scrollPane_Messages.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_Messages.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollPane_Messages, "cell 1 1,grow");
        
        JTextPane textPaneStatus = new JTextPane();
        textPaneStatus.setBackground(SystemColor.menu);
        textPaneStatus.setEditable(false);
        textPaneStatus.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        frame.getContentPane().add(textPaneStatus, "cell 0 2 2 1,grow");

        new TextShortcutBlocker(textPane).block(
                new ShortcutBlock("control C", "preventCopy"),
                new ShortcutBlock("control V", "preventPaste"),
                new ShortcutBlock("control X", "preventCut")
        );
        
        NewAction newAction = new NewAction(Arrays.asList(textPane, textPaneMessage, textPaneStatus));
        SaveAction saveAction = new SaveAction(textPane, textPaneMessage, textPaneStatus);
        OpenAction openAction = new OpenAction(textPane, textPaneMessage, textPaneStatus);
        CopyAction copyAction = new CopyAction(textPane);
        PasteAction pasteAction = new PasteAction(textPane);
        CutAction cutAction = new CutAction(textPane);
        CompileAction compileAction = new CompileAction(textPane, textPaneMessage, textPaneStatus);
        AboutAction aboutAction = new AboutAction(textPaneMessage);

        btnNew.addMouseListener(new MouseAction(newAction));        
        btnOpen.addMouseListener(new MouseAction(openAction));   
        btnSave.addMouseListener(new MouseAction(saveAction));
        btnCopy.addMouseListener(new MouseAction(copyAction));
        btnPaste.addMouseListener(new MouseAction(pasteAction));
        btnCut.addMouseListener(new MouseAction(cutAction));
        btnCompile.addMouseListener(new MouseAction(compileAction));
        btnAbout.addMouseListener(new MouseAction(aboutAction));

        KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        Stream.of(
                new KeyboardAction(new Shortcut(Arrays.asList(KeyEvent.CTRL_DOWN_MASK), KeyEvent.VK_N), newAction),
                new KeyboardAction(new Shortcut(Arrays.asList(KeyEvent.CTRL_DOWN_MASK), KeyEvent.VK_O), openAction),
                new KeyboardAction(new Shortcut(Arrays.asList(KeyEvent.CTRL_DOWN_MASK), KeyEvent.VK_S), saveAction),
                new KeyboardAction(new Shortcut(Arrays.asList(KeyEvent.CTRL_DOWN_MASK), KeyEvent.VK_C), copyAction),
                new KeyboardAction(new Shortcut(Arrays.asList(KeyEvent.CTRL_DOWN_MASK), KeyEvent.VK_V), pasteAction),
                new KeyboardAction(new Shortcut(Arrays.asList(KeyEvent.CTRL_DOWN_MASK), KeyEvent.VK_X), cutAction),
                new KeyboardAction(new Shortcut(KeyEvent.VK_F9), compileAction),
                new KeyboardAction(new Shortcut(KeyEvent.VK_F1), aboutAction)
        ).forEach(keyboardFocusManager::addKeyEventDispatcher);
    }

}
