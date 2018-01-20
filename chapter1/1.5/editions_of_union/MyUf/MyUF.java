import algs4.StdOut;
import algs4.StdIn;
import algs4.Stopwatch;

public class MyUF{
	private int[][] 	id;
	private int[] 	sz;
	private int		count;
	private int Np;
	
	private void MyUF(int N){
		id = new int[N][2];
		sz = new int[N];
		count = N;
		Np		= N;

		for(int i=0; i<N; i++){
			id[i][0] = i;
			id[i][1] = i;
			sz[i] = 1;
		}
	}
	private int find(int a){
		int root = a;
		int botton = a;
		while(id[root][0] != root)
			root = id[root][0];

		while(id[botton][1] != botton)
			botton = id[botton][1];
		
		//压缩路径
		int pre;
		while (botton != root) {
            pre = id[botton][0];
            id[botton][0] = root;
            botton = pre;
        }

		// int c = id[b];
		// while(c != b){
		// 	b = c;
		// 	c = id[b];
		// 	// StdOut.println("id["+b+"]"+":"+c+" ->"+" "+a);
		// 	id[b] = a;
		// }
		return root;
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
				id[k][0] = j;
				id[j][1] = k;
				sz[j] += sz[k];
			}
			else{
				id[j][0] = k;
				id[k][1] = j;
				sz[k] += sz[j];
			}
			count--;
		}
	}
	public void printid(){
		StdOut.println(Np);
		for(int i=0; i<Np; i++){
			StdOut.print(id[i][0]+" ");
		}

	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		MyUF UF = new MyUF();
		UF.MyUF(N);
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
		UF.printid();
	}
}
