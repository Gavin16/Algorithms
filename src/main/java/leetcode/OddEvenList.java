package leetcode;

import datastruct.ListNode;
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

    /**  */
    private static ListNode oddEvenList(ListNode head) {
        if(null == head || null == head.next || null == head.next.next) return head;

        // 链表节点数大于 3
        ListNode odd = head, even = head.next, evenHead = even ,curr = even.next;
        int cnt = 1;
        while(curr != null){
            if((cnt & 1) == 1){
                odd.next = curr;
                odd = odd.next;
            }else{
                even.next = curr;
                even = even.next;
            }
            cnt ++;
            curr = curr.next;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }

    /**
     * 官方解法：注意结束条件
     */
    static ListNode oddEvenList2(ListNode head){
        if(null == head || null == head.next) return head;

        ListNode odd = head, even = head.next, evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


}