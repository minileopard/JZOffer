package springRecruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class April15_hw_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();

		String[] ss = line.split(" ");
		if(ss.length != 2)
		{
			System.out.println("Fail");
			return;
		}

		String aims = ss[0];
		
		//ɾ�����һ������
		StringBuilder t = new StringBuilder(ss[1]);
		t.deleteCharAt(t.length() - 1);
		ss[1] = t.toString();
		String[] matchs = ss[1].split("],");
		int len = matchs.length;
		if(len < 1)
		{
			System.out.println("Fail");
			return;
		}
		//��ƥ��ġ����ڲ������ó���
		List<String> list = new ArrayList<>();
		for(int i = 0 ; i < len; i++)
		{
			String[] temp = matchs[i].split("\\[");
			if(temp.length != 2)
			{
				System.out.println("Fail");
				return;
			}
			if(temp[0].equals(aims))
			{
				list.add(temp[1]);
			}
		}
		//Ū�ɶ�Ӧ��ʽ
		if(list.size() == 0)
		{
			System.out.println("Fail");
			return;
		}
		for(int i = 0; i < list.size(); i++)
		{
			String[] temp = list.get(i).split(",");
			StringBuilder result = new StringBuilder();
			for(String s : temp)
			{
				String[] tt = s.split("=");
				if(tt.length!=2)
				{
					System.out.println("Fail");
					return;
				}
				result.append(tt[1] + " ");
			}
			result.deleteCharAt(result.length()-1);
			result.append("\r\n");
			System.out.print(result);
		}
	}

}
