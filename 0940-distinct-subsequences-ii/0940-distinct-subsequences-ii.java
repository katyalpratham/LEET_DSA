class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        dp[0] = 1; // empty subsequence

        int[] last = new int[26];

        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);

            dp[i] = (2 * dp[i - 1]) % MOD;

            int idx = ch - 'a';

            if (last[idx] != -1) {
                dp[i] = (dp[i] - dp[last[idx] - 1] + MOD) % MOD;
            }

            last[idx] = i;
        }

        return (int)((dp[n] - 1 + MOD) % MOD); // remove empty subsequence
    }
}