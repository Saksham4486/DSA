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
    public ListNode removeNodes(ListNode head) {
      head= reverselist(head);
        ListNode curr=head;
        int max=curr.val;
        while(curr!=null&&curr.next!=null)
        {   
                if(max>curr.next.val)
                {
                    curr.next=curr.next.next;
                }
                else
                {
                    curr=curr.next;
                    max=curr.val;
                }
              
        }
    return reverselist(head);
    }
    public static ListNode reverselist(ListNode head)
    {
        if(head==null||head.next==null)
        return head;
        ListNode curr=head,prev=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}