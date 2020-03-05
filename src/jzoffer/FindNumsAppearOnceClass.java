package jzoffer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class FindNumsAppearOnceClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindNumsAppearOnceClass c = new FindNumsAppearOnceClass();
		int[] num1 = new int[1], num2 = new int[1];
		int[] array = {1,1,2,3,4,2,3,5,5,7};
		c.FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + " " + num2[0]);
	}
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2)
            return;
        Set<Integer> s = new HashSet<>();
        for(int i: array)
        {
        	if(s.contains(i))
        	{
        		s.remove(i);
        	}else
        	{
        		s.add(i);
        	}
        }
        if(s.size() == 2)
        {
        	Iterator it = s.iterator();
        	num1[0] = (int)it.next();
        	num2[0] = (int)it.next();
        }        
    }
}
