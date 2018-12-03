package semantic.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SemanticActions {

    private static Map<Integer, SemanticActionHandler> actions = new HashMap<>();

    static {
        register(new Action1());
        register(new Action2());
        register(new Action3());
        register(new Action4());
        register(new Action5());
        register(new Action11());
        register(new Action12());
        register(new Action13());
    }

    public static Optional<SemanticActionHandler> get(int id) {
        return Optional.ofNullable(actions.get(id));
    }

    private static void register(SemanticActionHandler actionHandler) {
        actions.put(actionHandler.id(), actionHandler);
    }

    private SemanticActions() {}

}
