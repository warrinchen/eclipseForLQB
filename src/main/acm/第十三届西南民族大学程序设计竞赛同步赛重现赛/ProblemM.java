package main.acm.第十三届西南民族大学程序设计竞赛同步赛重现赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 代码没过
 */
public class ProblemM {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		ProbM solver = new ProbM();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class ProbM{
		int n;
		int m;
		Card[] cards;
		int dun;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n=in.nextInt();
			m=in.nextInt();
			cards = new Card[m];
			for(int i=0;i<m;++i) {
				cards[i]=new Card();
				cards[i].magic=in.nextInt();
				cards[i].dun=in.nextInt();
			}
			Arrays.sort(cards, new Comparator<Card>() {
				@Override
				public int compare(Card o1, Card o2) {
					double xjb1 = (double)o1.dun / o1.magic;
					double xjb2 = (double)o2.dun / o2.magic;
					if(Math.abs(xjb1 - xjb2) < 0.00001) {
						if(o1.dun < o2.dun) return -1;
						return 1;
					}
					return xjb1 < xjb2 ? 1 : -1;
				}
			});
			for(int i=0;i<m;++i) {
				if(cards[i].magic <= n) {
					n -= cards[i].magic;
					dun += cards[i].dun;
				}
			}
			out.print(dun);
		}
		static class Card{
			int magic;
			int dun;
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
