import algs4.Stack;
import algs4.StdIn;
import algs4.StdOut;
import java.util.Iterator;

public class evaluate{
	public static void main(String[] args) {
		String input = new String();
		input = StdIn.readString();

		char at;
		String at_data = "";
		Stack<String>	opera	= new Stack<String>();
		Stack<Double>	data	= new Stack<Double>();

		// for(int i=input.length()-1; i=0; i--){
		for(int i=0; i<input.length(); i++){
			at = input.charAt(i);
			if(Character.isDigit(at)){
				at_data += at;
			}
			else{
				if(at_data!=""){
					data.push(Double.parseDouble(at_data));
					at_data = "";
				}

				if(at==(')')){
					String operation = opera.pop();
					double valus = data.pop();
					if(operation.charAt(0)=='+')
							data.push(data.pop() + valus);
					else if(operation.charAt(0)=='-')
							data.push(data.pop() - valus);
					else if(operation.charAt(0)=='*')
							data.push(data.pop() * valus);
					else if(operation.charAt(0)=='/')
							data.push(data.pop() / valus);
				}
				else if(at==('+')||at==('-')||at==('*')||at==('/'))
					opera.push(Character.toString(at));
			}
		}

		StdOut.println(data.pop());
		for(Iterator iter=opera.iterator(); iter.hasNext();){
					StdOut.println(iter.next());
				}
	}
}		
