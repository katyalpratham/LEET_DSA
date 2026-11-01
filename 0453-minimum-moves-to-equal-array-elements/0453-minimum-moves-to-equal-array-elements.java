class Solution {
    public int minMoves(int[] nums) {
        int n =  nums.length-1;
        
        Arrays.sort(nums);
        int min = nums[0];
        int a = 0;
        for(int num : nums){
            a +=  num - min;
        }
        return a;
    }
}