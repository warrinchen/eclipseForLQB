package main.blue_bridge_cup.比赛题目.省2020_11th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;


public class I子串分值和 {
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
			int[] last_appear_idx = new int[26];
			long res = 0;
			for(int i = 0; i < last_appear_idx.length; ++i)
				last_appear_idx[i] = -1;
			char[] cs = s.toCharArray();
			int len = cs.length;
			int will_appear = cs.length;
			for(int i = 0; i < len; ++i) {
				int id = cs[i]-'a';
				int last_appear = last_appear_idx[id];
				res += (long)(i - last_appear) * (will_appear - i);
				last_appear_idx[id] = i;
			}
			out.print(res);
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