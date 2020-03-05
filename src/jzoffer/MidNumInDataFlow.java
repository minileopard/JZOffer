package jzoffer;

import java.util.LinkedList;

public class MidNumInDataFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MidNumInDataFlow middle = new MidNumInDataFlow();
		middle.Insert(5);
		System.out.print(middle.GetMedian() + " ");
		middle.Insert(2);
		System.out.print(middle.GetMedian() + " ");
		middle.Insert(3);
		System.out.print(middle.GetMedian() + " ");
		middle.Insert(0);
		System.out.print(middle.GetMedian() + " ");
		middle.Insert(1);
		System.out.print(middle.GetMedian() + " ");
		middle.Insert(6);
		System.out.print(middle.GetMedian() + " ");
		middle.Insert(7);
		System.out.print(middle.GetMedian() + " ");
		middle.Insert(0);
		System.out.print(middle.GetMedian() + " ");
		middle.Insert(8);
		System.out.print(middle.GetMedian() + " ");
	}
	LinkedList<Integer> list = new LinkedList<Integer>();
    public void Insert(Integer num) {
        int len = list.size();
        if(len == 0)
        {
            list.add(num);
        }else
        {
            if(list.getLast() <= num)
            {
                list.add(num);
                return;
            }
            for(int i = 0; i < len; i++)
            {
                if(list.get(i) >= num)
                {
                    list.add(i, num);
                    break;
                }
            }
        }
    }

    public Double GetMedian() {
        int len = list.size();
        int index = len / 2;
        if(len == 0)
        {
            return 0.0;
        }else if(len % 2 == 0)//Å¼Êı
        {
            return (list.get(index) + list.get(index - 1)) / 2.0;
        }else if(len % 2 == 1)
        {
            return (double)list.get(index);
        }
        return 0.0;
    }
}
