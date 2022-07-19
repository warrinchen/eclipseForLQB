package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G最少砝码 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ProbG solver = new ProbG();
		long st = System.currentTimeMillis();
		solver.solve(1, in, out);
		long ed = System.currentTimeMillis();
		out.print((double)(ed - st) / 1000 + "s");
		out.flush();
		out.close();
	}
	static class ProbG{
		int N;
		public void solve(int testCases, InputReader in, PrintWriter out) {
//			N = in.nextInt();
			N = 1000000000;
			int L = 1, R = 20, mid;
			for(;L < R;) {
				mid = (L + R)/2;
				if(sumN(mid) < N)
					L = mid + 1;
				else
					R = mid;
			}
			out.println(L);
			for(int i = 1; ; ++i) {
				long res = sumN(i);
				out.println(i+" : "+res);
				out.flush();
				if(res >= N) {
					out.println(i);
					break;
				}
			}
		}
		private long sumN(int n) {
			long res = 0;
			for(int i = 1; i <= n; ++i)
				res += C(n, i) * (long)Math.pow(2, i - 1);
			return res;
		}
		private long C(int n, int k) {
			if(k == 0 || n == 0) return 1;
			long res = 1;
			for(int ni = n - k + 1, ki = 1; ni <= n && ki <= k; ++ni, ++ki)
				res = res * ni / ki;
			return res;
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
二分 + 
*/