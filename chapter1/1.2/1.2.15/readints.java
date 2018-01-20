import algs4.In;
import algs4.StdOut;

public class readints 
{
	public static int[] readint(String name)
	{
		In in = new In(name);
		String all = in.readAll();
		StdOut.println(all);
		String[] splits = all.split("\\s+");
		int[] ints = new int[splits.length];
		for(int i=0; i<splits.length; i++)
			ints[i] = Integer.parseInt(splits[i]);
		return ints;
	}
	public static void main(String[] args) {
		readint(args[0]);
	}
}