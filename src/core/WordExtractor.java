package core;

public class WordExtractor {

    public String extract(String code, int position) {
        StringBuilder lexemeBuilder = new StringBuilder();
        for (char c : code.substring(position, code.length()).toCharArray()) {
            if (!isBreakCharacter(c)) {
                lexemeBuilder.append(c);
            } else {
                break;
            }
        }
        return lexemeBuilder.toString();
    }

    private boolean isBreakCharacter(char character) {
        return character == ' ' || character == '\t' || character == '\r' || character == '\n';
    }

}
