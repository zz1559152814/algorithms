import algs4.StdOut;
import algs4.StdIn;
import algs4.StdRandom;
import algs4.StdDraw;
import algs4.Stopwatch;
import mytools.MyImp;
import mytools.comparetools;

public class Merge extends MyImp{
	static int  callcnt = 0;
	static int  bottom  = 0;
	static int  jiou  = 0;
	static int[] arrays1;
	static int[] arrays2;
	static int[] temp;

	public Merge(int[] array){
		temp = new int[array.length];
		for(int i=0; i<array.length; i++)
			temp[i] = array[i];
		arrays1	= array;
		arrays2 = temp;
	}

	public static void sort(int[] a, int lo, int hi){
		// MyImp.Selection(a, lo, hi);
		MyImp.Insertion(a, lo, hi);
		// MyImp.Bubble(a, lo, hi);
		// MyImp.Shell(a, lo, hi);
	}
	public static void merge(int[] array, int lo, int mid, int hi){
		StdOut.println(lo+" "+mid+" "+hi);
		int m,n;
		m = lo;
		n = mid+1;

		if(bottom==1&&callcnt%2==jiou){
			array = arrays2;
			temp  = arrays1;
		}
		if(bottom==1&&callcnt%2!=jiou){
			array = arrays1;	
			temp  = arrays2;
		}

		// for(int i=0; i<=hi; i++)
		// 	temp[i] = array[i];

		for(int i=lo; i<=hi; i++){
			if(m>mid) 
				array[i] = temp[n++];
			else if(n>hi) 
				array[i] = temp[m++];
			else if(temp[m]>temp[n])
				array[i] = temp[n++];
			else
				array[i] = temp[m++];
		}
	}


	public static void mergesort(int[] a, int lo, int hi){
		int mid = lo + (hi-lo)/2;
		callcnt++;
		StdOut.println("i get in!   " + " " + callcnt	);

		if(hi-lo > 15){
			mergesort(a, lo, mid);
			mergesort(a, mid+1, hi);
			merge(a, lo, mid, hi);
			callcnt--;
			
			StdOut.println("i get out..." + " " + callcnt);
		}
		else{
			sort(a, lo, hi);
			bottom = 1;
			jiou = callcnt%2;
			// if(bottom==1&&callcnt%2!=jiou){
			// 	a 	 = arrays2;
			// 	temp = arrays1;
			// }
			// if(bottom==1&&callcnt%2==jiou){
			// 	a 	 = arrays1;	
			// 	temp = arrays2;
			// }

			callcnt--;
			StdOut.println("i get out..." + " " + callcnt	);
			return;
		}
	}

	public static void main(String[] args) {		
		int readin;
		int i 		= 0;
		int cnt		= StdIn.readInt();
		int[] a 	= new int[cnt];

		while(!StdIn.isEmpty()&&i<cnt){
			readin 	= StdIn.readInt();
			a[i]	= readin;
			++i;
		}

		Merge m = new Merge(a);
		double time;
		Stopwatch timer = new Stopwatch();
		m.mergesort(a, 0, a.length-1);
		time = timer.elapsedTime();
		StdOut.println(time);

		comparetools.show(a,temp);
		if(!comparetools.isorted(a))
			StdOut.println("false");	
	}
	// public static void main(String[] args) {		
	// 	// int[] a = {11,12,13,14,15,16,17};
	// 	// int[] b = {21,12,13,14,15,16,17};
	// 	// // Merge m = new Merge(a);
	// 	// // m.merge(a,0,9,19);
	// 	// // sort(a,0,9);
	// 	// // m.sort(a,0,9);
	// 	// Merge.change(a,b);

	// 	int[] a = {1,3,5,7};
	//     int[] b = {2,4,6,8};
	     
	// 	for(int i=0; i<a.length; i++){
	// 		StdOut.println(a[i]+" "+b[i]);
	// 	}
	//     int[] temp = a;
	//     a = b;
	//     b = temp;
	// 	for(int i=0; i<a.length; i++){
	// 		StdOut.println(a[i]+" "+b[i]);
	// 	}
	// }
}