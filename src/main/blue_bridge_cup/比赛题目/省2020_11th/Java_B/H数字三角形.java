package main.blue_bridge_cup.比赛题目.省2020_11th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class H数字三角形 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		out.flush();
		out.close();		
	}
	static class Prob{
		int N;
		int[][] data = new int[101][101];
		int[][] dp = new int[101][101];
		public void solve(int testCases, InputReader in, PrintWriter out) {
			N = in.nextInt();
			for(int i = 1; i <= N; ++i)
				for(int j = 1; j <= i; ++j)
					data[i][j] = in.nextInt();
			dp[1][1] = data[1][1];
			for(int i = 1; i <= N; ++i)
				for(int j = 1; j <= i; ++j)
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + data[i][j];
			if(N % 2 == 0)
				out.print(Math.max(dp[N][N/2], dp[N][N/2 + 1]));
			else
				out.print(dp[N][N/2+1]);
		}

	}
	static class InputReader {
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
