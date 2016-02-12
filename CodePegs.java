import org.javatuples.Quartet;

public class CodePegs {
    public enum Peg { RED, GREEN, BLUE, PURPLE, ORANGE, YELLOW };

    private static final int NUM_PEGS = 4;

    private final Quartet<Peg, Peg, Peg, Peg> pegs;

    public CodePegs(final Peg peg0, final Peg peg1, final Peg peg2,
            final Peg peg3) {
        assert peg0 != null;
        assert peg1 != null;
        assert peg2 != null;
        assert peg3 != null;
        pegs = new Quartet<Peg, Peg, Peg, Peg>(peg0, peg1, peg2, peg3);
    }

    public final Peg getPeg(final int index) {
        assert index >= 0;
        assert index < NUM_PEGS;
        return (Peg) pegs.getValue(index); // Unsafe downcast
    }

    public final KeyPegs compare(final CodePegs that) {
        assert that != null;
        int numWhitePegs = 0;
        int numBlackPegs = 0;
        for (int i = 0; i < NUM_PEGS; i++) {
            if (getPeg(i) == that.getPeg(i)) {
                numBlackPegs++;
            } else if (pegs.contains(that.getPeg(i))) {
                numWhitePegs++;
            }
        }
        return new KeyPegs(numWhitePegs, numBlackPegs);
    }
}
