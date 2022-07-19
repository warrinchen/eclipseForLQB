package main.acm.day01_stl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemA {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		ProbA solver = new ProbA();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class ProbA{
		int idx;
		int n;
		int[] ar;
		int q;
		Map<Integer, Integer> data;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			data = new HashMap<>();
			for(;;) {
				idx++;
				data.clear();
				n=in.nextInt();
				q=in.nextInt();
				if(n==0) break;
				intput(n,in);
				out.print("CASE# "+idx+":\n");
				query(q,in,out);
			}
		}
		private void query(int q, InputReader in, PrintWriter out) {
			int x;
			for(int i=0;i<q;++i) {
				x=in.nextInt();
				if(data.containsKey(x)) {
					out.print(x+" found at "+data.get(x)+"\n");
				}else {
					out.print(x+" not found\n");
				}
			}
		}
		private void intput(int n, InputReader in) {
			ar = new int[n+1];
			for(int i=1;i<=n;++i) ar[i]=in.nextInt();
			Arrays.sort(ar);
			for(int i=1;i<=n;++i)
				if(!data.containsKey(ar[i]))
					data.put(ar[i], i);
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
https://vjudge.net/problem/UVA-10474/origin
*/
