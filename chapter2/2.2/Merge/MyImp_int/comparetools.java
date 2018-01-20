package mytools;
import algs4.StdOut;
public class comparetools{
	public static void exch(String[] a, int i, int j) {
        String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is v < w ?
    public static boolean less(String v, String w) {
        return v.compareTo(w) < 0;
    }


	public static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is v < w ?
    public static boolean less(int v, int w) {
        return v < w;
    }

    public static boolean isorted(int[] a){
        for(int i=0; i<a.length-1; i++){
            if(a[i+1] < a[i])
                return false;
        }
        return true;
    }

    public static void show(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            StdOut.println(a[i]+" "+b[i]);
        }
    }
}
