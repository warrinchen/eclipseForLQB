package main.dsa.day03_force_method.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * 思路:模拟
 */
public class Problem01 {

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
		int[][] ar;
		int n;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n=in.nextInt();
			int mx = (2*n-1) * (2*n-1);
			int x=0, y=n-1;
			int len = 2*n-1;
			ar=new int[len][len];
			
			ar[x][y] = 1;
			for(int i=2;i<=mx;++i) {
				if(x==0&&y==len-1 || x-1>=0 && y+1<=len-1 && ar[x-1][y+1]!=0) {
					++x;
					ar[x][y]=i;
				}else if(x==0) {
					x = len-1;
					y++;
					ar[x][y]=i;
				}else if(y==len-1) {
					x--;
					y=0;
					ar[x][y]=i;
				}else {
					--x;
					++y;
					ar[x][y]=i;
				}
			}
			for (int i = 0; i < ar[0].length; i++) {
				for (int j = 0; j < ar[0].length; j++) {
					if(j==0) out.print(ar[i][j]);
					else out.print(" "+ar[i][j]);
				}
				out.println();
			}
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
 7-1 神奇的幻方 (10 分)
任务描述
幻方是一个很神奇的N*N矩阵，它的每行、每列与对角线，加起来的数字和都是相同的。
我们可以通过以下方法构建一个幻方。（阶数为奇数）
1.第一个数字写在第一行的中间
2.下一个数字，都写在上一个数字的右上方：
a.如果该数字在第一行，则下一个数字写在最后一行，列数为该数字的右一列
b.如果该数字在最后一列，则下一个数字写在第一列，行数为该数字的上一行
c.如果该数字在右上角，或者该数字的右上方已有数字，则下一个数字写在该数字的下方
输入格式:
一个数字N（N<=20）

输出格式:
按上方法构造的2N-1 * 2N-1的幻方

输入样例:
3
输出样例:
17 24 1 8 15
23 5 7 14 16
4 6 13 20 22
10 12 19 21 3
11 18 25 2 9
题目来源
该题目选自OpenJudge网站，在线网址：http://noi.openjudge.cn/ch0108/22/
 */