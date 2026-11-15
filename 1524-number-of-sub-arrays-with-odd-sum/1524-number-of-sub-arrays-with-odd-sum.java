class Solution {
    public int numOfSubarrays(int[] arr) {
        int even = 1 , odd = 0;
        int ans = 0;
        int M = 1000000007;
        int cs = 0;
        for(int i =0 ; i < arr.length; i++){
            cs += arr[i];
         
                if(cs % 2 == 1){
                    ans += even;
                }
                else{
                    ans += odd;
                }
              if(cs % 2 == 1){
                odd++;
              }  
              else {
                even++;
              }
            ans %= M;

            }
        
     return ans;
    }
}