package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E路径 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ProbE solver = new ProbE();
		long startTime = System.currentTimeMillis();
		solver.solve(1, in, out);
		long endTime = System.currentTimeMillis();
		out.print("\n程序运行时间: " + (double)(endTime - startTime) / 1000 + " s\n");
		out.flush();
		out.close();
	}
	static class ProbE{
		int[][] mp;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			int n = 2021;
			initMp(n+1);
			long[] D = new long[n+1];
			boolean[] finded = new boolean[n+1];
			
			for(int i = 1; i <= n; ++i) D[i] = mp[1][i];
			D[1] = 0;
			finded[1] = true;
			
			for(int i = 1; i < n; ++i) {
				long mn = Integer.MAX_VALUE;
				int now = 0;
				for(int j = 1; j <= n; ++j)
					if(!finded[j])
						if(D[j] < mn) {
							now = j;
							mn = D[j];
						}
				finded[now] = true;
				for(int j = 1; j <= n; ++j)
					if(!finded[j] && (mn + mp[now][j]) < D[j])
						D[j] = mn + mp[now][j]; 
			}
			out.print(D[2021]);
		}
		private void initMp(int n) {
			mp = new int[n][n];
			for(int i = 0; i < n; ++i)
				Arrays.fill(mp[i], Integer.MAX_VALUE);
			for(int i = 1; i < n; ++i)
				for(int j = 1; j < n; ++j)
					if(mp[j][i] != Integer.MAX_VALUE)
						mp[i][j] = mp[j][i];
					else if(Math.abs(i - j) <= 21)
						mp[i][j] = lcm(i, j);
		}
		private int lcm(int a, int b) {
			if(a < b) {
				int t = a;
				a = b;
				b = t;
			}
			return (int)(long)a * b / gcd(a, b);
		}
		private int gcd(int a, int b) {
			return b == 0 ? a : gcd(b, a % b);
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
