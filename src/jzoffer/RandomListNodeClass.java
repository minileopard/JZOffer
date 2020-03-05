package jzoffer;
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class RandomListNodeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		n1.random = null;
		n2.random = n1;
		n3.random = n5;
		n4.random = n1;
		n5.random = n2;
		
		RandomListNodeClass c = new RandomListNodeClass();
		c.Clone(n1);
	}
	
	public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        RandomListNode index = pHead;
        //第一步复制之后将新的和旧的通过next交叉起来
        while(index!=null)
        {
            RandomListNode temp = new RandomListNode(index.label);
            temp.next = index.next;
            index.next = temp;
            index = temp.next;
        }
        //第二步处理randam指针，新的指到旧的下一个
        index = pHead;
        while(index!=null && index.next!=null)
        {
            if(index.random == null)
                index.next.random = null;
            else
                index.next.random = index.random.next;
            index = index.next.next;
        }
        //第三步断开交叉的next指针
        index = pHead;
        RandomListNode res = pHead.next;
        while(index.next!=null)
        {
            RandomListNode temp = index.next;
            index.next = index.next.next;
            index = temp;
        }
        print(res);
        return res;
    }
	public void print(RandomListNode pHead)
	{
		while(pHead!=null)
		{
			System.out.print(pHead.label + " ");
			pHead = pHead.next;
		}
		System.out.println();
	}
}
