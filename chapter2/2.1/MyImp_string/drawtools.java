package mytools;


import java.awt.Font;
import algs4.StdDraw;
import algs4.StdOut;
public class drawtools {
    public static void draw(String[] a, int row, int ith, int jth) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-2.50, row, ith + "");
        StdDraw.text(-1.25, row, jth + "");
        for (int i = 0; i < a.length; i++) {
            if (i == jth)      StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i > ith)  StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (i < jth)  StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else               StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(i, row, a[i]);
        }
    }

    // display header
    public static void header(String[] a) {
        int N = a.length;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(N/2.0, -3, "a[ ]");       
        for (int i = 0; i < N; i++)
            StdDraw.text(i, -2, i + "");       
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "j");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-3, -1.65, N-.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++)
            StdDraw.text(i, -1, a[i]);
    }

    // display footer
    public static void footer(String[] a) {
        int N = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++)
            StdDraw.text(i, N, a[i]);
    }
}
