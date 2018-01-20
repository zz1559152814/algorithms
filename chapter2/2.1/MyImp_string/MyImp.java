import mytools.drawtools;
import mytools.comparetools;
import algs4.StdDraw;
import algs4.StdIn;
import algs4.StdOut;
import algs4.Stopwatch;
import java.awt.Font;

public class MyImp{
	private static void Selection(String[] a){
		int min_index 	= 0;
		int length 		= a.length;
		String min 		= a[0];
		
		for(int i=0; i<length; i++){
			int 	j;
			for(j=i; j<length; j++){
				if(comparetools.less(a[j], min)){
					min 		= a[j];
					min_index 	= j;
				}
			}
			if(min_index != i)
				comparetools.exch(a, min_index, i);

			// drawtools.draw(a, i, i, j);
		}
	}

	private static void Insertion(String[] a){
		int 	length	=	a.length;
		for(int i=1; i<length; i++){
			int 	j;
			for(j=i; j>0&&comparetools.less(a[j], a[j-1]); j--)
				comparetools.exch(a, j, j-1);
			drawtools.draw(a, i, i, j);
		}
	}

	private static void Bubble(String[] a){
		int 	length = a.length;
		for(int i=0; i<length; i++){
			int j;
			for(j=1; j<length-i; j++){
				if(comparetools.less(a[j], a[j-1]))
					comparetools.exch(a, j, j-1);
			}
			drawtools.draw(a, i, i, j);
		}
	}

	private static void Shell(String[] a){
		int line = 0;
		int length  = a.length;
		int N		= 1;
		while(N < length/3) 
			N = 3*N + 1;

		while(N>=1){
			for(int i=N; i<length; i++){
				int j;
				for(j=i; j>N&&comparetools.less(a[j], a[j-N]); j-=N){
					comparetools.exch(a, j, j-N);
				}
				drawtools.draw(a, N, i, j);
				line++;
			}
			N/=3;	
			drawtools.footer(a);
			line++;
		}
	}

	public static void main(String[] args) {
		String  type = StdIn.readString();
		int 	size = StdIn.readInt();
       	int cnt = 0;
        
        if(type.equals("int")){
        	int[] intarray = new int[size];
        	while(!StdIn.isEmpty()){
				int   s = StdIn.readInt();
				intarray[cnt] = s;
        	}
        	cnt++;
        }
        else if(type.equals("string")){
        	String[] stringarray = new String[size];
        	while(!StdIn.isEmpty()){
				String   p = StdIn.readString();
				stringarray[cnt] = p;
        	}
        	cnt++;
        }
		
		double time;
		Stopwatch timer 	= new Stopwatch();
		//sort(a);
		time 	= timer.elapsedTime();

		StdOut.println("the size of array is:"+size);
		StdOut.println("the time used to sort is:"+time);
		StdOut.println("the average time cost is:"+time/size);

	}
}