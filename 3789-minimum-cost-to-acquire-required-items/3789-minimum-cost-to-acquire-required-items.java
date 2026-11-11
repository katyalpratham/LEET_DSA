class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long cA = (long) cost1 * need1 + (long) cost2 * need2;
        long cB = (long)Math.max(need1, need2) * costBoth;
        long comb_count = Math.min(need1, need2);
        long remaining = Math.max(need1, need2)- comb_count;

        long cc;

        if (need1 < need2) {
            cc = comb_count * costBoth + remaining * cost2;
        } else {
            cc = comb_count * costBoth + remaining * cost1;
        }
        return Math.min(cA,Math.min(cB,cc));

    }
}