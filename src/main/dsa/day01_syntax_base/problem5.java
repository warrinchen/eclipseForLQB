package main.dsa.day01_syntax_base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class problem5 {
	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob5 solver = new Prob5();
		solver.solve(1, in, out);
		out.close();
	}
	
	static class Prob5{
		int n;
		Map<Integer, Prob5.Room> rooms = new TreeMap();
		
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			n=in.nextInt();
			int id;
			String name;
			int height;
			int weight;
			
			for (int i = 0; i < n; ++i) {
				id = in.nextInt();
				name = in.next();
				height = in.nextInt();
				weight = in.nextInt();
				if (rooms.containsKey(id)) {
					if (height > rooms.get(id).height) {
						rooms.put(id, new Room(id, name, height, weight));
					}
				}else {
					rooms.put(id, new Room(id, name, height, weight));
				}
			}
			
			for (int k : rooms.keySet()) {
				out.printf("%06d %s\n", k, rooms.get(k));
			}
		}
		static class Room{
			int id;
			String name;
			int height;
			int weight;
			public Room(int id, String name, int height, int weight) {
				this.id = id;
				this.name = name;
				this.height = height;
				this.weight = weight;
			}
			@Override
			public String toString() {
				return name+" "+height+" "+weight;
			}
			
		}
	}
	
	static class InputReader{
		public BufferedReader br;
		public StringTokenizer st;
		
		public InputReader(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
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
7-5 宿舍谁最高？ (20 分)
学校选拔篮球队员，每间宿舍最多有 4 个人。现给出宿舍列表，请找出每个宿舍最高的同学。定义一个学生类 Student，有身高 height，体重 weight 等。

输入格式:
首先输入一个整型数 n （1≤n≤1e6），表示有 n 位同学。

紧跟着 n 行输入，每一行格式为：宿舍号 name height weight。
宿舍号的区间为 [0, 999999]， name 由字母组成，长度小于 16，height，weight 为正整数。

输出格式:
按宿舍号从小到大排序，输出每间宿舍身高最高的同学信息。题目保证每间宿舍只有一位身高最高的同学。

注意宿舍号不足 6 位的，要按 6 位补齐前导 0。

输入样例:
7
000000 Tom 175 120
000001 Jack 180 130
000001 Hale 160 140
000000 Marry 160 120
000000 Jerry 165 110
000003 ETAF 183 145
000001 Mickey 170 115
输出样例:
000000 Tom 175 120
000001 Jack 180 130
000003 ETAF 183 145
*/