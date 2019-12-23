package leetCode;

import dataStruct.ListNode;
import utils.LinkedListUtil;

/**
 * @ClassName: OddEvenList
 * @Description:
 * 《328. 奇偶链表》
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @Author: wufangmin
 * @Date: 2019/12/19 17:14
 * @Version:
 */
public class OddEvenList {


    public static void main(String[] args) {
        ListNode listNode = LinkedListUtil.genSortedLinkedList(9);
        LinkedListUtil.showLinkedList(listNode);

        ListNode listNode1 = oddEvenList(listNode);
        LinkedListUtil.showLinkedList(listNode1);
    }


    static ListNode oddEvenList(ListNode root){
        if(null == root || null == root.next || null == root.next.next) return root;



        return root;
    }

    static ListNode oddRecursive(ListNode pre,ListNode curr){
        if(curr == null || curr.next == null){
            return pre;
        }

        pre.next = oddRecursive(curr.next,curr.next.next);

        return pre;
    }

    static ListNode evenRecursive(ListNode pre ,ListNode curr){
        if(curr == null || curr.next == null){
            return curr;
        }

        curr.next = evenRecursive(curr.next,curr.next.next);
        return curr;
    }
}
