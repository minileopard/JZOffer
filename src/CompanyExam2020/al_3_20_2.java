package CompanyExam2020;

public class al_3_20_2 {
	public static int mincount = Integer.MAX_VALUE;
	//ʹ��10ά��dp����״̬,�ƺ���̫�а�����
	public static int[][][][][][][][][][] dp = new int[5][5][5][5][5][5][5][5][5][5];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,2,2,2,1,1};
		dfs(nums, 0);
		System.out.println(mincount);
		
		System.out.println(dfs_cache(nums));
		
	}
	//����2��10άdp�������Ƶ�״̬�������ظ�����
	public static int dfs_cache(int[] nums)
	{
		//�ж��Ƿ��л���
		int cached = dp[nums[0]][nums[1]][nums[2]][nums[3]][nums[4]][nums[5]][nums[6]][nums[7]][nums[8]][nums[9]];
		if(cached != 0)
		{
			return cached;
		}
		//�ж��Ƿ񶼳�����
		int len = nums.length;
		boolean flag = false;
		System.out.println(cached);
		for(int i = 0; i < len; i++)
		{
			System.out.print(nums[i] + " ");
			if(nums[i] != 0)
			{
				flag = true;
				break;
			}
		}
		System.out.println();
		if(!flag)
		{
			return 0;
		}
			
		//ѡ���ȳ�˳��
		for(int i = 0; i < len - 4; i++)
		{
			if(nums[i] > 0 && nums[i+1] > 0 && nums[i+2] > 0 && nums[i+3] > 0 && nums[i+4] > 0)
			{
				for(int j = 0; j < 5; j++)
					nums[i + j]--;
				int temp = dfs_cache(nums) + 1;
				if(temp < cached)
					cached = temp;
				for(int j = 0; j < 5; j++)
					nums[i + j]++;
			}
		}
		//�ٳ�����
		for(int i = 0; i < len; i++)
		{
			if(nums[i] > 1)
			{
				nums[i] -= 2;
				int temp = dfs_cache(nums) + 1;
				if(temp < cached)
					cached = temp;
				nums[i] += 2;
			}
		}
		//�ٳ���
		for(int i = 0; i < len; i++)
		{
			if(nums[i] > 0)
			{
				nums[i]--;
				int temp = dfs_cache(nums) + 1;
				if(temp < cached)
					cached = temp;
				nums[i]++;
			}
		}
		return cached;
	}
	//����1����������+��֦
	public static void dfs(int[] nums, int count)
	{
		int len = nums.length;
		boolean flag = false;
		for(int i = 0; i < len; i++)
		{
			if(nums[i] != 0)
			{
				flag = true;
				break;
			}
		}
		if(!flag)
		{
			mincount = Math.min(mincount, count);
			return;
		}
		if(count+1 >= mincount)
			return;
		
			
		//ѡ���ȳ�˳��
		for(int i = 0; i < len - 4; i++)
		{
			if(nums[i] > 0 && nums[i+1] > 0 && nums[i+2] > 0 && nums[i+3] > 0 && nums[i+4] > 0)
			{
				for(int j = 0; j < 5; j++)
					nums[i + j]--;
				dfs(nums, count + 1);
				for(int j = 0; j < 5; j++)
					nums[i + j]++;
			}
		}
		//�ٳ�����
		for(int i = 0; i < len; i++)
		{
			if(nums[i] > 1)
			{
				nums[i] -= 2;
				dfs(nums, count + 1);
				nums[i] += 2;
			}
		}
		//�ٳ���
		for(int i = 0; i < len; i++)
		{
			if(nums[i] > 0)
			{
				nums[i]--;
				dfs(nums, count + 1);
				nums[i]++;
			}
		}
	}
}
