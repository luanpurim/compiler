package view;

public class ShortcutBlock {

    String shortcut;
    String blockName;

    public ShortcutBlock(String shortcut, String blockName) {
        this.shortcut = shortcut;
        this.blockName = blockName;
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getBlockName() {
        return blockName;
    }
}
