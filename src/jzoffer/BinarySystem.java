package jzoffer;

/*
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class BinarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -2147483648;//2147483648
		//位运算的解法,判断每一位是不是1
		int count = 0;
		int flag = 1;
		while(flag!=0)
		{
			if((n & flag) != 0)
				count++;
			flag = flag << 1;
			//System.out.println(flag);
		}
		System.out.println(count);
		System.out.print("res: " + new BinarySystem().NumberOf1(n));
	}
	public int NumberOf1(int n) {
		if(n == 0)
			return 0;
		int num = n, count = 0;
		int isMinus = 0;//是负数的话加上符号位的1
		if(n < 0)
		{
			//求负数补码对应哪个数的原码
			num = (int)(Math.pow(2, 31) + n);
			isMinus = 1;
		}
		System.out.println(num);
		while(num!=0)
		{
			if(num%2 == 1)
				count ++;
			num = num /2;
		}
		return count + isMinus;
    }
}
