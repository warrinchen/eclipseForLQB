package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class H杨辉三角 {

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
		int N;
		int[] ans = {0, 1, 5, 8, 12, 17, 13, 30, 38, 47, 18};//前10
		public void solve(int testCases, InputReader in, PrintWriter out) {
			N = in.nextInt();
			//if(N <= 10) out.print(ans[N]);//优化
			//else
			out.print(process(N));
		}
		private long process(int n) {
			for(int i = 16; i >= 0; --i) {//C(34, 17)已经大于1e9了, 等于1时, 不用算了, 结果固定, 等于0时, 打表了.
				int L = 2 * i, R = n;
				for(; L < R;) {
					int mid = (L + R) >> 1;
					if(C(mid, i) >= n)
						R = mid;
					else
						L = mid + 1;
				}
				if(C(R, i) == n && L <= R) { // c(1,1) == 1
//					System.out.println((R+1) + "行 " + (i+1) + " 列");
					return R * (1 + R) / 2 + i + 1;
				}
			}
//			System.out.println((n+1) + "行 " + "2 列 out of for ");
			return (long)n * (1 + n) / 2 + 2; //n和n+1必有一个整数, 因此可以除二
		}
		private long C(int n, int k) {
			if(k == 0 || n == 0) return 1;
			long res = 1;
			for(int ni = n - k + 1, ki = 1;ni<=n && ki <= k; ++ni, ++ki) {
				res = res * ni / ki;//优化 这样边乘边除就不会超出long
				if(res > N)
					return res; // 优化 当res > N时, 说明C(n,k)一定大于N, 就没有必要再计算了
			}
			return res;
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
