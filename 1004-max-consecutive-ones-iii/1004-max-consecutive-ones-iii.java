class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int maxLength =0;
        for(int i = 0 ;i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }
           while(count > k){
            if(nums[left]== 0){
                count--;
            }
            left++;
           }
            maxLength =  Math.max(maxLength, i -left +1);

        }
        return maxLength;
    }
}