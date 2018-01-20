import algs4.StdRandom;
import algs4.StdOut;

public class arraygeneration{
	public static void main(String[] args) {
		int N = 60000;
		int cnt = Integer.parseInt(args[0]);
		StdOut.println(cnt);

		int num;
		while(cnt>0){
			num = StdRandom.uniform(N);
			StdOut.println(num);			
			cnt--;
		}
	}
}