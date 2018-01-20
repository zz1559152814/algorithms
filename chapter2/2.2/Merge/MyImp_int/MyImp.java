package mytools;
import mytools.drawtools;
import mytools.comparetools;
import algs4.StdDraw;
import algs4.StdIn;
import algs4.StdOut;
import algs4.Stopwatch;
import java.awt.Font;

public class MyImp{
	public static void Selection(String[] a, int lo, int hi){
		int min_index 	= lo;
		int length 		= hi - lo + 1;
		String min 		= a[lo];
		
		for(int i=lo; i<hi; i++){
			int 	j;
			for(j=i; j<hi; j++){
				if(comparetools.less(a[j], min)){
					min 		= a[j];
					min_index 	= j;
				}
			}
			if(min_index != i)
				comparetools.exch(a, min_index, i);
		}
	}

	public static void Insertion(String[] a, int lo, int hi){
		for(int i=lo+1; i<=hi; i++){
			int 	j;
			for(j=i; j>lo&&comparetools.less(a[j], a[j-1]); j--)
				comparetools.exch(a, j, j-1);
		}
	}

	public static void Bubble(String[] a, int lo, int hi){
		int 	length = hi - lo + 1;
		for(int i=0; i<length; i++){
			int j;
			for(j=lo+1; j<hi-i; j++){
				if(comparetools.less(a[j], a[j-1]))
					comparetools.exch(a, j, j-1);
			}
		}
	}

	public static void Shell(String[] a, int lo, int hi){
		int length  = hi - lo + 1;
		int N		= 1;
		while(N < length/3) 
			N = 3*N + 1;

		while(N>=1){
			for(int i=lo+N; i<=hi; i++){
				int j;
				for(j=i; j>=lo+N&&comparetools.less(a[j], a[j-N]); j-=N){
					comparetools.exch(a, j, j-N);
				}
			}
			N/=3;	
		}
	}

	public static void Selection(int[] a, int start, int end){
		int min_index 	= 0;
		int length 		= a.length;
		int min 		= a[0];
		
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
		}
	}

	public static void Insertion(int[] a, int lo, int hi){
		for(int i=lo+1; i<=hi; i++){
			int 	j;
			for(j=i; j>lo&&comparetools.less(a[j], a[j-1]); j--)
				comparetools.exch(a, j, j-1);
		}
	}

	public static void Bubble(int[] a, int lo, int hi){
		int 	length = hi - lo + 1;
		for(int i=0; i<length; i++){
			int j;
			for(j=lo+1; j<hi-i; j++){
				if(comparetools.less(a[j], a[j-1]))
					comparetools.exch(a, j, j-1);
			}
		}
	}

	public static void Shell(int[] a, int lo, int hi){
		int line = 0;
		int length  = hi - lo + 1;
		int N		= 1;
		while(N < length/3)
			N = 3*N + 1;

		while(N>=1){
			for(int i=lo+N; i<=hi; i++){
				int j;
				for(j=i; j>=lo+N&&comparetools.less(a[j], a[j-N]); j-=N){
					comparetools.exch(a, j, j-N);
				}
			}
			N/=3;	
		}
	}
}