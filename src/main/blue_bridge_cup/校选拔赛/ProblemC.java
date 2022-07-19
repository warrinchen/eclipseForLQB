package main.blue_bridge_cup.校选拔赛;

import java.util.Scanner;

/*思路
 * 1. 写数列找规律
 * 2. dfs, dfs(0)即可, 但时空复杂度爆炸
 * int all;
   int dfs(int step) {
    if (step == all) return 1;
    if (step > all) return 0;
    return dfs(step - 1) + dfs(step - 2);
   }
 * 3. 用数组dp, 如下
 */
public class ProblemC {

	public static void main(String[] args) {
		int n;
		int[] f;
		int mod = 1000000007;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		f = new int[n+1];
		f[0] = 1;
		f[1] = 1;
		for(int i=2;i<=n;++i) {
			f[i] = f[i-1]+f[i-2];
			f[i] %= mod;
		}
		System.out.println(f[n]);
		in.close();
	}

}
/*填空题
每一次可以上1阶或2阶，上2022阶台阶有多少种方法
答案需要对1e9+7（1000000007）取模
*/