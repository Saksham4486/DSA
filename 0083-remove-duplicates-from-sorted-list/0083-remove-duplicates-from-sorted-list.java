/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
        return head;
        ListNode dummy=new ListNode(-1,head);
        ListNode curr=dummy.next;
        while(head.next!=null)
        {
            if(head.val!=head.next.val)
                {curr.next=head.next;
                curr=curr.next;}
            head=head.next;
        }
        curr.next=null;
        return dummy.next;
    }
}