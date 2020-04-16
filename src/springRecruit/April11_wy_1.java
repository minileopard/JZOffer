package springRecruit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class April11_wy_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] newUser = new int[n][n];
		int[][] oldUser = new int[n][n];
		
		for(int i = 0; i < n; i++)
		{
			int index = sc.nextInt();
			for(int j = 0; j < n; j++)
			{
				newUser[index - 1][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			int index = sc.nextInt();
			for(int j = 0; j < n; j++)
			{
				oldUser[index - 1][j] = sc.nextInt();
			}
		}
		sc.close();
		
		HashMap<Integer, Integer> match = new HashMap<>();
		int[] index = new int[n];
		for(int i = 0; i < n; i++)
		{
			for(int j = index[i]; j < n; j++)
			{
				index[i]++;
				if(!match.containsKey(newUser[i][j]))
				{
					match.put(newUser[i][j], i + 1);
					System.out.println("put" + newUser[i][j]+ " " +(i+1));
					break;
				}else
				{
					//�ҵ���λ���û���ͻ��
					int v = match.get(newUser[i][j]);
					//�������û����Ǹ��ʺ�
					int result = 0;
					for(int k = 0; k < n; k++)
					{
						if(oldUser[newUser[i][j] - 1][k] == i + 1)
						{
							result = i+1;
							break;//�ҵ���һ��ƥ���
						}else if(oldUser[newUser[i][j] - 1][k] == v)
						{
							result = v;
							break;//�ҵ���һ��ƥ���
						}
					}
					match.put(newUser[i][j], result);
					System.out.println("put" + newUser[i][j]+ " " + result);
					//ȡ����ǰ���
					if(match.get(newUser[i][j]) == i + 1)
					{
						i = v - 2;
//						index[v-1]++;
						break;
					}
				}
			}
			
		}
		
		
		int[] result = new int[n];
		for(Entry<Integer, Integer> e : match.entrySet())
		{
			result[e.getValue() - 1] = e.getKey();
			System.out.println(e.getKey() + " " + e.getValue());
		}
		
//		for(int i = 0; i < n; i++)
//		{
//			System.out.println(i+1 + " " + result[i]);
//		}
//		
	}

}

