package semantic;

import java.util.EnumMap;
import java.util.Map;

public class Variables {

    private Map<Variable, Object> variables = new EnumMap<>(Variable.class);

    public void set(Variable variable, Object value) {
        this.variables.put(variable, value);
    }

    public <T> T get(Variable variable) {
        return (T) this.variables.get(variable);
    }

}
