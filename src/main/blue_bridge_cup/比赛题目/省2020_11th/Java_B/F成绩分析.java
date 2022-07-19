package main.blue_bridge_cup.比赛题目.省2020_11th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class F成绩分析 {
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
		int n;
		int sum = 0, mx = -0x7f7f7f7f, mn = 0x7f7f7f7f;
		
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n = in.nextInt();
			int x;
			for(int i = 0; i < n; ++i) {
				x = in.nextInt();
				mx = mx < x ? x : mx;
				mn = mn > x ? x : mn;
				sum += x;
			}
			out.printf("%d\n%d\n%.2f", mx,mn,(double)sum/n);
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
