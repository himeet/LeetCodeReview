//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 537 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode () {};
        TreeNode (int val) { this.val = val; };
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
    // 法二：迭代法
    // 算法思想：略
    // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
    // 时间复杂度说明：略
    // 空间复杂度说明：略
    // 参考资料1：略
    // 备注1：题目二刷
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                ans.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }

            // 反转list
            Collections.reverse(ans);

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}