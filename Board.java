import java.util.LinkedList;
import org.javatuples.Pair;

public class Board {
    private final CodePegs secretCode;
    private LinkedList<Pair<CodePegs, KeyPegs>> rows;

    public Board(final CodePegs sc) {
        assert sc != null;
        secretCode = sc;
        rows = new LinkedList<Pair<CodePegs, KeyPegs>>();
    }

    public final CodePegs getSecretCode() {
        return secretCode;
    }

    public final LinkedList<Pair<CodePegs, KeyPegs>> getRows() {
        return rows;
    }

    public final KeyPegs guess(final CodePegs code) {
        assert code != null;
        KeyPegs key = getFeedback(code);
        rows.add(new Pair<CodePegs, KeyPegs>(code, key));
        return key;
    }

    private KeyPegs getFeedback(final CodePegs code) {
        assert code != null;
        // TODO: Implement this
        return null;
    }
}
