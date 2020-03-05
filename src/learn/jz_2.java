package learn;

public class jz_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s = new StringBuffer("we are family ");
		System.out.println(replaceSpace(s));
		
	}
	public static String replaceSpace(StringBuffer str) {
    	String aim = "%20";
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == ' ')
            {
                str.replace(i,i + 1, aim);
            }
        }
        return str.toString();
    }
}
