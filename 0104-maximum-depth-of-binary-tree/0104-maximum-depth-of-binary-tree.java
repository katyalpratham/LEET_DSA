public class TreeNode {
      int root;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int root) { this.root = root; }
      TreeNode(int root, TreeNode left, TreeNode right) {
          this.root = root;
          this.left = left;
          this.right = right;
      }
 }

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left_len = maxDepth(root.left);
        int right_len =maxDepth(root.right);
        return 1+Math.max(left_len ,right_len);
    }
}