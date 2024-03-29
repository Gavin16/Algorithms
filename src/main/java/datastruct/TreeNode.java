package datastruct;

import leetcode.byteDance.Day02;

/**
 * @Class: TreeNode
 * @Description: 二叉树节点
 * @Author: Minsky
 * @Date: 2019/8/14 20:17
 * @Version: v1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}
    public TreeNode(int x) { val = x; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
