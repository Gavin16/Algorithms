package leetcode.depthFirstSearch;

import datastruct.TreeNode;

/**
 * 《LeetCode  129. 求根到叶子节点数字之和》
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 */
public class SumNumbers {

    static int sum = 0;

    static int sumNumbers(TreeNode root) {
        if(root != null){
            recursiveFindValue(0,root);
        }
        return sum;
    }

    static void recursiveFindValue(int curVal,TreeNode root){
        curVal = curVal * 10 + root.val;

        if(null == root.left && null == root.right){
            sum += curVal;
        }
        if(null != root.left){
            recursiveFindValue(curVal, root.left);
        }
        if(null != root.right){
            recursiveFindValue(curVal, root.right);
        }
    }
}
