class Solution {
    public int minMoves2(int[] nums) {
        int n =  nums.length-1;
        
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int a = 0;
        for(int num : nums){
            a +=  Math.abs(num - median);
        }
        return a;
    }
}