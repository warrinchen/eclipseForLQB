package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class C直线2 {

	public static void main(String[] args) {
		new Prob().solve(20, 21);
	}
	static class Prob{
		Map<Double, Set<Double>> lines;
		Map<Double, Set<Double>> vlines;
		Map<Double, Set<Double>> hlines;
		Set<Double> intercepts;
		int cnt;
//		int vt;
//		int ht;
//		int nt;
		double eps = 1e-7;
		PrintWriter out;
		Comparator<Double> comparator = new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				double val = o1.doubleValue() - o2.doubleValue();
				return Math.abs(val) <= eps ? 0 :
									val > 0 ? 1 : -1 ;
			}
		};
		boolean fg = false;
		public Prob(){
			try {
//				out = new PrintWriter(new FileOutputStream("d:/data/alg2.txt"));
				out = new PrintWriter(System.out);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void solve(int xs, int ys) {
			cnt = 0;
//			vt=ht=nt = 0;
			lines = new TreeMap<Double, Set<Double>>(comparator);
			vlines = new TreeMap<Double, Set<Double>>(comparator);
			hlines = new TreeMap<Double, Set<Double>>(comparator);
			Double vSlope = -40d;//指代, 这个数据是可以的, 用-1/-2就不行因为太小了, 与普通直线斜率冲突
			Double hSlope = -80d;
			for(int x1 = 0; x1 < xs; ++x1)
				for(int x2 = 0; x2 < xs; ++x2)
					for(int y1 = 0; y1 < ys; ++y1)
						for(int y2 = 0; y2 < ys; ++y2) {
							if(x1 != x2 || y1 != y2) {
								if(x1 == x2) {//vertical
									 add(vlines, vSlope, (double) x1);
								}else if(y1 ==  y2) {//horizontal
									add(hlines, hSlope, (double)y1);
								}else {//normal
									double slope = (double)(y2 - y1) / (x2 - x1);
									double inter = (double)(y1 * x2 - y2 * x1) / (x2 - x1);
									add(lines, slope, inter);
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
		private void add(Map<Double, Set<Double>> dataset, Double slope, Double inter) {
			if(dataset.containsKey(slope)) {
				intercepts = dataset.get(slope);
				if(!intercepts.contains(inter)) {
					intercepts.add(inter);
					dataset.put(slope, intercepts);
					cnt++;
//					if(dataset == vlines) {
//						fg = true;
//						vt++;
//					}
//					else if(dataset == hlines)
//						ht++;
//					else
//						nt++;
				}
			}else {
				intercepts = new TreeSet<>(comparator);
				intercepts.add(inter);
				dataset.put(slope, intercepts);
				cnt++;
//				if(dataset == vlines) {
//					fg = true;
//					vt++;
//				}
//				else if(dataset == hlines)
//					ht++;
//				else
//					nt++;
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

思路一: 模拟, 用两个整数保存斜率和截距
思路二: 模拟, 用小数保存斜率和截距, 但是要注意精度, 即以上做法
*/
