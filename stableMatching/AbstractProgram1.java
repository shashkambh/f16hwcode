public abstract class AbstractProgram1 {
    public abstract boolean isStableMatching(Matching marriage);

    /**
     * Brute force solution to the Stable Marriage problem. Relies on the
     * function isStableMatching(Matching) to determine whether a candidate
     * Matching is stable.
     * 
     * @return A stable Matching.
     */
    public Matching stableMarriageBruteForce(Matching marriage) {
        int n = marriage.getWomenCount();
        int m = marriage.totalMenCount();

        Permutation p = new Permutation(n, m);

        Matching matching;
        while ((matching = p.getNextMatching(marriage)) != null) {
            if (isStableMatching(matching) == true) {
                return matching;
            }
        }

        return new Matching(marriage);
    }

    public abstract Matching stableMarriageGaleShapley(Matching marriage);
}
