package semantic.actions;

import java.util.HashMap;
import java.util.Map;

public final class SemanticActions {

    private static Map<Integer, SemanticActionHandler> actions = new HashMap<>();

    static {
        // register(new SumAction);
    }

    public static SemanticActionHandler get(int id) {
        return actions.get(id);
    }

    private static void register(SemanticActionHandler actionHandler) {
        actions.put(actionHandler.id(), actionHandler);
    }

    private SemanticActions() {}

}
