package main.pta.团体程序设计天梯赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// 模拟
public class L1005考试座位号 {

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
		int N, M; //N data, M queries
		HashMap<Integer, Long> test_passports;
		HashMap<Integer, Integer> test_exams;
		public Prob() {
			test_passports = new HashMap<>();
			test_exams = new HashMap<>();
		}
		public void solve(int testCases, InputReader in, PrintWriter out) {
			N = in.nextInt();
			for(int i = 0; i < N; ++i) {
				long pt;
				int tt, em;
				pt = in.nextLong();
				tt = in.nextInt();
				em = in.nextInt();
				test_passports.put(tt, pt);
				test_exams.put(tt, em);
			}
			M = in.nextInt();
			for(int i = 0; i < M; ++i) {
				int tt;
				tt = in.nextInt();
				out.println(test_passports.get(tt) + " " + test_exams.get(tt));
			}
			
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
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		public String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
