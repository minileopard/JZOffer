package learn;

public class reOrderArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,9};
		new reOrderArray().reOrderArray(array);
		for(int i: array)
        	System.out.print(i + " ");
        System.out.println();
	}

	public void reOrderArray(int [] array) {
        if(array == null)
            return ;
        int len = array.length;
        int[] temp = new int[len];
        //奇数从前到后，偶数从后到前
        int index = 0;
        for(int i = 0; i < len; i++)
        {
            if((array[i] & 0x1) == 1)//奇数
            {
                temp[index++] = array[i];
            }
        }
        index = len - 1;
        for(int i = len - 1; i >= 0; i--)
        {
            if((array[i] & 0x1) == 0)//偶数
            {
                temp[index--] = array[i];
            }
        }
        for(int i = 0; i < len; i ++)
        	array[i] = temp[i];
    }
}
