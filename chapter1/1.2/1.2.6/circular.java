import algs4.StdOut;

public class circular
{
	public static boolean circular1(String a, String b)
	{
		return (a.length() == b.length()) && (a.concat(a).indexOf(b) >= 0);
	}
	public static void main(String[] args) 
	{
		String a = "asdfghjk";
		String b = "dfghjkas";
		boolean c = circular1(a,b);
		StdOut.println(c);
	}
}