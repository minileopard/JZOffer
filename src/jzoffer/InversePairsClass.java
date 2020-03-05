package jzoffer;

public class InversePairsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InversePairsClass c = new InversePairsClass();
		int[] array = {};
		System.out.println(c.InversePairs(array));
	}
	public int InversePairs(int [] array) {
		if(array == null || array.length < 2)
            return 0;
		int len = array.length;
		int[] copy = new int[len];
		for(int i = 0; i < len; i++)
		{
			copy[i] = array[i];
		}
		return recursive(array, copy, 0, len - 1);
	}
	public int recursive(int[] array, int[] copy, int start, int end)
	{
		if(start == end)
		{
			copy[start] = array[start];
			return 0;
		}
		//���������ڲ�������Լ�������֮�������ԣ���������������
		int len = (end - start) / 2;
		int leftendi = start + len, rightendi = end, count = 0, copyi = end;
		int left = recursive(copy, array, start, leftendi);//����copy��arrayʹ����һ���õ��Ǻϲ�֮�����������
		int right = recursive(copy, array, leftendi + 1, end);
		while(leftendi >= start && rightendi >= start + len + 1)
		{
			if(array[leftendi] > array[rightendi]) //���������
			{
				copy[copyi--] = array[leftendi--];//��ߴ�ѡ���
				count += rightendi - start - len;
			}else
			{
				copy[copyi--] = array[rightendi--];
			}
		}
		while(leftendi >= start)
		{
			copy[copyi--] = array[leftendi--];
		}
		while(rightendi >= start + len + 1)
		{
			copy[copyi--] = array[rightendi--];
		}
		return left + right + count;
	}
}
