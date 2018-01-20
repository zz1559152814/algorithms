/************************************************
NoNoBracketConvert :
	函数，顾名思义是在没有括号的情况下进行中序算式到后序算式的转换，
然后利用了递归的思路，在每次遇见“（”使调用NoBracketConvert本身，
在遇见“）”时，返回，利用全局变量index进行现在字符串位置的定位，这
样即使是在递归的函数层中，也可以准确的确认现在循环检测的位置。

NoBracketConvert的思路是:
	遇到数字直接输出，遇到符号对四种状态进行具体分析，分别是
1.前一个是"*","/"，现在也是"*","/"   直接把本次的输出
2.前一个是"+","-"，现在也是"+","-"   输出上一次，储存本次
3.前一个是"+","-"，现在是"*","/"     把栈中所有的操作符输出
4.前一个是"*","/"，现在是"+","-"     储存本次

*************************************************/
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

	static int index = 0;

	public static int NoBracketConvert(String input){
		int 			notion = 0;
		String 			at;
		String 			at_data 	= new String();
		Stack<String> 	opera 		= new Stack<String>();
		
		for(int i=index; i<input.length(); i++){
			at = Character.toString(input.charAt(i));
			if(isDigit(at)){
				at_data += at;
			}
			else{
				StdOut.print(at_data);
				if(at.equals("*")||at.equals("/")){
					if(notion == 1)
						StdOut.print(opera.pop());	
					notion = 1;
				}
				else if(at.equals("+")||at.equals("-")){
					if(notion == 1){
						while(!opera.isEmpty()){
							StdOut.print(opera.pop());
						}
					}
					else if(notion == 2)
						StdOut.print(opera.pop());
					notion = 2;
				}
				else if(at.equals("(")){
					index = i+1;
					i = NoBracketConvert(input);
					while(!opera.isEmpty()){
						StdOut.print(opera.pop());
					}
					notion = 0;
				}
				else if(at.equals(")")){
					while(!opera.isEmpty())
						StdOut.print(opera.pop());
					return i;
				}
				if(!at.equals("("))
					opera.push(at);	
				at_data = "";
			}
		}
		StdOut.print(at_data);
		while(!opera.isEmpty()){
			StdOut.print(opera.pop());
		}
		StdOut.println();
		return -1;
	}
	public static void main(String[] args) {
		String input = new String();
		input = StdIn.readString();
		StdOut.println(input);
		NoBracketConvert(input);
	}
}
