// 104. Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
// 时间复杂度: O(n), n是树中的节点个数
// 空间复杂度: O(h), h是树的高度
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 左右孩子树的最大深度 + 当前Node一层
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.TreeNode root = solution.new TreeNode(0);
        root.left = solution.new TreeNode(-1);
        System.out.println(solution.maxDepth(root));
    }
}
