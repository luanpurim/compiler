package semantic.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SemanticActions {

    private static Map<Integer, SemanticActionHandler> actions = new HashMap<>();

    static {
        register(new Sum()); // #1
        register(new Sub()); // #2
        register(new Mul()); // #3
        register(new Div()); // #4
        register(new PushNumber()); // #6
        register(new PushTrue()); // #11
        register(new PushFalse()); // #12
    }

    public static Optional<SemanticActionHandler> get(int id) {
        return Optional.ofNullable(actions.get(id));
    }

    private static void register(SemanticActionHandler actionHandler) {
        actions.put(actionHandler.id(), actionHandler);
    }

    private SemanticActions() {}

}
