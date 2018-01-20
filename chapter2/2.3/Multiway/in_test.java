import java.util.Comparator;
import algs4.StdOut;
import algs4.StdIn;
import algs4.In;
import algs4.StdRandom;
import algs4.StdDraw;
import algs4.Stopwatch;

public class in_test {
    private static void merge(In[] streams) { 
        int N = streams.length; 

        // IndexMinPQ<String> pq = new IndexMinPQ<String>(N); 
        for (int i = 0; i < N; i++) 
            if(!streams[i].isEmpty()) 
                // pq.insert(i, streams[i].readString()); 
                StdOut.print(streams[i].readString());


        // // Extract and print min and read next from its stream. 
        // while (!pq.isEmpty()) {
        //     StdOut.print(pq.minKey() + " "); 
        //     int i = pq.delMin(); 
        //     if (!streams[i].isEmpty()) 
        //         pq.insert(i, streams[i].readString()); 
        // }
        // StdOut.println();
        StdOut.println(N);
    } 


    /**
     *  Reads sorted text files specified as command-line arguments;
     *  merges them together into a sorted output; and writes
     *  the results to standard output.
     *  Note: this client does not check that the input files are sorted.
     */
    public static void main(String[] args) { 
        int N = args.length; 
        In[] streams = new In[N]; 
        for (int i = 0; i < N; i++) 
            streams[i] = new In(args[i]); 
        merge(streams); 
    } 
}