package main.blue_bridge_cup.比赛题目.省2020_11th.Java_B;

public class C蛇形填数 {
	public static void main(String[] args) {
		int offset = 4;
		int res = 1;
		for(int i = 1;i < 20; ++i) {
			res += offset;
			offset += 4;
		}
		System.out.println(res);
	}
}
