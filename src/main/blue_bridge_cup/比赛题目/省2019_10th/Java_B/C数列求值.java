package main.blue_bridge_cup.比赛题目.省2019_10th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C数列求值 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Problem solver = new Problem();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Problem{
		int a, b, c, d;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			a = b = c = 1;
			d = 3;
			for(int i = 5; i <= 20190324; ++i) {
				a = b;
				b = c;
				c = d;
				d = (a + b + c) % 10000;
			}
			out.print(d);
		}
	}
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream inputStream) {
			br = new BufferedReader(new InputStreamReader(inputStream), 32768);
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
		public String nextLine() throws Exception {
			return br.readLine();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
