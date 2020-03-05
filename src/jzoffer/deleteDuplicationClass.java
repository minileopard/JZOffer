package jzoffer;

public class deleteDuplicationClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deleteDuplicationClass c = new deleteDuplicationClass();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		ListNode root = c.deleteDuplication(n1);
		while(root!=null)
		{
			System.out.print(root.val + " ");
			root = root.next;
		}
		System.out.println();
	}
	public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode pre = null, index = pHead;
        while(index != null && index.next!=null)
        {
            if(index.next.val == index.val)
            {
                while(index.next!=null && index.next.val == index.val)
                {
                    index = index.next;
                }
                if(pre == null)
                {
                    pHead = index.next;
                    index = pHead;
                }else
                {
                    pre.next = index.next;
                    index = index.next;
                }
            }else
            {
                pre = index;
                index = index.next;
            }
        }
        return pHead;
    }
}
