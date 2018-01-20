import algs4.StdOut;
import algs4.StdIn;
import algs4.Stopwatch;
import algs4.StdDraw;
import algs4.StdRandom;
import algs4.StdStats;
public class WeightedQuickUnionTreeCompressionUF{
	private int[] 	parent;
	private int[] 	height;
	private int		NodeCnt;
	private int		LineCnt;
	private int 	VisitCnt;

	public WeightedQuickUnionTreeCompressionUF(int N) {
		NodeCnt = N;
		LineCnt = N;
		VisitCnt = 0;
		parent 	= new int[N];
		height 	= new int[N];
		for (int i = 0; i < N; i++) {
		    parent[i] = i;
		    height[i] = 1;
		}
	}

    public int count() {
        return LineCnt;
    }
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p){
		while(parent[p] != p){
			p = parent[p];
			VisitCnt++;
		}
		return p;
	}

	public void union(int p, int q){
		int m = find(p);
		int n = find(q);

		int cha;
		if(m == n) return;

		else{
			if(height[m] > height[n]){
				parent[n] = m;
				VisitCnt++;
			}
			else if(height[m] < height[n]){
				parent[m] = n;
				VisitCnt++;
			}
			else if(height[m] == height[n]){
				parent[n] = m;
				height[m] += 1;
			}
		}

		LineCnt--;
		return;
	}

	public void printid(){
        for(int i=0; i<NodeCnt; i++){
            StdOut.print(find(i)+" ");
        }

    }
 	public int RVisitCnt(){
 		return VisitCnt;
 	}
 	public void ZVisitCnt(){
 		VisitCnt = 0;
 		return;
 	}

	// public static void main(String[] args) {
	//     int N = StdIn.readInt();
 //        WeightedQuickUnionTreeCompressionUF uf = new WeightedQuickUnionTreeCompressionUF(N);

 //        StdDraw.setXscale(0,600);
	// 	StdDraw.setYscale(0,20);
	// 	StdDraw.setPenRadius(.005);
		
 //        double time;
	// 	Stopwatch timer = new Stopwatch();

	// 	int loops = 0;
 //        while (!StdIn.isEmpty()) {
 //        	uf.ZVisitCnt();
            
 //            int p = StdIn.readInt();
 //            int q = StdIn.readInt();
            
 //            if (uf.connected(p, q)) continue;
 //            uf.union(p, q);
            
 //            int x = uf.RVisitCnt();
 //            int y = loops;
 //            StdDraw.point(y,x);
 //            loops += 1;
 //        }
 //        StdOut.println(uf.count() + " components");
 //        time = timer.elapsedTime();
 //        StdOut.println(" time: "+time);
 //    }
	public static int mycount(int N) {
        int edges = 0;
        WeightedQuickUnionTreeCompressionUF uf = new WeightedQuickUnionTreeCompressionUF(N);
        while (uf.count() > 1) {
            int i = StdRandom.uniform(N);
            int j = StdRandom.uniform(N);
            if(!uf.connected(i,j))
            	uf.union(i, j);
            edges++;
        }
        return edges;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);     // number of vertices
        int T = Integer.parseInt(args[1]);     // number of trials
        int[] edges = new int[T];

        // repeat the experiment T times
        for (int t = 0; t < T; t++) {
            edges[t] = mycount(N);
        }

        // report statistics
        StdOut.println("1/2 N ln N = " + 0.5 * N * Math.log(N));
        StdOut.println("mean       = " + StdStats.mean(edges));
        StdOut.println("stddev     = " + StdStats.stddev(edges));
	}
	
}
