package main.blue_bridge_cup.比赛题目.省2020_11th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A门牌制作 {

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
		public void solve(int testcases, InputReader in, PrintWriter out) {
			int res = 0;
			for(int i = 2; i <= 2020; ++i) {
				String s = Integer.toString(i);
				String ss = s.replace("2", "");
				res += s.length() - ss.length();
				if (s.length() - ss.length() != 0) {
					out.println(s);
				}
				if(s.equals("1000") || s.equals("1999"))
					out.println("\t\t\t"+res);
			}
			out.print(res);
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
