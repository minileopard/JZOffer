package jzoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumberClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintMinNumberClass c = new PrintMinNumberClass();
		int[] numbers = {3, 32, 321};
		System.out.println(c.PrintMinNumber(numbers));
	}
	
	public String PrintMinNumber(int [] numbers) {
		StringBuilder result = new StringBuilder();
		if(numbers == null)
			return result.toString();
		//自定义比较大小类
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < numbers.length; i++)
		{
			list.add(numbers[i]);
		}
		Collections.sort(list, new Comparator<Integer>(){

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				//自己定义相等，大于，小于
				if(arg0 == arg1)
					return 0;
				String a0 = arg0.toString(), a1 = arg1.toString();
				int len0 = a0.length(), len1 = a1.length(), i0 = 0, i1 = 0;
				int max = Math.max(len0, len1);
				boolean res = true;
				while(max > 0)
				{
					if(a0.charAt(i0) > a1.charAt(i1))
					{
						break;
					}
					else if(a0.charAt(i0) < a1.charAt(i1))
					{
						res = false;
						break;
					}
					i0++;
					i1++;
					if(i0 > len0 - 1)
						i0 = len0 - 1;
					if(i1 > len1 - 1)
						i1 = len1 - 1;
					max--;
				}
				
				return res ? 1 : -1;//前面大返回1，前面小返回-1
			}
			
		});
		for(int i :list)
		{
			result.append(Integer.toString(i));
		}		
		return result.toString();
		
    }
}
