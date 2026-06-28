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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode temp=head,prev=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        temp=head;
        n=len-n;
        if(n==0)
        {temp=head.next;
            head=null;
        return temp;}
        int i=0;
        while(i!=n)
        {   prev=temp;
            temp=temp.next;
            i++;
        }
        prev.next=temp.next;
        return head;
    }
}