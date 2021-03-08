//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 621 👎 0

package com.glj.leetcode.editor.cn;

public class BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode () {}
        TreeNode (int val) { this.val = val; }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    // 法一：自顶向下的递归
    // 算法思想：略
    // 时间复杂度：O(n^2)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：略
    // 空间复杂度说明：略
    // 参考资料1：略
    // 备注1：题目二刷
    // 备注2：注意判断条件不只是root这个二叉树是平衡树，所有的子树也必须是平衡树
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
//            if (Math.abs(height(root.left) - height(root.right)) > 1) {
//                return false;
//            } else {
//                return true;
//            }
            if (Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * 计算以root为根的二叉树的高度
         * @param root
         * @return
         */
        public int height(TreeNode root) {
            // 递归结束边界
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}