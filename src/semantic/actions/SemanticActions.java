package semantic.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SemanticActions {

    private static Map<Integer, SemanticActionHandler> actions = new HashMap<>();

    static {
        // register(new SumAction);
    }

    public static Optional<SemanticActionHandler> get(int id) {
        return Optional.ofNullable(actions.get(id));
    }

    private static void register(SemanticActionHandler actionHandler) {
        actions.put(actionHandler.id(), actionHandler);
    }

    private SemanticActions() {}

}
