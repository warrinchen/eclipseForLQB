package main.pta.GPLT校赛补题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 为什么没过? L2,L3的前置条件是递进的, L2的条件不满足, L2就没分, L3也就没分
 */
public class L108 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob{
		int N;
		Person[] persons = new Person[6];
		public void solve(int testCases, InputReader in, PrintWriter out) {
			for(int i = 0; i < 6; ++i)
				persons[i] = new Person(i);
			N = in.nextInt();
			for(int i = 0; i < N; ++i) {
				int pid,lid, qid, sc;
				String level;
				pid = in.nextInt();
				level = in.next();
				lid = level.charAt(1) - '0';
				qid = level.charAt(3) - '0';
				sc = in.nextInt();
				persons[pid].add(lid, qid, sc);
			}
			int teamSc = 0, tl1 = 0, tl2 = 0, tl3 = 0;
			for(int i = 1; i <= 5; ++i) {
				tl1 += persons[i].tl1;
				tl2 += persons[i].tl2;
				tl3 += persons[i].tl3;
			}
			teamSc = tl1;
			/* 错误形式: 
			 * if(tl1 > 300)
				teamSc += tl2;
			   if(tl2 > 125)
				teamSc += tl3;
			 */
			if(tl1 > 300) {
				teamSc += tl2;
				if(tl2 > 125)
					teamSc += tl3;
			}
			Comparator<Person> comparator = new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					if(o1.total == o2.total) return o1.pid < o2.pid ? -1 : 1;
					return o1.total < o2.total ? 1 : o1.total > o2.total ? -1 : 0;
				}
			};
			Arrays.sort(persons, 1, 6, comparator);
			out.printf("%d\n",teamSc);
			for(int i = 1; i < 6; ++i)
				out.printf("%d %d\n",persons[i].pid, persons[i].total);
		}

	}
	static class Person{
		int pid, total, tl1, tl2, tl3;
		HashMap<Integer, Integer> l1; //question_id : score
		HashMap<Integer, Integer> l2; //question_id : score
		HashMap<Integer, Integer> l3; //question_id : score
		public Person(int pid) {
			this.pid = pid;
			total = tl1 = tl2 = tl3 = 0;
			l1 = new HashMap<>();
			l2 = new HashMap<>();
			l3 = new HashMap<>();
		}
		public void add(int lid, int qid, int sc) {
			if(lid == 1) {
				Integer pre = l1.get(qid);
				if(pre != null) { //有同样题目
					if(sc > pre) { // 分更高
						l1.put(qid, sc);
						tl1 += sc - pre;
					}
				} else {
					l1.put(qid,  sc);
					tl1 += sc;
				}
			}else if(lid == 2) {
				Integer pre = l2.get(qid);
				if(pre != null) { //有同样题目
					if(sc > pre) { // 分更高
						l2.put(qid, sc);
						tl2 += sc - pre;
					}
				} else {
					l2.put(qid,  sc);
					tl2 += sc;
				}
			}else {
				Integer pre = l3.get(qid);
				if(pre != null) { //有同样题目
					if(sc > pre) { // 分更高
						l3.put(qid, sc);
						tl3 += sc - pre;
					}
				} else {
					l3.put(qid,  sc);
					tl3 += sc;
				}
			}
			refersh();
		}
		public void refersh() {
			total = tl1;
			if(tl1 > 60) {
				total += tl2;
				if(tl2 > 25)
					total += tl3;
			}
		}
	}
	static class InputReader {
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream inputStream) {
			br = new BufferedReader(new InputStreamReader(inputStream));
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
	static class StreamReader{
		StreamTokenizer st;
		public StreamReader(InputStream inputStream) {
			st = new StreamTokenizer(new BufferedReader(new InputStreamReader(inputStream)));
		}
		private void nextToken() {
			try {
				st.nextToken();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public String next() {
			nextToken();
			return st.sval;
		}
		public int nextInt() {
			nextToken();
			return (int)st.nval;
		}
	}
}
/*
input1:
5
1 L1-1 5
1 L1-1 3
1 L1-1 4
1 L1-1 2
1 L1-1 1
output1:
5
1 5
2 0
3 0
4 0
5 0

input2:
23
1 L1-8 20
1 L1-7 20
1 L1-6 15
1 L1-5 15
2 L1-8 20
2 L1-7 20
2 L1-6 15
2 L1-5 15
3 L1-8 20
3 L1-6 15
3 L1-5 15
4 L1-8 20
4 L1-7 20
4 L1-6 15
4 L1-5 15
4 L1-4 10
4 L1-3 10
1 L1-4 10
1 L1-3 10
1 L1-2 5
5 L1-3 10
5 L1-7 20
5 L1-8 20
output2:
355
1 95
4 90
2 70
3 50
5 0

input3: 全满分
75
1 L1-1 5
1 L1-2 5
1 L1-3 10
1 L1-4 10
1 L1-5 15
1 L1-6 15
1 L1-7 20
1 L1-8 20
1 L2-1 25
1 L2-2 25
1 L2-3 25
1 L2-4 25
1 L3-1 30
1 L3-2 30
1 L3-3 30
2 L1-1 5
2 L1-2 5
2 L1-3 10
2 L1-4 10
2 L1-5 15
2 L1-6 15
2 L1-7 20
2 L1-8 20
2 L2-1 25
2 L2-2 25
2 L2-3 25
2 L2-4 25
2 L3-1 30
2 L3-2 30
2 L3-3 30
3 L1-1 5
3 L1-2 5
3 L1-3 10
3 L1-4 10
3 L1-5 15
3 L1-6 15
3 L1-7 20
3 L1-8 20
3 L2-1 25
3 L2-2 25
3 L2-3 25
3 L2-4 25
3 L3-1 30
3 L3-2 30
3 L3-3 30
4 L1-1 5
4 L1-2 5
4 L1-3 10
4 L1-4 10
4 L1-5 15
4 L1-6 15
4 L1-7 20
4 L1-8 20
4 L2-1 25
4 L2-2 25
4 L2-3 25
4 L2-4 25
4 L3-1 30
4 L3-2 30
4 L3-3 30
5 L1-1 5
5 L1-2 5
5 L1-3 10
5 L1-4 10
5 L1-5 15
5 L1-6 15
5 L1-7 20
5 L1-8 20
5 L2-1 25
5 L2-2 25
5 L2-3 25
5 L2-4 25
5 L3-1 30
5 L3-2 30
5 L3-3 30
output3:
1450
1 290
2 290
3 290
4 290
5 290

input4:
71
1 L1-1 5
1 L1-2 5
1 L1-3 10
1 L1-4 10
1 L1-5 15
1 L1-6 15
1 L1-7 20
1 L1-8 20
1 L3-1 30
1 L3-2 30
1 L3-3 30
2 L1-1 5
2 L1-2 5
2 L1-3 10
2 L1-4 10
2 L1-5 15
2 L1-6 15
2 L1-7 20
2 L1-8 20
2 L2-1 25
2 L2-2 25
2 L2-3 25
2 L2-4 25
2 L3-1 30
2 L3-2 30
2 L3-3 30
3 L1-1 5
3 L1-2 5
3 L1-3 10
3 L1-4 10
3 L1-5 15
3 L1-6 15
3 L1-7 20
3 L1-8 20
3 L2-1 25
3 L2-2 25
3 L2-3 25
3 L2-4 25
3 L3-1 30
3 L3-2 30
3 L3-3 30
4 L1-1 5
4 L1-2 5
4 L1-3 10
4 L1-4 10
4 L1-5 15
4 L1-6 15
4 L1-7 20
4 L1-8 20
4 L2-1 25
4 L2-2 25
4 L2-3 25
4 L2-4 25
4 L3-1 30
4 L3-2 30
4 L3-3 30
5 L1-1 5
5 L1-2 5
5 L1-3 10
5 L1-4 10
5 L1-5 15
5 L1-6 15
5 L1-7 20
5 L1-8 20
5 L2-1 25
5 L2-2 25
5 L2-3 25
5 L2-4 25
5 L3-1 0
5 L3-2 0
5 L3-3 0
output4

input5:
75
1 L1-8 5
1 L1-8 5
1 L1-8 10
1 L1-8 10
1 L1-8 15
1 L1-8 15
1 L1-8 20
1 L1-8 20
1 L2-4 25
1 L2-4 25
1 L2-4 25
1 L2-4 25
1 L3-3 30
1 L3-3 30
1 L3-3 30
2 L1-8 5
2 L1-8 5
2 L1-8 10
2 L1-8 10
2 L1-8 15
2 L1-8 15
2 L1-8 20
2 L1-8 20
2 L2-4 25
2 L2-4 25
2 L2-4 25
2 L2-4 25
2 L3-3 30
2 L3-3 30
2 L3-3 30
3 L1-8 5
3 L1-8 5
3 L1-8 10
3 L1-8 10
3 L1-8 15
3 L1-8 15
3 L1-8 20
3 L1-8 20
3 L2-3 25
3 L2-3 25
3 L2-3 25
3 L2-3 25
3 L3-3 30
3 L3-3 30
3 L3-3 30
4 L1-8 5
4 L1-8 5
4 L1-8 10
4 L1-8 10
4 L1-8 15
4 L1-8 15
4 L1-8 20
4 L1-8 20
4 L2-4 25
4 L2-4 25
4 L2-4 25
4 L2-4 25
4 L3-3 30
4 L3-3 30
4 L3-3 30
5 L1-8 5
5 L1-8 5
5 L1-8 10
5 L1-8 10
5 L1-8 15
5 L1-8 15
5 L1-8 20
5 L1-8 20
5 L2-1 25
5 L2-1 25
5 L2-1 25
5 L2-1 25
5 L3-1 30
5 L3-1 30
5 L3-1 30
*/