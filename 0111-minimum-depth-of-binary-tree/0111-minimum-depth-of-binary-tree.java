class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int ld = root.left == null ?Integer.MAX_VALUE : minDepth(root.left);
        int rd = root.right == null ?Integer.MAX_VALUE :minDepth(root.right);;
        return Math.min(ld,rd)+1;
    }
}