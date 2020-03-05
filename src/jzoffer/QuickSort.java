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
			quicksort(array, start, index - 1);//排左边
		}
		if(index < end)
		{
			quicksort(array, index + 1, end);//排右边
		}
	}
	
	public int partition(int[] array, int start, int end)
	{
		if(start == end)
			return start;
		int small = start - 1;
		int index = start;//选择第一个为中间数字
		swap(array, index, end);//先移动到最后方便一些
		
		for(int i = start; i < end; i++)
		{
			if(array[i] < array[end])//小的移动到左边
			{
				small++;
				swap(array, small, i);
			}
		}
		
		small++;
		swap(array, small, end);//中间数字移动回来
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
