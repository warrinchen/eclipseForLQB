package main.dsa.day02_cppSTL_base.copy;

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
 * 模拟, 测试用例已过, 未ac
 */
public class problem8 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		Prob8 solver=new Prob8();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}

	static class Prob8{
		int n;
		Team[] teams;
		public void solve(int testCase, InputReader in, PrintWriter out) {
			n = in.nextInt();
			teams = new Team[n];
			
			for(int i=0;i<n;++i) {
				teams[i] = new Team(in.nextLine());
				for(int j=0;j<10;++j) {
					for(int k=0;k<15;k++) {
						if(k<8) teams[i].l1+=in.nextInt();
						else if(k<12) teams[i].l2+=in.nextInt();
						else teams[i].l3+=in.nextInt();
					}
				}
			}
			Arrays.sort(teams, new Comparator<Team>() {
				@Override
				public int compare(Team o1, Team o2) {
					return o1.total()==o2.total()? o1.name.compareTo(o2.name)
							: o1.total() < o1.total()? 1:-1;
				}
				
			});
			for(int i=0;i<n;++i) {
				if(i>0) out.print('\n');
				out.print(teams[i].name+" "+teams[i].total());
			}
		}
		static class Team{
			String name;
			int l1;
			int l2;
			int l3;
			int all;
			public Team(String name) {
				this.name=name;
				this.l1=0;
				this.l2=0;
				this.l3=0;
				this.all=0;
			}
			public int total() {
				if(all > 0) return all;
				all = l1;
				if(l1>800) {
					all+= l2;
					if(l2>400) all+=l3;
				}
				return all;
			}
		}
	}
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		
		public InputReader(InputStream inputStream) {
			br = new BufferedReader(new InputStreamReader(inputStream));
			st=null;
		}
		public String next() {
			while(st==null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		public String nextLine(){
			String s="";
			try {
				s= br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return s;
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
/*
7-8 FJCC-GPLT (20 分)
第114514届FujianJimeiComputerCompetition——Group ProgrammingLnddrTournament（FJCC−GPLT）正式拉开序幕，绝绝子！

主办单位：JMU_ACM

本次大赛的规则如下：

每支参赛队由 10名队员组成。

竞赛题目分3 个梯级：

基础级(L1)设8 道题，其中 5分、10 分、15分、20分的题从前往后的顺序各 2 道，满分为100分；
进阶级(L2)设 4道题，每道题25分，满分为 100分；
登顶级(L3)设3道题，每道题30分，满分为90分。
参赛队员可以在比赛中的任何时刻尝试解决任何梯级的题目。但只有当一支队伍的基础题总分超过 800分时，其本队进阶部分的题目分数才被判为有效否则本队的进阶部分有效分数为0分。只有当其进阶题有效总分超过400分时，其本队登顶部分的题目分数才被判为有效。

禁止使用虚拟机。

禁止使用双屏，无论第二屏幕是否开启。

禁止佩戴耳机等电子设备。

比赛过程中禁止触碰 USB 接口。

除通过 OMS 客户端访问比赛指定题目集外，禁止以任何形式访问任何网站。

禁止使用任何形式的即时通信工具。

禁止打开任何事先存储在机器上的电子资料以及任何纸质资料。

禁止与监考老师以外的任何人交谈。

禁止拒绝监考老师的检查要求。严禁在检查过程中擅自关闭摄像头、监考客户端。

现在，作为主办方的leader——贝神想要知道目前的队伍排名，作为打下手的你，必须火速根据场上每队每个人的得分，给出每个队伍的排名。

输入格式:
输入第一行包括一个正整数n(n≤10)表示总共队伍数

接下来n×11行依次输入n个队伍的信息，每个队伍的信息如下：

最开始输入一行非空字符串（仅由英文字母和空格构成）表示队伍的名字，保证队伍名字不重复

随后10行，表示每个队员的得分，每行15个用空格隔开的非负整数，从左到右依次代表队员的L1−1L1−2...L1−8L2−1...L2−4L3−1...L3−3的成绩。（题目保证给出的得分合法，即小于等于该题的最大分值）

输出格式:
按照每个队伍的分数从高到低输出每个队伍的名字与分数（用空格隔开），如果有分数相同，则按照字典序小的优先。

tips:字典序是指从前到后比较两个字符串大小的方法。首先比较第1个字符，如果不同则第1个字符较小的字符串更小，如果相同则继续比较第二个字符，一直这样子比较下去。（字符为空则最小）

输入样例:
3
Can be trusted again
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
We can not repair computers
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
We can repair computers
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
输出样例:
We can not repair computers 2900
We can repair computers 2900
Can be trusted again 360
*/