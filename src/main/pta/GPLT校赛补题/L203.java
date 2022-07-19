package main.pta.GPLT校赛补题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class L203 {

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
		boolean[] notPrime = new boolean[1000001];
		ArrayList<Integer> primes = new ArrayList<>();
//		int[] presums = new int[1000001];
		public void solve(int testCases, InputReader in, PrintWriter out) {
			N = in.nextInt();
			sieve();
//			for(int i = 2; i < 1000001; ++i)
//				presums[i] += presums[i-1] + (notPrime[i] ? 0 : 1);
			int L, R;
			for(int i = 0; i < N; ++i) {
				L = in.nextInt();
				R = in.nextInt();
				int res = 0;
				out.println(binSearch(R, -1) - binSearch(L, 0) + 1);
//				out.println(presums[R] - presums[L] + (notPrime[L] ? 0 : 1));
				out.flush();
			}
		}
		private int binSearch(int k, int offset) { // 第一个小于等于k的质数的位置
			int L = 0, R = primes.size();
			while(L < R) {
				int mid = L + ((R - L) >> 1);
				int p = primes.get(mid);
				if(p == k)
					return mid;
				else if(p > k)
					R = mid;
				else
					L = mid + 1;
			}
			return L + offset;
		}
		private void sieve() {
			notPrime[0] = notPrime[1] = true;
			for(int i = 2; i < 1000001; ++i) {
				if(!notPrime[i])
					primes.add(i);
				for(int p : primes) {
					if(p * i > 1000000)
						break;
					notPrime[p * i] = true;
					if(i % p == 0)
						break;
				}
			}
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
/*
java过不了, 用cpp就行了
4
1 4
1 3
2 4
2 3
*/