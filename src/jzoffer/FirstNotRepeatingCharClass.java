package jzoffer;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNotRepeatingCharClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstNotRepeatingCharClass c = new FirstNotRepeatingCharClass();
		System.out.println(c.FirstNotRepeatingChar("aabcdbde"));
	}
	public int FirstNotRepeatingChar(String str) {
		if(str == null || str.length() == 0)
			return -1;
		Map<Character, Integer> map = new LinkedHashMap<>();//���ظ����ַ��Ͷ�Ӧ���±�
		Set<Character> duplicateSet = new HashSet<>();//�ظ����ַ�λ��
		for(int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if(map.containsKey(c))//���ظ������ظ��ַ�����
			{
				map.remove(c);
				duplicateSet.add(c);
			}
			else if(!duplicateSet.contains(c) && !map.containsKey(c))//������ظ�
			{
				map.put(c, i);
			}			
		}
		Entry<Character, Integer> e = map.entrySet().iterator().next();
		System.out.println(e.getKey());
		if(map.size() == 0)
			return -1;
		else
			return map.entrySet().iterator().next().getValue();
    }
}
