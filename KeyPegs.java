public class KeyPegs {
    private static final int MAX_NUM_PEGS = 4;

    private final int numWhitePegs;
    private final int numBlackPegs;

    public KeyPegs(final int nwp, final int nbp) {
        assert nwp >= 0;
        assert nbp >= 0;
        assert nwp + nbp <= MAX_NUM_PEGS;
        numWhitePegs = nwp;
        numBlackPegs = nbp;
    }

    public final int getNumWhitePegs() {
        return numWhitePegs;
    }

    public final int getNumBlackPegs() {
        return numBlackPegs;
    }
}
