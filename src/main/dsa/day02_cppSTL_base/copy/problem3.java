package main.dsa.day02_cppSTL_base.copy;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * 思路: 用字符串比较
 * 注意: s1 < s2 是条件: s1 + s2 < s2 + s1
 * 比如5, 54 应该是 54 < 5
 */
public class problem3 {
	public static void main(String[] args) {
		OutputStream outputStream = System.out;
		PrintWriter out=new PrintWriter(outputStream);
		Prob3 solver=new Prob3();
		solver.solve(1, out);
		out.flush();
		out.close();
	}
	static class Prob3{
		int n;
		String s;
		public void solve(int testCase, PrintWriter out) {
			List<String> nums=new ArrayList<>();
			
			Scanner in=new Scanner(System.in);
			for(;in.hasNext();) {
				n=in.nextInt();
				for(int i=0;i<n;++i)
					nums.add(in.next());
				Collections.sort(nums, new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						String o12 = o1+o2;
						String o21 = o2+o1;
						return o21.compareTo(o12);
					}
				});
				for(String s:nums) out.print(s);out.print('\n');
				out.flush();
				nums.clear();
			}
			in.close();
		}

	}
}
/*
7-3 组最大数 (10 分)
设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
如:n=3时，3个整数13,312,343连成的最大整数为34331213。
如:n=4时，4个整数7,13,4,246连接成的最大整数为7424613。

输入格式:
有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。

输出格式:
每组数据输出一个表示最大的整数。

输入样例:
2
12 123
4
7 13 4 246
输出样例:
12312
7424613
*/
