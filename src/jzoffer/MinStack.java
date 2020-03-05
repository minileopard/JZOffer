package jzoffer;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack s = new MinStack();
		s.push(1);
		s.push(2);
		s.push(-1);
		s.pop();
		System.out.println(s.top());
		System.out.println(s.min());
	}
	Stack<Integer> s = new Stack<Integer>();
    LinkedList<Integer> sortedlist = new LinkedList<Integer>();//ÉýÐò¶ÓÁÐ
    public void push(int node) {
        s.push(node);
        int i = 0;
        for( ; i < sortedlist.size(); i++)
        {
            if(node <= sortedlist.get(i))
            {
                sortedlist.add(i, node);
                break;
            }
        }
        if(i == sortedlist.size())
        {
        	sortedlist.add(node);
        }
    }
    
    public void pop() {
        int temp = s.pop();
        for(int i = 0; i < sortedlist.size(); i++)
        {
        	if(sortedlist.get(i) == temp)
        	{
        		sortedlist.remove(i);
        	}
        }
    }
    
    public int top() {
		return s.peek();
        
    }
    
    public int min() {
    	if(sortedlist.size() > 0)
    		return sortedlist.get(0);
    	else 
    		return 0;
    }
}
