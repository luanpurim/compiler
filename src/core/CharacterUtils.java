package core;

public class CharacterUtils {

    public static boolean isBreakCharacter(char character) {
        return isLineBreak('\n') || character == '\t' || character == ' ';
    }

    public static boolean isLineBreak(char character) {
        return character == '\n';
    }

}
