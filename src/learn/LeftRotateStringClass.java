package learn;

public class LeftRotateStringClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String LeftRotateString(String str,int n) {
        if(str == null)
            return null;
        int len = str.length();
        if(len < 2 || n % len == 0)
            return str;
        n = n % len;
        String left = new String(str.substring(0, n));
        StringBuilder newstr = new StringBuilder(str);
        for(int i = n; i < len; i++)
        {
            newstr.setCharAt(i - n, newstr.charAt(i));
        }
        for(int i = len - n; i < len; i++)
        {
            newstr.setCharAt(i, left.charAt(i - len + n));
        }
        return newstr.toString();
    }
}
