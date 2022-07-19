package main.dsa.day01_syntax_base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
7-4 考试座位号 (15 分)
 每个 PAT 考生在参加考试时都会被分配两个座位号，一个是试机座位，一个是考试座位。
 正常情况下，考生在入场时先得到试机座位号码，入座进入试机状态后，系统会显示该考生的考试座位号码，
 考试时考生需要换到考试座位就座。但有些考生迟到了，试机已经结束，他们只能拿着领到的试机座位号码求助于你，
 从后台查出他们的考试座位号码。

输入格式：
输入第一行给出一个正整数 N（≤1000），随后 N 行，每行给出一个考生的信息：准考证号 试机座位号 考试座位号。
其中准考证号由 16 位数字组成，座位从 1 到 N 编号。
输入保证每个人的准考证号都不同，并且任何时候都不会把两个人分配到同一个座位上。

考生信息之后，给出一个正整数 M（≤N），随后一行中给出 M 个待查询的试机座位号码，以空格分隔。

输出格式：
对应每个需要查询的试机座位号码，在一行中输出对应考生的准考证号和考试座位号码，中间用 1 个空格分隔。

输入样例：
4
3310120150912233 2 4
3310120150912119 4 1
3310120150912126 1 3
3310120150912002 3 2
2
3 4
输出样例：
3310120150912002 2
3310120150912119 1

 */
public class problem4 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer re = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

//		Scanner in = new Scanner(System.in);
		re.nextToken(); int N = (int)re.nval;
		Map<Integer, List> db = new HashMap<Integer, List>();
		for (int i = 0; i < N; i++) {
			re.nextToken(); long id = (long)re.nval;
			re.nextToken(); int t1 = (int)re.nval;
			re.nextToken(); int t2 = (int)re.nval;
			List seat=new ArrayList<>();
			seat.add(id);
			seat.add(t2);
			db.put(t1, seat);
		}
		re.nextToken(); int M = (int)re.nval;
		for (int i = 0; i < M; i++) {
			re.nextToken(); int a = (int)re.nval;
			List ls=db.get(a);
			System.out.println(ls.get(0) + " " + ls.get(1));
		}
//		in.close();
	}

}
