package learn;

import java.util.LinkedList;
import java.util.Queue;
import java.lang.StringBuilder;
public class SerializeBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n4.left = n2; n4.right = n6;
		n2.left = n1; n2.right = n3;
		n6.left = n5; n6.right = n7;
		n5.right = n8;
		SerializeBTree sbt = new SerializeBTree();
		//序列化一次
		String s = sbt.Serialize(n4);
		System.out.println(s);
		//反序列化，再序列化
		String s1 = sbt.Serialize(sbt.Deserialize(s));
		System.out.println(s1);
	}
	String Serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode top = queue.poll();
            if(top!=null)
            {
            	sb.append((char)(top.val + '0'));
            	queue.add(top.left);
            	queue.add(top.right);
            }else
            {
            	sb.append('#');
            }
        }
        
        return sb.toString();
    }
    
    TreeNode Deserialize(String str) {
    	if(str == null || str.length() == 0)
    		return null;
    	int index = 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	TreeNode root = new TreeNode((int)(str.charAt(index) - '0'));
    	queue.add(root);
    	while(index < str.length() - 2)
    	{
    		TreeNode temp = queue.poll();
    		TreeNode left = null;
    		TreeNode right = null;
    		//左右子树
    		index++;
    		if(str.charAt(index) != '#')
    		{
    			left = new TreeNode((int)(str.charAt(index) - '0'));
    			queue.add(left);
    		}
    		
    		index++;
    		if(str.charAt(index) != '#')
    		{
    			right = new TreeNode((int)(str.charAt(index) - '0'));
    			queue.add(right);
    		}
    		temp.left = left;
    		temp.right = right;
    		
    	}
		return root;
    }
}
