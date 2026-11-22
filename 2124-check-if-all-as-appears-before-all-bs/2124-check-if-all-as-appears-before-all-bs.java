class Solution {
    public boolean checkString(String s) {
     int a = 0 ;
     int b = 0;
     for(char c  : s.toCharArray()){
        if(c == 'a' && b == 0){
            a++;
        }
        else if(c =='a' && b > 0){
            return false;
        }
        else{
            b++;
            }
     }
     return true;

    }
}