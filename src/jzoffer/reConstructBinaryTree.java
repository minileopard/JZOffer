package jzoffer;

public class reConstructBinaryTree {
/*
 * ǰ����������ؽ�������
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		reConstructBinaryTree ob = new reConstructBinaryTree();
		TreeNode root = ob.reConstructBinaryTree(pre, in);
		ob.printBT(root);
	}
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null)
            return null;
        int prelen = pre.length;
        int inlen = in.length;
        if(prelen == 0 || inlen ==0 || prelen != inlen)
            return null;
        return recureBT(0, prelen - 1, 0, inlen - 1, pre, in);
    }
    public TreeNode recureBT(int preS, int preE, int inS, int inE
                             , int [] pre, int [] in)
    {
        int rootval = pre[preS];
        TreeNode root = new TreeNode(rootval);
        int rootindexin = 0;
        for(int i = inS; i <= inE; i++)
        {
            if(in[i] == rootval)
            {
                rootindexin = i;
                break;
            }
        }
        if(rootindexin != inS)//����������
        {
        	root.left = recureBT(preS + 1, preS + rootindexin - inS,
                    inS, rootindexin - 1, pre, in);
        }
        if(rootindexin != inE)//����������
        {
        	root.right =  recureBT(preS + rootindexin - inS + 1, preE,
                    rootindexin + 1, inE, pre, in);
        }
        return root;
    }
    void printBT(TreeNode root)
    {
    	if(root == null)
    		return;
    	printBT(root.left);
    	System.out.print(root.val + " ");
    	printBT(root.right);
    }
}
class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
