//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 782 👎 0

package com.glj.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
   // 法一：深度优先遍历-递归-自顶向下
   // 备注1：题目二刷
   class Solution {
       public TreeNode invertTree(TreeNode root) {
           helper(root);
           return root;
       }

       /**
        * 翻转二叉树 递归调用
        * @param root
        */
       public void helper(TreeNode root) {
           // 递归结束边界
           if (root == null) {
               return;
           }
           // 对于本层节点，反转root的左右孩子
           TreeNode tmp = root.left;
           root.left = root.right;
           root.right = tmp;
           // 对于root的左子树和右子树同样翻转
           helper(root.left);
           helper(root.right);
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}