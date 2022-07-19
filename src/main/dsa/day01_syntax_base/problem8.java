package main.dsa.day01_syntax_base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 思路:  模拟
 * 最后一个监测点n,k都是最大的,还逆序, 过不了, 用cpp吧..
 */
public class problem8 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(System.out);
		int N;
		Person[] persons;
		int k;
		int ni;
		int pi;
		N = in.nextInt();
		persons = new Person[N+1];
		for(int i=1;i<persons.length;++i) persons[i] = new Person(i);
		
		for (int i = 1; i <= N; i++) {
			k = in.nextInt();
			for (int j = 0; j < k; j++) {
				ni = in.nextInt();
				pi = in.nextInt();
				persons[i].cents -= pi;
				persons[ni].cents += pi;
				persons[ni].num++;
			}
		}
//		if (N > 1e3 + 5e2) {
//			for (int i = persons.length-1; i > 0; --i) {
//				out.printf("%d %.2f\n", persons[i].id, (float)persons[i].cents/100);
//			}
//		}
		Arrays.sort(persons,1,persons.length, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if(o1.cents == o2.cents)
					if(o1.num==o2.num)
						return o1.id < o2.id ? -1 : 1;
					else
						return o1.num < o2.num ? 1:-1;
				else
					return o1.cents < o2.cents? 1 : -1;
			}
		});
		for (int i = 1; i < persons.length; i++) {
			out.printf("%d %.2f\n", persons[i].id, (float)persons[i].cents/100);
		}
		out.flush();
		out.close();
	}
	static class Person{
		int id;
		int cents;
		int num;
		
		public Person(int id) {
			this.id=id;
		}
	}
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
			st =null;
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
7-8 抢红包 (25 分)
没有人没抢过红包吧…… 这里给出N个人之间互相发红包、抢红包的记录，请你统计一下他们抢红包的收获。

输入格式：
输入第一行给出一个正整数N（≤1e4），即参与发红包和抢红包的总人数，则这些人从1到N编号。随后N行，第i行给出编号为i的人发红包的记录，格式如下：

K N1 P1 ⋯ NK PK
​

其中K（0≤K≤20）是发出去的红包个数，Ni 是抢到红包的人的编号，Pi（>0）是其抢到的红包金额（以分为单位）。注意：对于同一个人发出的红包，每人最多只能抢1次，不能重复抢。

输出格式：
按照收入金额从高到低的递减顺序输出每个人的编号和收入金额（以元为单位，输出小数点后2位）。每个人的信息占一行，两数字间有1个空格。如果收入金额有并列，则按抢到红包的个数递减输出；如果还有并列，则按个人编号递增输出。

输入样例：
10
3 2 22 10 58 8 125
5 1 345 3 211 5 233 7 13 8 101
1 7 8800
2 1 1000 2 1000
2 4 250 10 320
6 5 11 9 22 8 33 7 44 10 55 4 2
1 3 8800
2 1 23 2 123
1 8 250
4 2 121 4 516 7 112 9 10
输出样例：
1 11.63
2 3.63
8 3.63
3 2.11
7 1.69
6 -1.67
9 -2.18
10 -3.26
5 -3.26
4 -12.32
*/