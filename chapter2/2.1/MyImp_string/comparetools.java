package mytools;

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


}