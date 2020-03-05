package learn;

public class PathInMatrix {
	boolean hasPath = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathInMatrix path = new PathInMatrix();
		String matrix = "A";
		String str = "A";
		int rows = 1;
		int cols = 1;
		System.out.println(path.hasPath(matrix.toCharArray(), rows, cols, str.toCharArray()));
	}
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
		if(matrix == null || str == null)
			return false;
		if(rows <= 0 || cols <= 0)
			return false;
		if(str.length == 0)
			return true;
		char[][] matrixReshape = new char[rows][cols];
		int index = 0;
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				matrixReshape[i][j] = matrix[index++];
			}
		}
		boolean[][] flag = new boolean[rows][cols];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				recursive(matrixReshape, flag, i, j, 0, str);
			}
		}
		return hasPath;
    }
	public void recursive(char[][] matrix, boolean[][] flag, int row, int col, int matchindex, char[] str)
	{
		if(row >= matrix.length || row < 0 || col < 0 || col >= matrix[0].length)//出范围了
			return;
		if(!flag[row][col] && matrix[row][col] == str[matchindex++])//没有访问过而且当前字符相同
		{
			if(matchindex == str.length)
			{
				hasPath = true;
				return;
			}
			flag[row][col] = true;//设置以及访问了
			recursive(matrix, flag, row + 1, col, matchindex, str);//下
			recursive(matrix, flag, row - 1, col, matchindex, str);//上
			recursive(matrix, flag, row, col + 1, matchindex, str);//右
			recursive(matrix, flag, row, col - 1, matchindex, str);//左
			flag[row][col] = false;
		}
	}
}
