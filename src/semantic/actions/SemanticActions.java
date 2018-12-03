package semantic.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SemanticActions {

    private static Map<Integer, SemanticActionHandler> actions = new HashMap<>();

    static {
        register(new Action001());
        register(new Action002());
        register(new Action003());
        register(new Action004());
        register(new Action006());
        register(new Action011());
        register(new Action012());
        register(new Action013());
    }

    public static Optional<SemanticActionHandler> get(int id) {
        return Optional.ofNullable(actions.get(id));
    }

    private static void register(SemanticActionHandler actionHandler) {
        actions.put(actionHandler.id(), actionHandler);
    }

    private SemanticActions() {}

}
