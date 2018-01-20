import algs4.StdOut;
import algs4.StdIn;
import algs4.Stack;
import java.lang.Character;
import algs4.Queue;

public class InfixToPostfix{
	public static boolean isDigit(String in){
		for(int i=0; i<in.length(); i++){
			if(!Character.isDigit(in.charAt(i)))
				return false;
		}
		return true;
	}

	public static void myprint(Stack<String> a){
		Stack<String>	all			= new Stack<String>();
		for(String ac:a){
			 all.push(ac);
		}
		while(!all.isEmpty()){
			StdOut.print(all.pop());
		}
		StdOut.println();
	}

	public static void NoBracketConvert(String input, int index){
		int 			notion = 0;
		String 			at;
		String 			at_data 	= new String();
		Stack<String> 	opera 		= new Stack<String>();
		// Stack<String> 	data  		= new Stack<String>();

		// StdOut.print(input);
		for(int i=index; i<input.length(); i++){
			at = Character.toString(input.charAt(i));
			if(isDigit(at)){
				at_data += at;
			}
			else{
				// data.push(at_data);
				StdOut.print(at_data);
				if(at.equals("*")||at.equals("/")){
					if(notion == 1){
						// while(!opera.isEmpty()){
						// data.push(opera.pop());
						StdOut.print(opera.pop());
						// }
					}					
					notion = 1;
				}
				else{
					if(notion == 1){
						while(!opera.isEmpty())
						// data.push(opera.pop());
						StdOut.print(opera.pop());
					}
					else if(notion == 2){
						// data.push(opera.pop());
						StdOut.print(opera.pop());
					}
					notion = 2;
				}
				opera.push(at);	
				at_data = "";
			}
			// myprint(data);
		}
		// data.push(at_data);
		StdOut.print(at_data);
		while(!opera.isEmpty()){
				// data.push(opera.pop());	
				StdOut.print(opera.pop());
		}
		StdOut.println();
		// myprint(data);
	}
	public static void main(String[] args) {
		String input = new String();
		input = StdIn.readString();
		NoBracketConvert(input,0);
	}
}
// 	public static void main(String[] args) {
// 		String in 		= StdIn.readString();
// 		String at 		= new String();
// 		String data		= new String();
// 		String opera	= new String();

// 		// for(int i=0; i<in.length(); i++){
// 		// 	at = Character.toString(in.charAt(i));
// 		// 	if()
// 		// }
// 		NoBracketConvert(in);
// 	}
// }
