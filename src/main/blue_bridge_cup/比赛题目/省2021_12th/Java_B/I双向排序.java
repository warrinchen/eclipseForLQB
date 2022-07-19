package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
// 看到区间问题,第一反应是用线段树,但是没想出来,看到的题解也不是线段树...
// 通过观察可以得到基本思路是模拟+化简操作次数+化简操作过程
public class I双向排序 {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream = System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob{
		int n, m, p, q;
		int top = 0;
		Pair[] stack;
		int[] ans;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n = in.nextInt();
			m = in.nextInt();
			ans = new int[n+1];
			stack = new Pair[m+1];
			// 简化操作过程-压缩操作次数
			for(; m-- > 0;) {
				p = in.nextInt();
				q = in.nextInt();
				if(p == 0) {//0:降序操作
					// 保证当前次和上上次是相同操作之:化简连续0操作
					if(top > 0 && stack[top].p == 0) // 若(当前和上一次)连续两次0:降序操作, 选择范围最大的那次
						q = Math.max(q, stack[top--].q);// top-- 操作次数回退一次
					//当前和上上次一定是相同操作: 这是由两个化简双连续相同操作的if 和 去除第一个0操作之前的1操作 保证的
					//注意是while循环,因为可能有多个
					while(top >= 2 && stack[top-1].q <= q)// 若已经缓存了至少两次
		                //如果当前操作比上一次相同操作的范围要大，那此前的两次操作都将无效
						top -= 2;
					stack[++top] = new Pair(p, q);//存入操作 
				// 保证当前次和上上次是相同操作之: 初始时, 所有1操作无效, 有效操作从第一个0操作开始; 过程中, top至少是1
				}else if(top > 0) {
					//保证当前次和上上次是相同操作之:化简连续1操作
					if(top > 0 && stack[top].p == 1)// 若(当前和上一次)连续两次1:升序操作, 选择范围最大的那次
						q = Math.min(q, stack[top--].q);
					//注意是while循环,因为可能有多个
					while(top >= 2 && stack[top-1].q >= q)//如果当前操作比上一次相同操作的范围要大，那此前的两次操作都将无效
						top -= 2;
					stack[++top] = new Pair(p, q);//存入操作 
				}
			}
			// 完成操作流程-对操作过程进行优化而不是模拟
			int st = 1, ed = n, k = n;// st,ed还没有填入数字的区间; k待填入数字
			for(int i = 1; i <= top && st <= ed; ++i) {// 对stack遍历
				// 确定两端: 0降序操作不影响右边
				if(stack[i].p == 0) {
					while(ed > stack[i].q && st <= ed)// 0:降序操作没有覆盖到待填入区间且待填入区间有空位
						ans[ed--] = k--;
				// 确定两端: 1升序操作不影响左边
				}else
					while(st < stack[i].q && st <= ed)
						ans[st++] = k--;
			}
			// 完成操作流程-处理可能的中间剩余的部分
			if(top % 2 != 0)
				while(st <= ed)
					ans[st++] = k--;
			else
				while(st <= ed)
					ans[ed--] = k--;
			out.print(ans[1]);
			for(int i = 2; i <= n; ++i)
				out.print(" " + ans[i]);
		}
		private static class Pair {
			int p;
			int q;
			public Pair(int p, int q) {
				super();
				this.p = p;
				this.q = q;
			}
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
}
