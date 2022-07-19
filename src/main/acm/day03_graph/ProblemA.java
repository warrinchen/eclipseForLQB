package main.acm.day03_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemA {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ProbA solver = new ProbA();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class ProbA{
		int n;
		int k;
		int cnt;//放置了的棋子计数
		int ans;
		char[][] map;
		boolean[] colVisited;
		
		public void solve(int testCases, InputReader in, PrintWriter out) {
			map=new char[8][8];
			colVisited=new boolean[8];
			for(;;) {
				n=in.nextInt();
				k=in.nextInt();
				if(n==-1) break;
				init();
				for(int i=0;i<n;++i) {
					map[i] = in.next().toCharArray();
				}
				dfs(0);
				out.print(ans+"\n");
			}
		}
		private void init() {
			cnt = 0;
			ans = 0;
			Arrays.fill(colVisited, false);
		}
		private void dfs(int nowRow) {
			if(cnt == k) {
				ans++;
				return ;
			}
			if(nowRow > n - 1) {
				return;
			}
			dfs(nowRow+1);
			for(int i=0;i<n;++i) {
				if(map[nowRow][i] == '#' && !colVisited[i]) {
					cnt++;
					colVisited[i]=true;
					dfs(nowRow+1);
					cnt--;
					colVisited[i]=false;
				}
			}
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
				}catch (IOException e) {
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
 * 棋盘问题
 * http://poj.org/problem?id=1321
*/