package main.dsa.day03_force_method.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem02 {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		Prob2 solver=new Prob2();
		solver.solve(1, in, out);
		out.close();
	}
	static class Prob2{
		int n;
		public void solve(int testCase, InputReader in, PrintWriter out) {
			n=in.nextInt();
			int x;
			for(int i=0;i<n;++i) {
				x=in.nextInt();
				if(i>0) out.println();
				if(prime(x)) out.print("Yes");
				else out.print("No");
				out.flush();
			}
		}
		public boolean prime(int a) {
			if(a==1) return false;
			for(int i=2;i<Math.sqrt(a);++i) {
				if(a%i==0) return false;
			}
			return true;
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
/*
7-2 判断素数 (10 分)
本题的目标很简单，就是判断一个给定的正整数是否素数。

输入格式：
输入在第一行给出一个正整数N（≤ 10），随后N行，每行给出一个小于2 
31
 的需要判断的正整数。

输出格式：
对每个需要判断的正整数，如果它是素数，则在一行中输出Yes，否则输出No。

输入样例：
2
11
111
输出样例：
Yes
No
*/