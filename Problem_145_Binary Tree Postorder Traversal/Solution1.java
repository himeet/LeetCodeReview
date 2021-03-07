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
   // 法一：递归法
   // 算法思想：略
   // 时间复杂度：O(n)，空间复杂度：O(n)  其中n是二叉树的节点数
   // 时间复杂度说明：略
   // 空间复杂度说明：略
   // 参考资料1：略
   // 备注1：题目二刷
   class Solution {
       public List<Integer> postorderTraversal(TreeNode root) {
           List<Integer> ans = new LinkedList<>();
           dfs(root, ans);
           return ans;
       }

       /**
        * 深度优先遍历-后序遍历-递归调用
        * @param root
        * @param ans
        */
       public void dfs(TreeNode root, List<Integer> ans) {
           // 递归结束的条件，到达叶子节点开始返回
           if (root == null) {
               return;
           }
           dfs(root.left, ans);
           dfs(root.right, ans);
           ans.add(root.val);
       }
   }
   //leetcode submit region end(Prohibit modification and deletion)

}