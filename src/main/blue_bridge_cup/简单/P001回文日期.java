package main.blue_bridge_cup.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.StringTokenizer;

public class P001回文日期 {

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
		int n;
		int[] ab = {10,11,12,13,20,21,22,30,31,32,40,41,42,50,51,52,60,61,62,70,71,72,80,81,82,90,91,92};//年前两位
		int[] cd = { 1,10,11,20,21,30,40,50,60,70,80,90};// 年后两位
		int[] dc = {10, 1,11, 2,12, 3, 4, 5, 6, 7, 8, 9};//月
		int[] ba = { 1,11,21,31, 2,12,22, 3,13,23, 4,14,24, 5,15,25, 6,16,26, 7,17,27, 8,18,28, 9, 19, 29};//日
		
		int[] AB = {10100101, 11111111, 20200202, 21211212, 30300303, 40400404,
				50500505, 60600606, 70700707, 80800808, 90900909};
		public void solve(int testCases, InputReader in, PrintWriter out) {
			n = in.nextInt();
			int y,m,d;
			Calendar c = Calendar.getInstance();
			for(int i=0;i<28;++i) {
				if(ab[i] < n / 1000000) continue;
				int j = 0;
				for(j=0;j<12;++j) {
					y = ab[i]*100+cd[j];
					if(y < n / 10000) continue;
					m = dc[j];
					d = ba[i];
					if(j == 2) {
						//检验合法性(大小月和二月)
						c.set(Calendar.YEAR, m);
						c.set(Calendar.MONTH, m-1);
						c.set(Calendar.DATE, d);
						if(c.get(Calendar.DATE) != d) continue;
					}
					int date = y*10000+m*100+d;
					if(date <= n) continue;
					out.print(date+"\n");
					break;
				}
				if(j < 11) break;
			}
			for(int date : AB) {
				if(date > n) {
					out.print(date);
					break;
				}
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
