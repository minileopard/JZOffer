package jzoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MidNumInDataFlow_PriorityQueue {
	PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
	});
	int length = 0;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		MidNumInDataFlow_PriorityQueue middle = new MidNumInDataFlow_PriorityQueue();
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

	private double GetMedian() {
		// TODO Auto-generated method stub
		if((length & 1) == 0)
		{
			return (minheap.peek() + maxheap.peek()) / 2.0;
		}else
		{
			return maxheap.peek();
		}
	}

	private void Insert(int num) {
		// TODO Auto-generated method stub
		length++;
		maxheap.add(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((length & 1) != 0) {
            maxheap.add(minheap.poll());
        }
	}
	

}
