package main.dsa.day02_cppSTL_base.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class problem4 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		Prob4 solver=new Prob4();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob4{
		public void solve(int testCase, InputReader in, PrintWriter out) {
			char[] chs=in.next().toCharArray();
			int len=chs.length;
			for(;;) {
				if(len%2==1) break;
				int half=len/2;
				int i;
				for(i=0;i<half;++i) {
					if(chs[i] != chs[len-1-i]) break;
				}
				if(i == half) len>>=1;
				else break;
			}
			out.print(len);
		}
	}
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		
		public InputReader(InputStream inputStream) {
			br = new BufferedReader(new InputStreamReader(inputStream), 32768);
			st=null;
		}
		public String next() {
			while(st==null||!st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
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
