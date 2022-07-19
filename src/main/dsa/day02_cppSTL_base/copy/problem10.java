package main.dsa.day02_cppSTL_base.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class problem10 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		new Prob10().solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob10{
		Stack<Integer> numbers;
		Stack<Character> ops;
		int n;
		void solve(int testCases, InputReader in, PrintWriter out) {
			n=in.nextInt();
			numbers = new Stack<>();
			ops= new Stack<>();
			
			for(int i=0;i<n;++i) numbers.add(in.nextInt());
			for(int i=1;i<n;++i) ops.add(in.nextChar());
			for(int i=1;i<n;++i) {
				int a=numbers.pop();
				int b=numbers.pop();
				char op=ops.pop();
				switch (op) {
				case '+':
					numbers.add(b + a);break;
				case '-':
					numbers.add(b - a);break;
				case '*':
					numbers.add(b * a);break;
				case '/':
					if(a == 0) {
						out.print("ERROR: "+b+"/0");
						return;
					}
					numbers.add(b / a);break;
				default:
					break;
				}
			}
			out.print(numbers.pop());
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
		public char nextChar() {
			return next().charAt(0);
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
/*
本题要求你为初学数据结构的小伙伴设计一款简单的利用堆栈执行的计算器。如上图所示，计算器由两个堆栈组成，一个堆栈 S 
1
​
  存放数字，另一个堆栈 S 
2
​
  存放运算符。计算器的最下方有一个等号键，每次按下这个键，计算器就执行以下操作：

从 S 
1
​
  中弹出两个数字，顺序为 n 
1
​
  和 n 
2
​
 ；
从 S 
2
​
  中弹出一个运算符 op；
执行计算 n 
2
​
  op n 
1
​
 ；
将得到的结果压回 S 
1
​
 。
直到两个堆栈都为空时，计算结束，最后的结果将显示在屏幕上。

输入格式：
输入首先在第一行给出正整数 N（1<N≤10 
3
 ），为 S 
1
​
  中数字的个数。

第二行给出 N 个绝对值不超过 100 的整数；第三行给出 N−1 个运算符 —— 这里仅考虑 +、-、*、/ 这四种运算。一行中的数字和符号都以空格分隔。

输出格式：
将输入的数字和运算符按给定顺序分别压入堆栈 S 
1
​
  和 S 
2
​
 ，将执行计算的最后结果输出。注意所有的计算都只取结果的整数部分。题目保证计算的中间和最后结果的绝对值都不超过 10 
9
 。

如果执行除法时出现分母为零的非法操作，则在一行中输出：ERROR: X/0，其中 X 是当时的分子。然后结束程序。

输入样例 1：
5
40 5 8 3 2
/ * - +
输出样例 1：
2
输入样例 2：
5
2 5 8 4 4
* / - +
输出样例 2：
ERROR: 5/0
*/