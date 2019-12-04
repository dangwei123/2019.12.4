给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值
大于n。如果不存在这样的32位整数，则返回-1。
class Solution {
    public int nextGreaterElement(int n) {
        int len=0;
        int tmp=n;
        while(tmp!=0){
            len++;
            tmp/=10;
        }
        int[] arr=new int[len];
        tmp=n;
        len--;
        while(tmp!=0){
            arr[len--]=tmp%10;
            tmp/=10;
        }
        int swap=0;
        int i=0;
        for(i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                swap=i;
                break;
            }
        }
        if(i<0){
            return -1;
        }
        for(i=arr.length-1;i>=0;i--){
            if(arr[i]>arr[swap]){
               int a=arr[i];
               arr[i]=arr[swap];
               arr[swap]=a;
               break;
            }
        }
        Arrays.sort(arr,swap+1,arr.length);
        int res=0;
        for(i=0;i<arr.length;i++){
            res=res*10+arr[i];
            if(res>Integer.MAX_VALUE/10||(res-Integer.MAX_VALUE/10>7)){
                return -1;
            }
        }
        return res;
    }
}

链表：
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
                cur=cur.next;
            }else{
                cur.next=l2;
                l2=l2.next;
                cur=cur.next;
            }
        }
        if(l1!=null){
            cur.next=l1;
        }if(l2!=null){
            cur.next=l2;
        }
        return dummy.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=head;
        ListNode cur=pre.next;
        while(cur!=null){
            if(pre.val==cur.val){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}