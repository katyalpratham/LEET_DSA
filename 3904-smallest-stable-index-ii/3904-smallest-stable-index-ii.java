class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int maxpre [] =  new int [n];
        int minpre [] =  new int [n];

        maxpre[0] = nums[0];
        for(int i = 1; i < n ; i++){
            maxpre[i] = Math.max(maxpre[i-1] , nums[i]);
        }

        minpre[n-1] = nums[n-1];
        for(int i = n-2; i >=0; i--){
            minpre[i] = Math.min(minpre[i+1] , nums[i]);
        }

        int res = -1;
        for(int i = 0; i < n; i++){
            int curr =maxpre[i] - minpre[i];
            if(curr <= k){
                return i;
            }
            
        }
        return -1;
    }
}