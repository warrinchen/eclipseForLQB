package main.blue_bridge_cup.比赛题目.省2019_10th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B不同子串 {
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
		public void solve(int testCases, InputReader in, PrintWriter out) {
			HashSet<String> set = new HashSet<>();
			String s = "0100110001010001";
			for(int i = 0; i < s.length(); ++i)
				for(int j = i + 1; j <= s.length(); ++j)
					set.add(s.substring(i,j));
			out.print(set.size());
			out.print(set);
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
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}
