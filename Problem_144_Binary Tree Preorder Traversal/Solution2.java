//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 527 👎 0

package com.glj.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left, right;
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
   // 法二：迭代法
   // 算法思想：略
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：前序遍历中，每个节点都访问一次且仅访问一次，所以为O(n)
   // 空间复杂度说明：为迭代过程中显式栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状，为 O(n)
   // 参考资料：略
   // 备注1：题目二刷
   class Solution {
       public List<Integer> preorderTraversal(TreeNode root) {
           List<Integer> ans = new LinkedList<>();
           if (root == null) {
               return ans;
           }

           // 使用队列模拟一个栈
           Deque<TreeNode> stack = new LinkedList<>();
           stack.push(root);  // 进栈
           while (!stack.isEmpty()) {  // 这里一定不要写成（stack != null）!!!! 面试的时候就写错过QAQ
               // 遍历 根的val
               TreeNode node = stack.pop();  // 出栈
               ans.add(node.val);
               // 为了满足 根左右 的遍历顺序，应该让右子树先进栈，左子树后进栈
               if (node.right != null) {  // 这里是node.right，而不是root.right！！！
                   stack.push(node.right);
               }
               if (node.left != null) {
                   stack.push(node.left);
               }
           }

           return ans;
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}