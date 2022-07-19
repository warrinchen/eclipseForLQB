package main.blue_bridge_cup.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P002数字三角形 {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream = System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob{
		int[][] tri;
		int[][] dp;
		int n;
		int mx;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			tri = new int[101][101];
			dp = new int[101][101];
			n = in.nextInt();
			for(int i = 1; i <= n; ++i)
				for(int j = 1; j <= i; ++j)
					tri[i][j] = in.nextInt();
			dp[1][1] = tri[1][1];
			for(int i = 2; i <= n; ++i)
				for(int j = 1; j <= i; ++j)
					dp[i][j] = tri[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			if(n % 2 == 0) {
				out.print(Math.max(dp[n][n/2], dp[n][n/2 + 1]));
			}else {
				out.print(dp[n][n/2+1]);
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
			while(st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
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
