class Solution {
    public int minMoves(int[] nums) {
        int n =  nums.length-1;
        
        Arrays.sort(nums);
           int max = nums[nums.length - 1];
        int a = 0;
        for(int num : nums){
            a +=  max - num;
        }
        return a;
    }
}