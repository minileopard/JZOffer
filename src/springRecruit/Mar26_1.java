package springRecruit;

import java.util.Scanner;

public class Mar26_1 {
	public static int modNum = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		//C(n,r) r��0��n��֮��Ϊ2^n,c(n,0) = 1;
		//������ϵļ������ʣ��ɵý��Ϊ n*2^(n-1)
		//����̫Ư���ˣ�������
		System.out.println(fun2(N));
	}

	static long fun2(int N) {
	    if(N == 0) {
	        return 1;
	    }
	    if(N == 1) {
	        return 2;
	    }
	    long res = fun2(N/2);
	    if(N%2 == 0) {
	        return (res*res)%1000000007;
	    }
	    else {
	        return (2*(res*res)%1000000007)%1000000007;
	    }
	}
}
