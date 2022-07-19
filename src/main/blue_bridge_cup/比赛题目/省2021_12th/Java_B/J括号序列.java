package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
// 题解都说dp, dp都不会 !_!
public class J括号序列 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(in, out);
		out.flush();
		out.close();
	}
	static class Prob{
		String s;
		public void solve(InputReader in, PrintWriter out) {
			s = in.next();
		}
	}
	static class InputReader{
		StringTokenizer st;
		BufferedReader br;
		public InputReader(InputStream inputStream) {
			br = new BufferedReader(new InputStreamReader(inputStream), 32768);
			st = null;
		}
		public String next() {
			while(st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}
	}
}
