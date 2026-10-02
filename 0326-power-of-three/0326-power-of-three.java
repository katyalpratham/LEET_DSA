class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        return check(1, n);
    }

    private boolean check(long current, int n) {
        if (current == n) {
            return true;
        }

        if (current > n) {
            return false;
        }
        return check(current * 3, n);
    }
}