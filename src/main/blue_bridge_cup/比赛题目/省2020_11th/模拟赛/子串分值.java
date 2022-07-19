package main.blue_bridge_cup.比赛题目.省2020_11th.模拟赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;


public class 子串分值 {
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
		String s;
		public void solve(int testCases, StreamReader in, PrintWriter out) {
			s = in.next();
			int[] last_idxs = new int[26];
			char[] cs = s.toCharArray();
			long res = 0;
			for(int i = 0; i < last_idxs.length; ++i)
				last_idxs[i] = -1;
			int len = cs.length;
			for(int i = 0; i < len; ++i) {
				int last_id = last_idxs[cs[i] - 'a'];
				int next_id = nextId(cs, i, cs[i]);
				res += (long)(i - last_id) * (next_id - i);
				last_idxs[cs[i] - 'a'] = i;
			}
			out.print(res);
		}
		private int nextId(char[] cs, int st, char dest) {
			int len = cs.length;
			for(int i = st + 1; i < len; ++i)
				if(cs[i] == dest)
					return i;
			return len;
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
	static class StreamReader {
		StreamTokenizer st;
		public StreamReader(InputStream inputStream) {
			st = new StreamTokenizer(new BufferedReader(new InputStreamReader(inputStream)));
		}
        String next(){
            try {
                st.nextToken();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return st.sval;
        }
        int nextInt(){
        	try {
                st.nextToken();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return (int)st.nval;
        }
	}
}