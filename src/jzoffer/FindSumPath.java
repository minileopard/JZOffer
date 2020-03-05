package jzoffer;

import java.util.ArrayList;

public class FindSumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	ArrayList<ArrayList<Integer>> reslist = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> templist = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        recursive(root, 0, target);
        return reslist;
    }
    public void recursive(TreeNode root, int sum, int target)
    {
        if(root == null)
            return;
        sum += root.val;
        templist.add(root.val);
        if(root.left == null && root.right == null)//叶子节点
        {
            if(sum == target)//符合条件
            {
                reslist.add(new ArrayList<Integer>(templist));
            }
        }
        if(root.left!=null)
        {
            recursive(root.left, sum, target);
            templist.remove(templist.size() - 1);//回溯
        }
        if(root.right!=null)
        {
            recursive(root.right, sum, target);
            templist.remove(templist.size() - 1);//回溯
        }
        return;
    }
}
