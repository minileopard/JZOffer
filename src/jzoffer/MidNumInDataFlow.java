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
	LinkedList<Integer> maxheap = new LinkedList<Integer>();//�󶥶�
	LinkedList<Integer> minheap = new LinkedList<Integer>();//С����
	int length = 0;//����������
    public void Insert(Integer num) {
        length++;
        int ys = length % 2;
        if(ys == 1)
        {
        	//����д��С���ѣ�С������СֵҪ�ȴ󶥶����ֵ��
        	if(maxheap.size() == 0)//�󶥶Ѵ�СΪ0��ֱ�Ӳ���С����
        	{
        		insertHeap(minheap, num, true);
        	}else//�ж���ֵ�Ƿ�ȴ󶥶����ֵС���������Ҫ���󶥶����ֵ�ù�������С���ѣ�num����󶥶ѣ�Ϊ����ά�ִ󶥶���Զ��С����С
        	{
        		int maxNumInMaxHeap = maxheap.get(0);
        		if(num < maxNumInMaxHeap)
        		{
        			maxheap.remove(0);//��Ҫ������ֵɾȥ
        			insertHeap(maxheap, num, false);//����󶥶ѣ�С��ֵ
        			insertHeap(minheap, maxNumInMaxHeap, true);//���ֵ����С����
        		}else
        		{
        			insertHeap(minheap, num, true);
        		}
        	}
        }else//ż��д��󶥶ѣ��󶥶����е���ҪС�ڵ���С����
        {
        	int minNumInMinHeap = minheap.get(0);
        	if(num > minNumInMinHeap)
        	{
        		minheap.remove(0);
        		insertHeap(maxheap, minNumInMinHeap, false);//С��ֵд��󶥶�
        		insertHeap(minheap, num, true);//���ֵд��С����
        	}else
        	{
        		insertHeap(maxheap, num, false);//С��ֵд��󶥶�
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
    //����󶥶ѻ���С����
    public void insertHeap(LinkedList<Integer> arr, int num, boolean minheap)
    {
    	//���֮�����ʹ�øö��Ǹ��󶥶ѻ�С����
    	arr.add(0, num);
    	//1.�����󶥶�
        for(int i=arr.size()/2-1;i>=0;i--){
            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
            adjustHeap(arr,i,arr.size(), minheap);
        }
    }
    /**
     * �����󶥶ѣ����ǵ������̣������ڴ󶥶��ѹ����Ļ����ϣ�minheapΪtrue��С����
     * @param arr
     * @param i
     * @param length
     */
    public void adjustHeap(LinkedList<Integer> arr,int i,int length, boolean minheap){
        int temp = arr.get(i);//��ȡ����ǰԪ��i
        for(int k=i*2+1;k<length;k=k*2+1){//��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
            if(k+1<length && arr.get(k)<arr.get(k+1) ^ minheap){//������ӽ��С�����ӽ�㣬kָ�����ӽ��
                k++;
            }
            if(arr.get(k) >temp ^ minheap){//����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
            	arr.set(i, arr.get(k));
                i = k;
            }else{
                break;
            }
        }
        arr.set(i, temp);//��tempֵ�ŵ����յ�λ��
    }

    /**
     * ����Ԫ��
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
