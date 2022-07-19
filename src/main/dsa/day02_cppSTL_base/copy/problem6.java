package main.dsa.day02_cppSTL_base.copy;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class problem6 {
	public static void main(String[] args) {
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		Prob6 solver= new Prob6();
		solver.solve(1, out);
		out.flush();
		out.close();
	}
	static class Prob6{
		public void solve(int testCase, PrintWriter out) {
			Scanner in=new Scanner(System.in);
			int N=in.nextInt();
			char c=in.next().charAt(0);in.nextLine();
			String s=in.nextLine();
			if(s.length()<N) {
				for(int i=0;i<N-s.length();++i) out.print(c);
				out.print(s);
			}else {
				out.print(s.substring(s.length()-N,s.length()));
			}
			in.close();
		}
	}
}
/*
7-6 Left-pad (20 分)
根据新浪微博上的消息，有一位开发者不满NPM（Node Package Manager）的做法，收回了自己的开源代码，其中包括一个叫left-pad的模块，就是这个模块把javascript里面的React/Babel干瘫痪了。这是个什么样的模块？就是在字符串前填充一些东西到一定的长度。例如用*去填充字符串GPLT，使之长度为10，调用left-pad的结果就应该是******GPLT。Node社区曾经对left-pad紧急发布了一个替代，被严重吐槽。下面就请你来实现一下这个模块。

输入格式：
输入在第一行给出一个正整数N（≤10 
4
 ）和一个字符，分别是填充结果字符串的长度和用于填充的字符，中间以1个空格分开。第二行给出原始的非空字符串，以回车结束。

输出格式：
在一行中输出结果字符串。

输入样例1：
15 _
I love GPLT
输出样例1：
____I love GPLT
输入样例2：
4 *
this is a sample for cut
输出样例2：
 cut
*/