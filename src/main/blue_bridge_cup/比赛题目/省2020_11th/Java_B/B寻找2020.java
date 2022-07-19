package main.blue_bridge_cup.比赛题目.省2020_11th.Java_B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B寻找2020 {

	public static void main(String[] args) {
//		InputStream inputStream=System.in;
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(
					new File("./src/main/blue_bridge_cup/比赛题目/省2020_11th/Java_B/2020_A_data.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		OutputStream outputStream = System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob{
		ArrayList<ArrayList<Character>> chars = new ArrayList<>();
		public void solve(int testcases, InputReader in, PrintWriter out) {
			int res = 0;
			String line = in.nextLine();
			for(;line != null; line = in.nextLine()) {
				ArrayList<Character> cs = new ArrayList<>();
				for(char c : line.toCharArray())
					cs.add(c);
				chars.add(cs);
			}
			// 行
			for(int i = 0; i < chars.size(); ++i) {
				ArrayList<Character> cs = chars.get(i);
				for(int j = 0; j < cs.size() - 3; ++j) {
					if(cs.get(j) == '2' && cs.get(j+1) == '0' && cs.get(j+2) == '2' && cs.get(j+3) == '0') {
						out.printf("%d行内: %d %d %d %d\n", i, j, j+1, j+2,j+3);
						res++;
						++j;
					}
				}
			}
			// 列
			for(int i = 0; i < chars.get(0).size(); ++i) {
				for(int j = 0; j < chars.size() - 3; ++j)
					if(chars.get(j).get(i) == '2' && chars.get(j+1).get(i) == '0'
							&& chars.get(j+2).get(i) == '2' && chars.get(j+3).get(i) == '0') {
						out.printf("%d列内: %d %d %d %d\n", i, j, j+1, j+2,j+3);
						res++;
						++j;
					}
			}
			// 左上->右下
			for(int i = 0; i < chars.size() - 3; ++i) {
				for(int x = i, y = 0; x < chars.size() - 3 && y < chars.get(0).size() - 3; ++x, ++y) {
					if(chars.get(x).get(y) == '2' && chars.get(x+1).get(y+1) == '0'
							&& chars.get(x+2).get(y+2) == '2' && chars.get(x+3).get(y+3) == '0') {
						out.printf("斜线内: (%d %d) (%d %d) (%d %d) (%d %d) \n", x,y, x+1,y+1, x+2,y+2, x+3,y+3);
						res++;
						++x;
						++y;
					}
				}
			}
			for(int i = 1; i < chars.size() - 3; ++i) {
				for(int x = 0, y = i; x < chars.size() - 3 && y < chars.get(0).size() - 3; ++x, ++y) {
					if(chars.get(x).get(y) == '2' && chars.get(x+1).get(y+1) == '0'
							&& chars.get(x+2).get(y+2) == '2' && chars.get(x+3).get(y+3) == '0') {
						out.printf("斜线内: (%d %d) (%d %d) (%d %d) (%d %d) \n", x,y, x+1,y+1, x+2,y+2, x+3,y+3);
						res++;
						++x;
						++y;
					}
				}
			}
			out.print(res);
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
		public String nextLine() {
			String s = null;
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;
		}
	}
}
