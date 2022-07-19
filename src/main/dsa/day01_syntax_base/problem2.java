package main.dsa.day01_syntax_base;

import java.util.Scanner;

/*
7-2 3204 校门外的树木 (10 分)
某校大门外长度为L的马路上有一排树，每两棵相邻的树之间的间隔都是1米。我们可以把马路看成一个数轴，马路的一端在数轴0的位置，另一端在L的位置；数轴上的每个整数点，即0，1，2，……，L，都种有一棵树。由于马路上有一些区域要用来建地铁。这些区域用它们在数轴上的起始点和终止点表示。已知任一区域的起始点和终止点的坐标都是整数，区域之间可能有重合的部分。现在要把这些区域中的树（包括区域端点处的两棵树）移走。你的任务是计算将这些树都移走后，马路上还有多少棵树。

输入格式:
输入的第一行有两个整数L（1 <= L <= 10000）和 M（1 <=M <= 100），L代表马路的长度，M代表区域的数目，L和M之间用一个空格隔开。接下来的M行每行包含两个不同的整数，用一个空格隔开，表示一个区域的起始点和终止点的坐标。注意输入数据可能有很多组。

输出格式:
输出包括一行，这一行只包含一个整数，表示马路上剩余的树的数目。

输入样例:
500 3
150 300
100 200
470 471
输出样例:
298
思路1:数据很小, 模拟
思路2:线段树
 */

public class problem2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt(), n = in.nextInt(), l, r;
		int[] ar = new int[len+1];
		for (int i = 0; i < n; i++) {
			l=in.nextInt();
			r=in.nextInt();
			for (int j = l; j <= r; j++) {
				ar[j]=1;
			}
		}
		int res=0;
		for (int i = 0; i < ar.length; i++) {
			res += ar[i];
		}
		System.out.println(len + 1 - res);
		in.close();
	}

}
