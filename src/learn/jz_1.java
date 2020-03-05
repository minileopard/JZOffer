package learn;

public class jz_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 7;
		int[][] array = {{1,2,8,9},{4,7,10,13}};
		System.out.println(Find(target, array));
	}
	public static boolean Find2(int target, int [][] array)
	{
		if(array == null)    return false;
        int N = array.length;
        if(N == 0 || array[0].length == 0)    return false;
    	int row=0;
        int col=N-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col])
                return true;
            else if(target>array[row][col])
                row++;
            else
                col--;
        }
        
        return false;
	}
	public static boolean Find(int target, int [][] array) {
        if(array == null)    return false;
        int N = array.length;
        if(N == 0 || array[0].length == 0)    return false;
        if(target > array[N-1][N-1] || target < array[0][0])    return false;
        for(int i = 0; i < N; i++)
        {
        	System.out.println(array[i][i]);
            if(array[i][i] == target)
            {
                return true;
            }else if(array[i][i] > target)
            {
                for(int r = i; r < N; r++)
                    for(int c = 0; c < i; c++)
                    {
                        if(array[r][c] == target || array[c][r] == target)
                            return true;
                    }
            }
        }
        return false;
    }
}
