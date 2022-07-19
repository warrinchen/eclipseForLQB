package main.dsa.day02_cppSTL_base.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class problem1 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		Prob1 solver=new Prob1();
		solver.solve(in.nextInt(), in, out);
		out.flush();
		out.close();
	}
	
	static class Prob1{
		public void solve(int testCases, InputReader in, PrintWriter out) {
			for(int i = 0; i < testCases; ++i) printN(in, out);
		}

		private void printN(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			Set<String> ball=new HashSet<>();
			for(int i=0;i<n;++i) ball.add(in.next().toLowerCase());
			out.print(ball.size() + "\n");
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
7-1 题目统计 (10 分)
在ACM程序设计竞赛赛场，当某个队伍正确解答一道题目后就会在其前面升起1个彩色气球。而且每种颜色的气球只能用在一道题目上，所以不同颜色的气球不能相互替代。已知比赛过程中已送出的气球数量以及每个气球的颜色，请统计已成功解决的不同题目的总数。

输入格式:
首先输入一个正整数T，表示测试数据的组数，然后是T组测试数据。每组测试先输入一个整数n（1≤n≤100），代表已经送出的气球总数，然后输入n个已送出气球的颜色（由长度不超过20且不包含空格的英文字母组成），数据之间间隔一个空格。注意，统计时，忽略气球颜色的大小写。

输出格式:
对于每组测试，在一行上输出一个整数，表示已成功解决的不同题目的总数。

输入样例:
1
5 RED Red Blue Green REd
输出样例:
3
*/