package ZT_ByteDance;

import java.util.Scanner;

public class Ques2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N, D, count = 0, modx = 99997867;
		N = sc.nextInt();
		D = sc.nextInt();
		if(N < 3)
			return;
		int[] zb = new int[N];
		for(int i = 0; i < N; i++)
			zb[i] = sc.nextInt();
		sc.close();
		for (int i = 0,j = 0; i<N; i++){
        	//��Ϊ�������ع������i>=2��ʱ��ȡdist[2]�ǵ������ع�
        	//��ʱ��j=0��dist[i]-dist[j]>D�ǱȽ��������Զ�ľ���
 
            while (i >= 2 && (zb[i] - zb[j]) > D)
                j++;
            //�������С�ڵ���D��ʱ�򣬸�����һ
            int n = i - j;
            n = n * (n - 1);
            n = n >> 1;
            count += n;
            if(count >= modx)
            	count %= modx;
        }
		System.out.println(count);
	}
}
