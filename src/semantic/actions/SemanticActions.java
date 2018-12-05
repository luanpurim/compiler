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
        register(new Action007());
        register(new Action008());
        register(new Action009());
        register(new Action010());
        register(new Action011());
        register(new Action012());
        register(new Action013());
        register(new Action014());
        register(new Action015());
        register(new Action016());
        register(new Action017());
        register(new Action018());
        register(new Action019());
        register(new Action020());
        register(new Action101());
        register(new Action102());
        register(new Action103());
        register(new Action104());
        register(new Action105());
        register(new Action106());
        register(new Action107());
        register(new Action108());
        register(new Action109());
        register(new Action110());
        register(new Action111());
        register(new Action112());
    }

    public static Optional<SemanticActionHandler> get(int id) {
        return Optional.ofNullable(actions.get(id));
    }

    private static void register(SemanticActionHandler actionHandler) {
        actions.put(actionHandler.id(), actionHandler);
    }

    private SemanticActions() {}

}
