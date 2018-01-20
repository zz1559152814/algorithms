import algs4.StdOut;
import algs4.StdIn;
import algs4.Stack;
import java.lang.Character;
import algs4.Queue;

public class EvaluatePostfix{
	public static void main(String[] args) {
		int 	lvaule, rvaule;
		String 	opera;
		String 	input 				=	new String();
		Stack<Integer>		stack 	=	new Stack<Integer>();
		Queue<Character>	queue 	=	new Queue<Character>();

		input = StdIn.readString();

		for(int i=0; i<input.length(); i++){
			String at = Character.toString(input.charAt(i));
			if(Character.isDigit(input.charAt(i)))
				stack.push(Integer.parseInt(at));
			else{
				rvaule = stack.pop();
				lvaule = stack.pop();
				opera  = at; 

				if 		(opera.equals("+")) 			stack.push(lvaule+rvaule);
				else if (opera.equals("-"))		 		stack.push(lvaule-rvaule);
				else if (opera.equals("*"))		 		stack.push(lvaule*rvaule);
				else if (opera.equals("/"))		 		stack.push(lvaule/rvaule);
			}
		}
		StdOut.println(stack.pop());
	}
}