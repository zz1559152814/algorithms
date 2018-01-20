import algs4.StdOut;

public class Matrix
{
	static double dot(double[] x, double[] y)
	{
		double a;
		double add = 0;
		if(x.length != y.length)
		        StdOut.println("wrong1");
		else
		{
	        for(int i=0; i<x.length; i++)
	        {
	                a = x[i]*y[i];
	                add += a;
	        }
		}
		return add;
	}

	static double[][] mult(double[][] a, double[][] b)
	{
		double[][] c = new double[a.length][b[0].length];

		if(a[0].length != b.length)
			StdOut.println("wrong2");

		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<b[0].length; j++)
			{
				c[i][j] = 0;
				for(int h=0; h<a[0].length; h++)
					c[i][j] += a[i][h]*b[h][j];
			}
		}
		return c;
	}

	static double[][] transpose(double[][] a)
	{
		double[][] b = new double[a[0].length][a.length];
		for(int i=0; i<a.length; i++)
			for(int j=0; j<a[0].length; j++)
				b[j][i] = a[i][j];
		return b;
	}

	static double[] mult(double[][] a, double[] x)
	{
		double[][] b = new double[x.length][1];

		for(int i=0; i<x.length; i++)
			b[i][1] = x[i];

		b = mult(a,b);
		
		for(int i=0; i<x.length; i++)
			x[i] = b[i][1];		
		return x;
	}

	static double[] mult(double[] x, double[][] a)
	{
		double[][] b = new double[1][x.length];

		for(int i=0; i<x.length; i++)
			b[1][i] = x[i];

		b = mult(b,a);
		
		for(int i=0; i<x.length; i++)
			x[i] = b[1][i];		
		
		return x;
	}
}
