
class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;

        int sum = 0;

        // Calculate complete weeks
        sum = 28 * weeks + (7 * weeks * (weeks - 1)) / 2;

        // Calculate remaining days
        int start = weeks + 1;

        for (int i = 0; i < days; i++) {
            sum += start + i;
        }

        return sum;
    }
}
