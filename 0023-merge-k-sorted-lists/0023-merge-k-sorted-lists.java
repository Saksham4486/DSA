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
    public static ListNode mergetwolists(ListNode l1,ListNode l2)
    {
        if(l1==null)
        return l2;
        if(l2==null)
        return l1;
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        while(l1!=null&&l2!=null)
        {
            if(l1.val>=l2.val)
            {
                prev.next=l2;
                l2=l2.next;
                prev=prev.next;
            }
            else
            {
                prev.next=l1;
                l1=l1.next;
                prev=prev.next;
            }

        }
        if(l1!=null)
        prev.next=l1;
        if(l2!=null)
        prev.next=l2;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
      int n=lists.length;
      if(n==0)
      return null;
      if(n==1)
      return lists[0];
        while(n>1)
        {   
            int k=(n+1)/2;
        for(int i=0;i<n/2;i++)
        {
            lists[i]=mergetwolists(lists[i],lists[n-1-i]);
        }  
        n=k;
        }
         return lists[0];
    }
   
}