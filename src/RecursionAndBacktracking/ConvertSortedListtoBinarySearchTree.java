package RecursionAndBacktracking;

class ListNode {
     int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

 }


class Solution {

    private ListNode beforeMiddle(ListNode head){
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        return prev;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode beforeMiddleNode=beforeMiddle(head);
        ListNode middle=beforeMiddleNode.next;
        TreeNode root=new TreeNode(middle.val);
        beforeMiddleNode.next=null;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(middle.next);
        return root;
    }
}