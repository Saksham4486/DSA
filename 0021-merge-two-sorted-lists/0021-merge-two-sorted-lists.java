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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
        return list2;
        if(list2==null)
        return list1;
        ListNode ans=new ListNode(-1);
        ListNode ans1=ans;
        while(list1!=null&&list2!=null)
        {
            if(list1.val>list2.val)
            {
                ans1.next=list2;
                list2=list2.next;
            }
            else
            {
                ans1.next=list1;
                list1=list1.next;
            }
            ans1=ans1.next;
        }
        if(list1!=null)
        ans1.next=list1;
        if(list2!=null)
        ans1.next=list2;
        return ans.next;
    }
}