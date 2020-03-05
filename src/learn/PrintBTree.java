package learn;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
public class PrintBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n4.left = n2; n4.right = n6;
		n2.left = n1; n2.right = n3;
		n6.left = n5; n6.right = n7;
		PrintBTree bt = new PrintBTree();
		bt.Print(n1);
	}
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >();
        if(pRoot==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        queue.add(null);//用null来分割每一层
        boolean isLtoR = false;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while(!queue.isEmpty())
        {
            if(queue.element() == null)
            {
                list.add(new ArrayList<Integer>(temp));
                temp.clear();
                queue.poll();//删掉null
                
                if(!queue.isEmpty())
                    queue.add(null);//标记这一层
                
                isLtoR = !isLtoR;
            }else
            {
            	TreeNode top = queue.poll();
                if(top.left!=null)
                    queue.add(top.left);
                if(top.right!=null)
                    queue.add(top.right);
                
                if(isLtoR)
                    temp.add(top.val);
                else
                    temp.add(0, top.val);
            }
        }
        return list;
    }
}
