package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class C直线 {

	public static void main(String[] args) {
		new Prob().solve(20, 21);
	}
	static class Prob{
		Map<Pair, Set<Pair>> lines;//直线map 斜率:截距 |y|/|x|, 垂直1/0, 平行0/0
		Set<Pair> intercepts;//截距set
		int cnt;
//		int vt;
//		int ht;
//		int nt;
		PrintWriter out;
		Comparator<Pair> comp = new Comparator<Pair>() {//小于这个偏序关系一定在定义域上要满足传递性
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.y==0 && o1.x==0 && o2.y==0 && o2.x==0)
					return 0;
				if(o1.y==0 && o1.x==0)
					return -1;
				if(o2.y==0 && o2.x==0)
					return 1;
				int n1 = o1.y * o2.x;
				int n2 = o2.y * o1.x;
				return n1 == n2 ? 0 : n1 > n2 ? 1 : -1; // 如果没有前面第2,3个if, 且只有后半段, 当只有有一个点为(0,0)时, n1==n2, 如果返回-1, 显然不对
			}
		};
//		boolean fg = false;
		public Prob(){
			try {
//				out = new PrintWriter(new FileOutputStream("d:/data/alg1.txt"));
				out = new PrintWriter(System.out);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void solve(int xs, int ys) {
			cnt = 0;
//			vt=ht=nt = 0;
			lines = new TreeMap<>(comp);
			Pair vSlope = new Pair(1, 0);//垂直
			Pair hSlope = new Pair(0, 0);//水平
			for(int x1 = 0; x1 < xs; ++x1)
				for(int x2 = 0; x2 < xs; ++x2)
					for(int y1 = 0; y1 < ys; ++y1)
						for(int y2 = 0; y2 < ys; ++y2) {
							if(x1 != x2 || y1 != y2) {//成直线
								if(x1 == x2) {//垂直
									Pair inter = new Pair(x1, 1);
									add(vSlope, inter);
								}else if(y1 == y2) {//水平
									Pair inter = new Pair(y1, 1);
									add(hSlope, inter);
								}else {//普通直线
									Pair slope = new Pair(y2 - y1, x2 - x1);
									Pair inter = new Pair(y1 * x2 - y2 * x1, x2 - x1); // 这里有可能出现第一个参数为0的情况, 因此Pair的构造函数统一表示为(0,0)
									add(slope, inter);
								}
//								if(fg) {
//									out.println("\t("+x1+","+y1+") ("+x2+","+y2+")");
//									fg = false;
//								}
							}
						}
			out.println(cnt);
//			out.print("vt: " + vt + " ht: " + ht + " nt: " + nt + "\n");
			out.flush();
			out.close();
		}
		private void add(Pair slope, Pair inter) {
			if(lines.containsKey(slope)) {//有同斜率
				intercepts = lines.get(slope);
				if(!intercepts.contains(inter)) { // 没有相同截距
					intercepts.add(inter);
					lines.put(slope, intercepts);
//					out.print("已有斜率: "+slope.y+" / "+slope.x+" 新增截距: " +inter.y+" / "+inter.x);
//					if(slope.y == 1 && slope.x == 0) {
//						fg = true;
//						vt++;
//					}
//					else if(slope.y == 0 && slope.x == 0)
//						ht++;
//					else
//						nt++;
					cnt++;
					if(slope.y == 10 && slope.x == 19 && inter.y == 0 && inter.x == 0) {
						out.println();
						for(Pair p: intercepts) {
							out.println(p.y+" "+p.x);
						}
						out.print("  inter size: "+intercepts.size()+"  ");
					}
//					fg = true;
				}
			}else {//无同斜率
				intercepts = new TreeSet<>(comp);
				intercepts.add(inter);
				lines.put(slope, intercepts);
//				out.print("斜率: "+slope.y+" / "+slope.x+" 新增截距: " +inter.y+" / "+inter.x);
//				if(slope.y == 1 && slope.x == 0) {
//					fg = true;
//					vt++;
//				}
//				else if(slope.y == 0 && slope.x == 0)
//					ht++;
//				else
//					nt++;
				cnt++;
//				fg = true;
			}
		}
		static class Pair{
			int y;
			int x;
			public Pair(int y, int x) {
				this.y = Math.abs(y);
				if(y < 0 && x < 0) x = -x;
				else if(y < 0 && x > 0) x = -x; // 把负号统一归到x
				else if(y == 0) x = 0;
				this.x = x;
				//化简分数
				int d = 0;
				int ty = this.y;
				int tx = Math.abs(this.x);
				if(ty > tx) d = gcd(ty,tx);
				else d = gcd(tx,ty);
				if(d != 0) {
//					if(d > 1) System.out.println(d);
					this.y /= d;
					this.x /= d;
				}
			}
			private int gcd(int a, int b) {
				return b == 0 ? a : gcd(b, a % b);
			}
		}
	}
}
/*
x轴有x个数, y轴有y个数, 都从0起, 求这些数组成的点 组成的不重叠直线有多少条
样例
x=2, y=3 结果为11
问 x=20, y=21时数目
答案是40257

思路一: 模拟, 用两个整数保存斜率和截距, 即以上做法, 但是要注意Comparator的定义是否满足传递性, 分数要化简
思路二: 模拟, 用小数保存斜率和截距, 但是要注意精度
*/
