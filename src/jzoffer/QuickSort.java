package jzoffer;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,5,3,6,4,8,7,2};
		QuickSort sort = new QuickSort();
		sort.quicksort(a, 0, a.length - 1);
		
		for(int i:a)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void quicksort(int[] array, int start, int end)
	{
		if(array == null || array.length <= 1)
			return;
		int index = partition(array, start, end);
		if(index > start)
		{
			quicksort(array, start, index - 1);//�����
		}
		if(index < end)
		{
			quicksort(array, index + 1, end);//���ұ�
		}
	}
	
	public int partition(int[] array, int start, int end)
	{
		if(start == end)
			return start;
		int small = start - 1;
		int index = start;//ѡ���һ��Ϊ�м�����
		swap(array, index, end);//���ƶ�����󷽱�һЩ
		
		for(int i = start; i < end; i++)
		{
			if(array[i] < array[end])//С���ƶ������
			{
				small++;
				swap(array, small, i);
			}
		}
		
		small++;
		swap(array, small, end);//�м������ƶ�����
		return small;
	}
	public void swap(int[] array, int s, int a)
	{
		if(s == a)
			return;
		int temp = array[s];
		array[s] = array[a];
		array[a] = temp;
	}
} 
