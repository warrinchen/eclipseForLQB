package main.blue_bridge_cup.比赛题目.省2020_11th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G单词分析 {
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
		String s;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			s = in.next();
			int[] cs = new int[27];
		    int mx = 0, mxc = 0;
		    for(char c : s.toCharArray()){
		    	cs[c-'a'] += 1;
		    	cs[c-'a'] += 1;
		        if(mx < cs[c-'a']){
		        	mx = cs[c-'a'];
		        	mxc = c - 'a';
		        }else if(mx == cs[c-'a'] && mxc > (c-'a')){
		        	mx = cs[c-'a'];
		        	mxc = c - 'a';
		        }
		    }
		    out.println((char)(mxc+'a'));
		    out.print(mx);
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


