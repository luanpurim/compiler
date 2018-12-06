package actions;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class CodeTestLoader {

    public static String loadCode(String code) {
        try {
            String path = String.format("test-resources/%s.txt", code);
            return String.join("\n", Files.readAllLines(Paths.get(path)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
