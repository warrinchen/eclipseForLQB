package main.blue_bridge_cup.比赛题目.省2019_10th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// 虽然是填空题, 但是暴力时间太久了, 需要剪枝
public class D数的分解 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		long st = System.currentTimeMillis();
		solver.solve(1, in, out);
		long ed = System.currentTimeMillis();
		out.printf("\ntime usage: %f (s)\n", (double)(ed-st)/1000);
		out.flush();
		out.close();
	}
	static class Prob{
		HashSet<HashSet<Integer>> cases = new HashSet<>();
		public void solve(int testCases, InputReader in, PrintWriter out) {
			for(int i = 1; i < 672; ++i) { // i_max = 2019/3-1 三个数最接近的时候, i是最小的
				if(valid(i))
					for(int j = i + 1; j < 1009; ++j) { // (j_max = 2019-1)/2 - 1  i最小为1,jk最接近的时候且j要小于k
						if(i != j && valid(j)) {
							int k = 2019 - i - j;
							if(i != k && j != k && valid(k)) {
								HashSet<Integer> cs = new HashSet<>();
								cs.add(i);
								cs.add(j);
								cs.add(k);
								cases.add(cs);
							}
						}
					}
			}
			out.print(cases.size());
		}
		private boolean valid(int x) {
			int td = x % 10000 / 1000;
			int hd = x % 1000 / 100;
			int tn = x % 100 / 10;
			int on = x % 10;
			if(td != 2 && hd != 2 && tn != 2 && on != 2
					&& td != 4 && hd != 4 && tn != 4 && on != 4)
				return true;
			return false;
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
answer is 40785
time usage: 366s
*/