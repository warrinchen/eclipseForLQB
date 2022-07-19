package main.dsa.day02_cppSTL_base.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 没有ac 最后一个测试点没过
 * 思路: 排序后, 构造二叉树, 尽最大努力使两边的总和相差最小
 */
public class problem11 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		Prob11 solver=new Prob11();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob11{
		int n;
		int[] ar;
		int[] preSum;
		WoodSeg woodSegs;
		int cost;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n=in.nextInt();
			ar=new int[n];
			preSum=new int[n];
			cost=0;
			for(int i=0;i<n;++i) ar[i]=in.nextInt();
			Arrays.sort(ar);
			for(int i=0;i<n;++i) {
				if(i>0) preSum[i]=preSum[i-1]+ar[i];
				else preSum[0]=ar[0];
			}
			woodSegs = new WoodSeg();
			process(0, n, woodSegs);
			out.print(cost);
		}
		// 把[st,ed)内的数字分配到woodSegs中
		private int process(int st, int ed, WoodSeg wood) {
			if(st+1 == ed) {
				wood.len = ar[st];
				return ar[st];
			}
			int subSum = preSum[ed-1] - preSum[st] + ar[st];
			int half = (int)Math.round(subSum/2.0);
			for(int i=st+1;i<ed;++i) {
				int lsum=preSum[i]-preSum[st]+ar[st];
				if(lsum > half) {
					if(Math.abs(lsum-(preSum[ed-1]-preSum[i])) < Math.abs(preSum[i-1]-preSum[st]+ar[st]-(preSum[ed-1]-preSum[i]+ar[i]))) ++i;
					wood.lf = new WoodSeg();
					wood.len+=process(st, i, wood.lf);
					wood.rt = new WoodSeg();
					wood.len+=process(i, ed, wood.rt);
					cost += wood.len;
					break;
				}
			}
			return wood.len;
		}
		static class WoodSeg{
			int len;
			WoodSeg lf;
			WoodSeg rt;
			public WoodSeg() {
				len=0;
				lf=null;
				rt=null;
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
7-11 修理牧场 (25 分)
农夫要修理牧场的一段栅栏，他测量了栅栏，发现需要N块木头，每块木头长度为整数L 
i
​
 个长度单位，于是他购买了一条很长的、能锯成N块的木头，即该木头的长度是L 
i
​
 的总和。

但是农夫自己没有锯子，请人锯木的酬金跟这段木头的长度成正比。为简单起见，不妨就设酬金等于所锯木头的长度。例如，要将长度为20的木头锯成长度为8、7和5的三段，第一次锯木头花费20，将木头锯成12和8；第二次锯木头花费12，将长度为12的木头锯成7和5，总花费为32。如果第一次将木头锯成15和5，则第二次锯木头花费15，总花费为35（大于32）。

请编写程序帮助农夫计算将木头锯成N块的最少花费。

输入格式:
输入首先给出正整数N（≤10 
4
 ），表示要将木头锯成N块。第二行给出N个正整数（≤50），表示每段木块的长度。

输出格式:
输出一个整数，即将木头锯成N块的最少花费。

输入样例:
8
4 5 1 2 1 3 1 1
输出样例:
49
*/