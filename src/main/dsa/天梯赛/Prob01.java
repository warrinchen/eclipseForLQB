package main.dsa.天梯赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Prob01 {

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
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n = in.nextInt();
			int half = n / 2;
			for(int i = 2; i <= half; ++i) {
				if(isPrime(i) && isPrime(n - i)) {
					out.print("Yes");
					half = -1;
					break;
				}
			}
			if(half != -1) out.print("No");
		}
		private boolean isPrime(int x) {
			for(int i = 2; i <= (int)Math.sqrt(x); ++i){
				if(x % i == 0) return false;
			}
			return true;
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
/*
将一个给定的偶数(int范围内)分拆成两个素数之和
*/
