import domain.Function;
import java.util.ArrayList;
import java.util.List;

public class POS {
    private final List<Function> functions;

    public POS() {
        this.functions = new ArrayList<>();
    }

    public Function selectFunction(int functionNumber) {
        return functions.get(functionNumber - 1);
    }
}
