package main.pta.团体程序设计天梯赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// 模拟
public class L1025正整数A加B {

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
		public void solve(int testCases, InputReader in, PrintWriter out) {
			String A, B, res = "?";
			int a = 0, b = 0;
			A = in.nextLine();
			B = A.substring(A.indexOf(' ') + 1);
			A = A.substring(0, A.indexOf(' '));			
//			out.println(A);
//			out.println(B);
			try {
				a = Integer.parseInt(A);
				if(a < 1 || a > 1000) throw new RuntimeException("error convertion");
				A = Integer.toString(a);
			} catch (Exception e) {
				res = "?";
				A = "?";
			}
			try {
				b = Integer.parseInt(B);
				if(b < 1 || b > 1000) throw new RuntimeException("error convertion");
				B = Integer.toString(b);
			} catch (Exception e) {
				res = "?";
				B = "?";
			}
			if(!A.equals("?") && !B.equals("?"))
				res = Integer.toString(a + b);
			out.print(A + " + " + B + " = " + res);
		}
	}
	static class InputReader{
		StringTokenizer st;
		BufferedReader br;
		public InputReader(InputStream inputStream) {
			br = new BufferedReader(new InputStreamReader(inputStream));
			st = null;
		}
		public String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
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
	}
}