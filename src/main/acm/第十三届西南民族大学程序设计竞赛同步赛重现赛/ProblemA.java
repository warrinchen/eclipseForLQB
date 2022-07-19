package main.acm.第十三届西南民族大学程序设计竞赛同步赛重现赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemA {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		Prob1 solver=new Prob1();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob1{
		int n;
		int[] ai;
		int[] bi;
		int beauty;
		long cost;
		void solve(int testCases, InputReader in, PrintWriter out) {
			n=in.nextInt();
			ai=new int[n-1];
			bi=new int[n-1];
			for(int i=0;i<n-1;++i) ai[i]=in.nextInt();
			for(int i=0;i<n-1;++i) bi[i]=in.nextInt();
			beauty=bi[0];
			cost+=ai[0];
			for(int i=1;i<n-2;++i) {
				if(bi[i]>beauty) {
					if (bi[i+1] > bi[i]) {
						beauty=bi[i+1];
						cost+=ai[i+1];
						++i;
					}else if(bi[i+1] == bi[i]) {
						beauty=bi[i];
						if(ai[i+1] < ai[i]) {
							cost += ai[i+1];
						}else {
							cost += ai[i];
						}
						++i;
					}else {
						beauty=bi[i];
						cost+=ai[i];
						++i;
					}
				}
			}
			if(bi[bi.length-1] > beauty) {
				cost+=ai[ai.length-1];
			}
			out.print(cost);
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
			while(st == null  || !st.hasMoreTokens()) {
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
《落花》&amp;&amp;《红衣集》
时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 262144K，其他语言524288K
64bit IO Format: %lld
题目描述 
在风景如画，美女如云的SMU生活学习一年后，多金的花样少年JolerJoler练成了见女生必送鲜花的浪漫绝技。
这一天，JolerJoler要去见Princess FunPrincessFun，
他们在一条长度为n的，有n+1个点的笔直的路上，JolerJoler在第0点上，Princess FunPrincessFun在第n点上，
第1个点到第n−1个点上每个点都有一家花店，第ii家花店以ai的价格出售美丽值为bi的花（每家花店都只出售一种花）。
JolerJoler希望送给Princess FunPrincessFun最美丽的花，但他提前并不知道每家花店的花的美丽值。因此他想出了一个“货比三家”买花算法：
- 会买下第一家的花。
- 之后每遇到一家花店，就把当前这家花店的花和自己手里的花进行比较，如果这家花店的花比自己手里的花更美丽，就去下一家花店观察花店的美丽值（若存在）。
简而言之，当前在第i个花店，会比较第i个花店售出花的美丽值，如果更美丽，就去看第i+1个花店售出花的美丽值。
买下这两家花店中最美丽的花（如果一样美丽，则买下便宜的一家花店的花）来替换自己手中的花并且下一次从第i+2家花店开始看，继续以上步骤。
请你计算出JolerJoler最终需要花多少钱。
输入描述:
共3行：
第一行包含一个整数n(2≤n≤100000), 表示路的长度（路上有n+1个点）。
第二行包含n-1个整数ai(1<=ai<=10^9),表示第i家花店出售花的价格。
第三行包含n-1个整数bi(1≤bi≤1e9),表示第i家花店出售的花的美丽值。
输出描述:
共一行，输出按照题面中的方法，JolerJoler最终会花多少钱。
示例1
输入
5
1 3 2 5
2 3 4 1
输出
3
*/