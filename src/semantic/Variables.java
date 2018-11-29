package semantic;

import java.util.HashMap;
import java.util.Map;

public class Variables {

    private Map<String, Object> variables = new HashMap<>();

    public void put(String variable, Object value) {
        this.variables.put(variable, value);
    }

    public <T> T get(String variable) {
        return (T) this.variables.get(variable);
    }

}
