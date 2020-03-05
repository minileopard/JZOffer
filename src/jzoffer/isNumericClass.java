package jzoffer;

public class isNumericClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isNumericClass c = new isNumericClass();
		System.out.println(c.isNumeric("12e+4.3".toCharArray()));
	}
	public boolean isNumeric(char[] str) {
		if(str == null)
			return false;
		int len = str.length;
		if(len == 0)
			return false;
		int num_e = 0, num_ad = 0, num_p = 0, index_e = -1, index_p = -1;
		for(int i = 0; i < len; i++)
		{
			if(str[i] == 'E' || str[i] == 'e')
			{
				num_e++;
				index_e = i;
			}
			else if(str[i] == '+' || str[i] == '-')
			{
				num_ad++;
			}
			else if(str[i] == '.')
			{
				num_p++;
				index_p = i;
			}else if(str[i] < '0' || str[i] > '9')////存在其他字符
			{
				return false;
			}
			
		}
		if(num_e > 1 || num_ad > 2 || num_p > 1)
			return false;
		if(num_e == 0)//无e
		{
			//点不在第一个，+-有就在第一个且只存在一个
			if(str[0] == '.')
				return false;
			if(num_ad == 2 || (num_ad == 1 && str[0] != '+' && str[0]!= '-'))
				return false;
		}else//有e
		{
			//有点的话点不在e右边，+-在左右两边第一个，左右两边都要有数
			if(num_p == 1 && index_p > index_e)
			{
				return false;
			}
			if(index_e == 0 || index_e == len - 1)
				return false;
			if(num_ad == 2 && ((str[0]!='+' && str[0]!='-') || (str[index_e + 1]!='+' && str[index_e + 1]!='-')))
			{
				return false;
			}
			if(num_ad == 1 && ((str[0]!='+' && str[0]!='-') && (str[index_e + 1]!='+' && str[index_e + 1]!='-')))
			{
				return false;
			}
		}
		return true;
        
    }
}
