import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Chap14Problems {

	public static void main(String[] args) {
//		Stack <Integer> stack = new Stack<Integer>();
//		
//		stack.push(100); // push adds to stack, first in last out.
//		stack.push(200);
//		System.out.println(stack);
//		
//		stack.pop();// pop takes away last thing pushed to stack, first in last out.
//		System.out.println(stack);
//		
//		System.out.println(stack.peek()); // peek shows you whatever value is on top of stack, last thing pushed to stack.
//		
//		System.out.println(stack.empty());// returns boolean true if stack is empty.
//		
//		
		Queue <Integer> que = new LinkedList<Integer>(); // queues are first in first out structure.
		que.add(100); // adds to back of que.
		que.add(200);
		que.add(300);
		que.add(400);
		que.add(500);
		que.add(600);
		que.add(700);
		que.add(800);
		que.add(900);
		que.add(1000);
		
		//que.remove(que); // removes item from front of que.
		
		Stack <Integer> test = new Stack<Integer>();
		test.push(42);
		test.push(33);
		test.push(-17);
		System.out.println(test);
		mirImage(test);
		System.out.println(test);
		
		System.out.println(que);
		cuts(que,5);
		System.out.println(que);

	}
	
	public static Stack<Integer> mirImage(Stack<Integer> x){
		Stack<Integer> temp = new Stack<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		for(int i = x.size();i>0;i--){
			d.add(x.peek());
			x.pop();
		}
		for(int i=d.size()-1;i>=0;i--){
			x.push(d.get(i));
		}
		for(int i=0;i<d.size();i++){
			x.push(d.get(i));
		}
		return x;
	}

	public static Queue<Integer> cuts(Queue<Integer> que,int num){
		ArrayList <Integer> temp = new ArrayList<Integer>();
		while(que.size()>0){
			temp.add(que.remove());
		}
		int tempNum = temp.get(num-1);
		temp.remove(num-1);
		que.add(tempNum);
		for(int element:temp){
			que.add(element);
		}
		return que;
	}
}

// (((10+2)*7)-(3+9)) Is a fully parenthesized in-fix expression A O B. ex.) 10 + 2.
// needs to be converted to a post-fix expression A B O to make it convenient for computer to calculate. ex.) 10 2 +.
// A is first value, B is second value, O is the operation.
// 10 2 + 7 * 3 9 + - (Post-fix expression)
// Now when looking at this any values are added to a stack and when an operator is found pop the stack twice and use operator
//on the two values.

//More info on stacks and ques in chapter 14 of building java textbook.