class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int curr_row = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {

            rows[curr_row].append(c);

            if (curr_row == 0 || curr_row == numRows - 1) {
                goingDown = !goingDown;
            }

            curr_row += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
