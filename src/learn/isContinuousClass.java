package learn;

import java.util.Arrays;

public class isContinuousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isContinuousClass c = new isContinuousClass();
		int[] numbers = {2,3,0,0,6};
		System.out.println(c.isContinuous(numbers));
	}
	public boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length != 5)
			return false;
		Arrays.sort(numbers);
		int count = 0;//统计大小王的个数
		int start = 0;//除掉大小王的开始的地方ww
		while(numbers[start] == 0)
		{
			count++;
			start++;
		}
		int pre = numbers[start];
		for(int i = start + 1; i < 5; i++)
		{
			count -= numbers[i] - pre - 1;
			pre = numbers[i];
		}
		return count >= 0 ? true : false;
    }
}
