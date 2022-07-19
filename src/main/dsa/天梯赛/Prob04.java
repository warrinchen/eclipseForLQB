package main.dsa.天梯赛;

import java.util.Scanner;

public class Prob04 {

	public static void main(String[] args) {
		int a, b;
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		if(a * 10 > b) System.out.println("HZWZ");
		else System.out.println("DDJZ");
		in.close();
	}
}
