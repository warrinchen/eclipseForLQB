package main.blue_bridge_cup.比赛题目.省2020_11th.Java_B;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class D七段码 {
	static int length;
	static int[][] map = new int[8][8];
	static int dir[][] = {{-1,0},{0,-1},{0,1},{1,0}};
	static HashSet<HashSet<Integer>> dataset = new HashSet<>();
	static HashSet<Integer> data;
	static PrintWriter out;

	public static void main(String[] args) {
		try {
			out = new PrintWriter(new FileOutputStream("./src/main/out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 10; ++i) {
			int x = in.nextInt(), y = in.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		for(int i =1; i <= 7; ++i) { // 长度为i
			for(int j = 1; j <= 7; ++j) { // 每次从j=1开始找
				length = i;
				ArrayList<Integer> list = new ArrayList<>();
				list.add(j);
				dfs(1, j, list);
			}
		}
		System.out.println(dataset.size());
		in.close();
		out.close();
	}
	static private void dfs(int len, int x, ArrayList<Integer> list) {//len当前路径的长度, x当前位置,list路径
		if(len == length) {
			data=new HashSet<>(list);
			dataset.add(data);
			return ;
		}
		for(int i = 1; i <= 7; ++i)
			if(map[x][i] == 1) {
				ArrayList<Integer> ls = new ArrayList<Integer>(list);
				ls.add(i);
				dfs(len+1, i, ls);
			}
	}

}
/*
1 2
1 6
2 3
2 7
3 4
3 7
4 5
5 6
5 7
6 7
*/