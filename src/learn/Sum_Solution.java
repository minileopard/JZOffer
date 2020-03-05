package learn;

public class Sum_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum_Solution c = new Sum_Solution();
		System.out.println(c.Sum_Solution(5));
	}
	 public int Sum_Solution(int n) {
        //使用构造函数来实现加法
        if(n == 0)
            return 0;
        Temp[] t = new Temp[n];
        return Temp.sum;
    }
}
class Temp{
    static int sum = 0;
    static int n = 0;
    public Temp(){
        n++;
        System.out.println("n: " + n);
        sum+=n;
        
    }
}