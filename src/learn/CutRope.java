package learn;

public class CutRope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CutRope c = new CutRope();
		System.out.println(c.cutRope(2));
	}
	public int cutRope(int target) {
        //ÿ�ηֳ����Σ�ȡ���ֵ
        if(target <= 0)
            return 0;
        int[][] dp = new int[target + 1][target + 1];
        dp[1][1] = 1;
        for(int i = 2; i <= target; i++)
        {
            dp[i][i] = 1;
            dp[i][1] = i;
            for(int j = 2; j < i; j++)
            {
                //���ֵ��ǰ������
                int localmax = 0;
                for(int k = 1; k <= i/2; k++)
                {
                	//��m�ķֽⷽʽ�����ֳ�����
                	int leftHalf = j / 2, rightHalf = leftHalf;
                	if(j % 2 == 1)
                		rightHalf++;
                    int temp = dp[k][leftHalf] * dp[i - k][rightHalf];
                    localmax = Math.max(localmax, temp);
                }
                dp[i][j] = localmax;
            }
        }
        int max = 0;
        //��Ѱ��target�����ֵ����Ҫ�Ľ��
        for(int i = 2; i <= target; i++)
        {
            if(max < dp[target][i])
            {
                max = dp[target][i];
            }
        }
        return max;
    }
}
