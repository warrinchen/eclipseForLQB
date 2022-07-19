package main.acm.第十三届西南民族大学程序设计竞赛同步赛重现赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemH {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		ProbH solver = new ProbH();
		solver.sovle(1, in, out);
		out.flush();
		out.close();
	}
	static class ProbH{
		int[] f;
		int mod = 1000000007;
		public void sovle(int testCases, InputReader in, PrintWriter out) {
			int x=in.nextInt();
			if(x < 4) out.print(x);
			else {
				f = new int[x+1];
				f[0]=0;f[1]=1;f[2]=2;f[3]=3;
				for(int i = 4; i <= x; ++i) {
					f[i] = (f[i-1]+f[i-3]) % mod;
				}
				out.print(f[x]);
			}
		}
	}
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream inputStream) {
			br = new BufferedReader(new InputStreamReader(inputStream));
			st = null;
		}
		public String next() {
			while(st == null  || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
