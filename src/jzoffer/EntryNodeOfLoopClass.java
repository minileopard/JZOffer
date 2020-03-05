package jzoffer;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class EntryNodeOfLoopClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntryNodeOfLoopClass c = new EntryNodeOfLoopClass(); 
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n5;
		
		System.out.println(c.EntryNodeOfLoop(n1).val);
	}
	
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null)
            return null;
        //先用快慢指针找到是否包含环，两指针最终会交到环的某个节点上
        ListNode fast = pHead, slow = pHead, meet = null;
        while(fast!=null && fast.next!=null && slow!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
            	meet = fast;
            	break;
            }
        }
        if(meet == null)
            return null;
        //求环中的节点数目
        int nodesinloop = 1;
        ListNode pn1 = meet;
        while(pn1.next!=meet)
        {
            pn1 = pn1.next;
            nodesinloop++;
        }
        pn1 = pHead;
        for(int i = 0; i < nodesinloop; i++)
        {
            pn1 = pn1.next;
        }
        ListNode pn2 = pHead;
        while(pn1!=pn2)
        {
            pn1 = pn1.next;
            pn2 = pn2.next;
        }
        return pn1;
    }
}
