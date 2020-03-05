package jzoffer;

public class RebootMoveRange {
	int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RebootMoveRange r = new RebootMoveRange();
		System.out.println(r.movingCount(8, 23, 14));
	}
	public int movingCount(int threshold, int rows, int cols)
    {
		boolean[][] flag = new boolean[rows][cols];
		recursive(threshold, 0, 0, rows, cols, flag);
        return count;
    }
	public void recursive(int k, int r, int c, int rows, int cols, boolean[][] flag)
	{
		if(r < 0 || r >= rows || c < 0 || c >= cols || flag[r][c])
			return;
		//计算下标的数位和
		int sum = 0;
		int rtemp = r, ctemp = c;
		while(rtemp > 0)
		{
			sum += rtemp % 10;
			rtemp = rtemp / 10;
		}
		while(ctemp > 0)
		{
			sum += ctemp % 10;
			ctemp = ctemp / 10;
		}
		System.out.println(r + " "+ c + " " + sum);
		if(sum <= k) //能走而且没走过
		{
			flag[r][c] = true;
			count++;
			System.out.println(count);
			recursive(k, r + 1, c, rows, cols, flag);
			recursive(k, r - 1, c, rows, cols, flag);
			recursive(k, r, c + 1, rows, cols, flag);
			recursive(k, r, c - 1, rows, cols, flag);
		}
	}
}
