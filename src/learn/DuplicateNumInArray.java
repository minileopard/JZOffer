package learn;

import java.util.HashSet;

public class DuplicateNumInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length < 2)
            return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i: numbers)
        {
        	if(set.contains(i))
        	{
        		duplication[0] = i;
        		return true;
        	}else
        	{
        		set.add(i);
        	}

        }
		return false;
    }
}
