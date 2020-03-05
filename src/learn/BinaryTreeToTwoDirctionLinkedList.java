package learn;

public class BinaryTreeToTwoDirctionLinkedList {
	TreeNode lastNode = null;
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
		
		BinaryTreeToTwoDirctionLinkedList bt = new BinaryTreeToTwoDirctionLinkedList();
		bt.Convert(n4);
	}
	public TreeNode Convert(TreeNode pRootOfTree) {
        recursive(pRootOfTree);
        //找到头
        while(lastNode!=null && lastNode.left!=null)
            lastNode = lastNode.left;        
        return lastNode;
    }
    public void recursive(TreeNode root)
    {
        if(root == null)
            return;
        //左边指向lastnode，右边指向current
        TreeNode current = root;
        if(current.left!=null)
        {
            recursive(current.left);
        }
        current.left = lastNode;
        if(lastNode!=null)
            lastNode.right = current;
        lastNode = current;
        if(current.right!=null)
        {
            recursive(current.right);
        }
    }
}
