package main.dsa.day02_cppSTL_base.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/*
 * 模拟
 * java加速小技巧: 边度边输出, 边处理边输出, 用BufferedReader类读入 
 */
public class problem7 {
	public static void main(String[] args) {
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		Prob7 solve=new Prob7();
		solve.solve(1, out);
		out.flush();
		out.close();
	}
	static class Prob7{
		public void solve(int testCase, PrintWriter out) {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb;
			String b;
			try {
				sb= new StringBuilder(in.readLine());
				b=in.readLine();
				in.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			for(int i=0;i<sb.length();++i) {
				if(-1 == b.indexOf(sb.charAt(i))) {
					out.print(sb.charAt(i));
				}
			}
		}
	}
}
/*
7-7 A-B (20 分)
本题要求你计算A−B。不过麻烦的是，A和B都是字符串 —— 即从字符串A中把字符串B所包含的字符全删掉，剩下的字符组成的就是字符串A−B。

输入格式：
输入在2行中先后给出字符串A和B。两字符串的长度都不超过10 
4
 ，并且保证每个字符串都是由可见的ASCII码和空白字符组成，最后以换行符结束。

输出格式：
在一行中打印出A−B的结果字符串。

输入样例：
I love GPLT!  It's a fun game!
aeiou
输出样例：
I lv GPLT!  It's  fn gm!
*/