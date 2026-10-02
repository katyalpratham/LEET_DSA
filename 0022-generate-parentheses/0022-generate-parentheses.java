class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve("",0,0,n);
        return ans;
       
    }
    void solve (String current , int open , int close, int n){
        if(current.length() == 2*n){
            ans.add(current);
            return;
        }
        if(open < n){
            solve(current + "(" , open+1 , close,n);
        }
        if(close<open){
            solve(current +")", open , close +1, n);
        }
    }
}