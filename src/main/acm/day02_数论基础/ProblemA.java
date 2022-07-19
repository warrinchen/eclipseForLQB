package main.acm.day02_数论基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
/*
 * 此题数据规模很大, 最大需要使用Vector或TreeSet存放一千万范围内的66万多个质数, 会MLE
 */
public class ProblemA{

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		ProbA solver = new ProbA();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class ProbA{
		int n;
		int[] primes;
		boolean[] not_prime;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n = in.nextInt();
			initPrime();
			int cnt=0;
			for(int i=1;i<=n;++i) {
				int x=in.nextInt();
				cnt=0;
				for(int p : primes) {
					if(p > x/2) break;
					if(!not_prime[x-p])
						cnt++;
				}
				out.print("Case "+i+": "+cnt+"\n");
			}
		}
		private void initPrime() {
			int n = 10000000;
			int id=0;
			primes = new int[10000001];
			not_prime = new boolean[10000001];
			for(int i=2; i <= n; ++i) {
				if(!not_prime[i])
					primes[id++]=i;
				for(int p : primes) {
					if(p * i > n) break;
					not_prime[p * i] = true;
					if(i % p == 0) break;
				}
			}
//			System.out.println(id);
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
/*
https://vjudge.net/problem/LightOJ-1259/origin
*/