import algs4.Stack;
import algs4.StdOut;
import algs4.StdIn;

public class Parenttheses{
	public static boolean equalrule(String a, String b){
		if(a.equals("(")&&b.equals(")"))
			return true;
		else if(a.equals("{")&&b.equals("}"))
			return true;
		else if(a.equals("[")&&b.equals("]"))
			return true;
		else return false;
	}

	public static void main(String[] args) {
		Stack<String> lopera = new Stack<String>();
		Stack<String> ropera = new Stack<String>();

		String in = StdIn.readString();
		String at;
		for(int i=0; i<in.length(); i++){
			at = Character.toString(in.charAt(i));
			if(at.equals("[")||at.equals("(")||at.equals("{"))
				lopera.push(at);
			else
				ropera.push(at);
		}
		if(lopera.size() != ropera.size())
			StdOut.println("false1");
		else{
			while(!lopera.isEmpty()){
				if(!equalrule(lopera.pop(), ropera.pop())){
					StdOut.println("false2");
					return;
				}
			}
			StdOut.println("true");
			return;
		}
	}
}