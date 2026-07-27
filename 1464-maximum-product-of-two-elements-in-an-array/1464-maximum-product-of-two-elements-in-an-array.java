class Solution {
    public int maxProduct(int[] nums) {
        int arr[] = new int[nums.length];

        // for(int i = 0; i<nums.length;i++){
        //     arr[i] = nums[i]-1;
        // }
        // Arrays.sort(arr);
     Arrays.sort(nums);
        // return arr[nums.length-2]*arr[nums.length-1];
        return (nums[nums.length-2]-1)*(nums[nums.length-1]-1);
    }
}