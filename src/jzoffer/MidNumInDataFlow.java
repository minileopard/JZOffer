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
	LinkedList<Integer> maxheap = new LinkedList<Integer>();//大顶堆
	LinkedList<Integer> minheap = new LinkedList<Integer>();//小顶堆
	int length = 0;//数据流长度
    public void Insert(Integer num) {
        length++;
        int ys = length % 2;
        if(ys == 1)
        {
        	//奇数写入小顶堆，小顶堆最小值要比大顶堆最大值大
        	if(maxheap.size() == 0)//大顶堆大小为0，直接插入小顶堆
        	{
        		insertHeap(minheap, num, true);
        	}else//判断数值是否比大顶堆最大值小，如果是需要将大顶堆最大值拿过来插入小顶堆，num插入大顶堆，为的是维持大顶堆永远比小顶堆小
        	{
        		int maxNumInMaxHeap = maxheap.get(0);
        		if(num < maxNumInMaxHeap)
        		{
        			maxheap.remove(0);//把要更换的值删去
        			insertHeap(maxheap, num, false);//插入大顶堆，小的值
        			insertHeap(minheap, maxNumInMaxHeap, true);//大的值插入小顶堆
        		}else
        		{
        			insertHeap(minheap, num, true);
        		}
        	}
        }else//偶数写入大顶堆，大顶堆所有的数要小于等于小顶堆
        {
        	int minNumInMinHeap = minheap.get(0);
        	if(num > minNumInMinHeap)
        	{
        		minheap.remove(0);
        		insertHeap(maxheap, minNumInMinHeap, false);//小的值写入大顶堆
        		insertHeap(minheap, num, true);//大的值写入小顶堆
        	}else
        	{
        		insertHeap(maxheap, num, false);//小的值写入大顶堆
        	}
        }
    }

    public Double GetMedian() {
    	if(length == 0)
    		return 0.0;
    	else if(length == 1)
    		return (double)minheap.get(0);
    	int ys = length % 2;
    	int max = maxheap.get(0), min = minheap.get(0);
    	double midnum = min;
        if(ys == 0)
        {
        	midnum = (max + min) / 2.0;
        }
        return midnum;
    }
    //插入大顶堆或者小顶堆
    public void insertHeap(LinkedList<Integer> arr, int num, boolean minheap)
    {
    	//添加之后调整使得该堆是个大顶堆或小顶堆
    	arr.add(0, num);
    	//1.构建大顶堆
        for(int i=arr.size()/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.size(), minheap);
        }
    }
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）minheap为true是小顶堆
     * @param arr
     * @param i
     * @param length
     */
    public void adjustHeap(LinkedList<Integer> arr,int i,int length, boolean minheap){
        int temp = arr.get(i);//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr.get(k)<arr.get(k+1) ^ minheap){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr.get(k) >temp ^ minheap){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            	arr.set(i, arr.get(k));
                i = k;
            }else{
                break;
            }
        }
        arr.set(i, temp);//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public void swap(LinkedList<Integer> arr,int a ,int b){
        int temp = arr.get(a);
        arr.set(a, maxheap.get(b));
        arr.set(b, temp);
    }
}
