package main.dsa.day01_syntax_base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class problem7 {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		Prob7 solver=new Prob7();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	
	static class Prob7{
		int n;
		char c;
		int oddNum;
		int floors;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n=in.nextInt();
			c=in.nextChar();
			oddNum = (int)Math.floor(Math.sqrt((n+1)/2));
			floors = 2 * oddNum - 1;
			int tfloors = floors;
			int spaces = 0;
			
			for (int i = 1; i < oddNum; ++i) {
				for(int j = 0; j < spaces; ++j) out.print(' ');
				for(int j = 0; j < tfloors; ++j) out.print(c);
				out.print('\n');
				tfloors -= 2;
				spaces++;
			}
			spaces=(floors - 1) / 2;
			for(int j = 0; j < spaces; ++j) out.print(' ');
			for(int j = 0; j < tfloors; ++j) out.print(c);
			out.print('\n');
			spaces--;
			
			for (int i = 1; i < oddNum; ++i) {
				for(int j = 0; j < spaces; ++j) out.print(' ');
				tfloors += 2;
				for(int j = 0; j < tfloors; ++j) out.print(c);
				out.print('\n');
				spaces--;
			}
			int extra = n - 2 * oddNum * oddNum + 1;
			out.print(extra);
		}
	}

	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		
		public InputReader(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
			st = null;
		}
		
		public String next() {
			while(st==null || !st.hasMoreTokens()) {
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
		public char nextChar() {
			return next().charAt(0);
		}
	}
}
/*
7-7 打印沙漏 (20 分)
本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印

*****
 ***
  *
 ***
*****
所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。

给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。

输入格式:
输入在一行给出1个正整数N（≤1000）和一个符号，中间以空格分隔。

输出格式:
首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 */