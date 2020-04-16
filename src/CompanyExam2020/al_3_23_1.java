package CompanyExam2020;

public class al_3_23_1 {
	/*
	 * https://www.nowcoder.com/discuss/389640
	 * ��һ�⣺�������������ʽC(n,0) + *** + C(n,n) = 2 ^ n
	 */
	public static int mod = (int)1e9 + 7;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cal(mod));
	}
	
	public static int cal(int n)
	{
		if(n == 0)
			return 1;
		if(n == 1)
			return 2;
		double half = cal(n >> 1) % mod;
		int full = (int) ((half * half) % mod);
		if((n & 1) == 0)
		{
			return full;
		}else
		{
			return (2*full) % mod;
		}
	}
	
}
