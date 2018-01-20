import algs4.StdOut;
import algs4.StdIn;
import algs4.Stopwatch;

public class WeightedQuickUnionUF{
	private int[] 	id;
	private int[] 	sz;
	private int		count;
	private int Np;
	
	private void WeightedQuickUnionUF(int N){
		id = new int[N];
		sz = new int[N];
		count = N;
		Np		= N;

		for(int i=0; i<N; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	 // int root = a;
  //       while (root != id[root])
  //           root = parent[root];
  //       while (a != root) {
  //           int newp = id[a];
  //           id[a] = root;
  //           a = newp;
  //       }
	private int find(int a){
		int b = a;
		while(id[a] != a){
			a = id[a];
		}

		//压缩路径
		while (b != a) {
            int newp = id[b];
            id[b] = a;
            b = newp;
        }

		// int c = id[b];
		// while(c != b){
		// 	b = c;
		// 	c = id[b];
		// 	// StdOut.println("id["+b+"]"+":"+c+" ->"+" "+a);
		// 	id[b] = a;
		// }
		return a;
	}

	private boolean connect(int p, int q){
		return find(p) == find(q);
	}

	private int count(){
		return count;
	}

	private void union(int p, int q){
		int j = find(p);
		int k = find(q);

		if(q == p) return;
		else{
			if(sz[j] > sz[k]){
				id[k] = j;
				sz[j] += sz[k];
			}
			else{
				id[j] = k;
				sz[k] += sz[j];
			}
			count--;
		}
	}
	public void printid(){
		StdOut.println(Np);
		for(int i=0; i<Np; i++){
			StdOut.print(id[i]+" ");
		}

	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		WeightedQuickUnionUF UF = new WeightedQuickUnionUF();
		UF.WeightedQuickUnionUF(N);
		int p,q;

		double time;
		Stopwatch timer = new Stopwatch();
		while(!StdIn.isEmpty()){
			p = StdIn.readInt();
			q = StdIn.readInt();
			if(UF.connect(p, q))
				continue;
			UF.union(p,q);
		}
		time = timer.elapsedTime();
        StdOut.println("time is: " + time);
		StdOut.println(UF.count());
		// UF.printid();
	}
}
