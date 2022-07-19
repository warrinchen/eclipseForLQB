package main.dsa.day02_cppSTL_base.copy;

import java.io.PrintWriter;
import java.util.Scanner;
/*
 * 思路:模拟
 */
public class problem5 {

	public static void main(String[] args) {
		PrintWriter out=new PrintWriter(System.out);
		Prob5 solver=new Prob5();
		solver.solve(1, out);
		out.flush();
		out.close();
	}
	
	static class Prob5{
		int cnt;
		int first;
		int sum;
		public void solve(int testCase, PrintWriter out) {
			Scanner in=new Scanner(System.in);
			String s;
			cnt=0;
			first=0;
			sum=0;
			for(;in.hasNext();) {
				s=in.nextLine();
				if(s.equals(".")) break;
				cnt++;
				if(s.contains("chi1 huo3 guo1")) {
					if(first==0) first=cnt;
					sum++;
				}
			}
			out.print(cnt+"\n");
			if(first!=0)
				out.print(first+" "+sum);
			else
				out.print("-_-#");
			in.close();
		}
	}

}
/*
7-5 吃火锅 (15 分)
这种天气你有什么破事打电话给我基本没用。但是如果你说“吃火锅”，那就厉害了，我们的故事就开始了。

本题要求你实现一个程序，自动检查你朋友给你发来的信息里有没有 chi1 huo3 guo1。

输入格式：
输入每行给出一句不超过 80 个字符的、以回车结尾的朋友信息，信息为非空字符串，仅包括字母、数字、空格、可见的半角标点符号。当读到某一行只有一个英文句点 . 时，输入结束，此行不算在朋友信息里。

输出格式：
首先在一行中输出朋友信息的总条数。然后对朋友的每一行信息，检查其中是否包含 chi1 huo3 guo1，并且统计这样厉害的信息有多少条。在第二行中首先输出第一次出现 chi1 huo3 guo1 的信息是第几条（从 1 开始计数），然后输出这类信息的总条数，其间以一个空格分隔。题目保证输出的所有数字不超过 100。

如果朋友从头到尾都没提 chi1 huo3 guo1 这个关键词，则在第二行输出一个表情 -_-#。

输入样例 1：
Hello!
are you there?
wantta chi1 huo3 guo1?
that's so li hai le
our story begins from chi1 huo3 guo1 le
.
输出样例 1：
5
3 2
输入样例 2：
Hello!
are you there?
wantta qi huo3 guo1 chi1huo3guo1?
that's so li hai le
our story begins from ci1 huo4 guo2 le
.
输出样例 2：
5
-_-#
*/