package jzoffer;

public class NumberOf1Between1AndN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOf1Between1AndN x = new NumberOf1Between1AndN();
		System.out.println(x.NumberOf1Between1AndN_Solution(8));
	}
	public int NumberOf1Between1AndN_Solution(int n) {
        if(n == 0)
            return 0; 
        if(n < 10)
            return 1;
//        if(n == 10)
//        	return 2;
        int cs = n, ys, bs = 10, sum = 0;
        while(true)
        {
            cs = n / bs;
            ys = n % bs;
            
            sum += cs * bs / 10;
            if(ys / (bs / 10) == 1) //112(余数的第一位是1)
        	{
        		sum += ys % (bs / 10) + 1;
        	}else if(ys / (bs / 10) > 1)
        	{
        		sum += bs / 10;
        	}
            
            if(cs < 10)
            {
            	if( cs == 1) //132
            	{
            		sum += ys  + 1;
            	}else if( cs > 1 )
            	{
            		sum += bs;
            	}
            	break;
            }
            bs = bs * 10;
        }
        return sum;
    }
}
