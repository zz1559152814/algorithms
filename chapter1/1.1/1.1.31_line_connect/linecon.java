import algs4.StdDraw;
import algs4.StdRandom;
public class linecon
{
	public static void main(String[] args)
	{
		int n = 100;
		StdDraw.setXscale(0,1000);
		StdDraw.setYscale(0,1000);
		StdDraw.setPenRadius(.01);
		
		int number = Integer.parseInt(args[0]);
		double angle = 3.1415926*2/number;
		double angle_n = 0;
		double x,y;
		double[] xs;
		double[] ys;
		
		xs = new double [number];
		ys = new double [number];
		
		for(int i=0; i<number; i++)
		{
			x = 500 + 450*Math.cos(angle_n);
			y = 500 + 450*Math.sin(angle_n);
			StdDraw.point(x,y);
			angle_n += angle;
			xs[i] = x;
			ys[i] = y;
		}

		double pro = Double.valueOf(args[1]);
		for(int i=0; i<number; i++)
		{
			for(int j=i+1; j<number; j++)
			{
				double a = StdRandom.random();
				if(a <= pro)
					StdDraw.line(xs[i],ys[i],xs[j],ys[j]);
			}
		}
	}
}