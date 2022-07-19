package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

public class D货物摆放 {

	public static void main(String[] args) {
		long n = 2021041820210418L;
		new Prob().solve(n);
//		System.out.println(Math.sqrt(n));
	}
	static class Prob{
		long[] divs;
		public void solve(long n) {
			divs = new long[100001];
			int id = 0;
			for(int i = 1; i <= n / i; ++i) {//n的一对因子中较小的那个不会超过sqrt(n), 即 i*i < n
				if(n % i == 0) {
					if(i == n/i) {
						divs[id++] = i;
					}else {
						divs[id++] = i; //较小的那个因子
						divs[id++] = n / i;//较大个那个因子, 在这里就算到了, 因此不必算到n/2, 算到sqrt(n)即可!!!!!!!!!!!!!!!!!!!!
					}
				}
			}
//			System.out.println("因子数: "+id);
			long res = 0;
			for(int i = 0; i < id; ++i)
				for(int j = 0; j < id; ++j)
					for(int k = 0; k < id; ++k)
						if(divs[i] * divs[j] * divs[k] == n)
							res++;
			System.out.println(res);
		}

	}
}
/*
一种错误做法:求得因子数x, 然后得到答案 3 * (n-1)
错误原因: 一些数, 如4,5,6是这样的, 如6, 有(1,2,3)6种, (1,1,6)3种 两类组合, 6的答案恰等于3 * (4-1)
但是 如8, 12就不是, 因为有8=2*2*2, 12=2*2*3

正确做法: 求n的因子数, 然后遍历组合
需要注意的是: 求n因子遍历到sqrt(n)即可, 因为另一边因子可以计算出来
答案2430
*/