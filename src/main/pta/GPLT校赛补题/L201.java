package main.pta.GPLT校赛补题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class L201 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		StreamReader in = new StreamReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob{
		int N, M; // N 总数, M信息数
		int[] ancestors = new int[100001];
		public Prob() {
			N = M = 0;
		}
		public void solve(int testCases, StreamReader in, PrintWriter out) {
			N = in.nextInt();
			M = in.nextInt();
			for(int i = 0; i <= N; ++i)
				ancestors[i] = i;
			for(int i = 0 ; i < M; ++i) {
				int a = in.nextInt(), b = in.nextInt();
				union(a, b);
			}
			
			Map<Integer, Integer> typeCounts = new TreeMap<Integer, Integer>();
			for(int i = 1; i <= N; ++i) {
				int fa = find(i);
				if(!typeCounts.containsKey(fa))
					typeCounts.put(fa, 1);
				else
					typeCounts.put(fa, typeCounts.get(fa) + 1);
			}
			out.println(typeCounts.size());
			Object[] ar = typeCounts.values().toArray();
			Arrays.sort(ar);
			for(int i = ar.length-1; i > -1; --i)
				if(i > 0)
					out.print(ar[i] + " ");
				else
					out.print(ar[i]);
		}
		private int find(int x) {
			if(ancestors[x] == x)
				return x;
			int fa = ancestors[x];
			for(;;fa = ancestors[fa])
				if(fa== ancestors[fa]) {
					ancestors[x] = fa;
					return fa;
				}
		}
		private void union(int a, int b) {
			int fa = find(a);
			int fb = find(b);
			if(fa == fb) return;
			ancestors[fa] = fb;
		}
	}
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream inputStream) {
			st = null;
			br = new BufferedReader(new InputStreamReader(inputStream));
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
	static class StreamReader{
		StreamTokenizer st;
		public StreamReader(InputStream inputStream) {
			st = new StreamTokenizer(new BufferedReader(new InputStreamReader(inputStream)));
		}
		private void nextToken() {
			try {
				st.nextToken();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public String next() {
			nextToken();
			return st.sval;
		}
		public int nextInt() {
			nextToken();
			return (int)st.nval;
		}
		public double nextDouble() {
			nextToken();
			return st.nval;
		}
	}
}
/*
6 5
1 2
1 3
1 4
2 4
3 5
output
2
5 1
并查集:
  2 3 4 5 5 6
0 1 2 3 4 5 6
*/