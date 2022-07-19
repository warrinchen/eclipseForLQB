package main.blue_bridge_cup.比赛题目.省2021_12th.Java_B;

import java.util.Arrays;

public class B卡片 {

	public static void main(String[] args) {
		int[] nums = new int[10];
		Arrays.fill(nums, 2021);
		int res = 0;
		boolean flag = true;
		for(int i = 1; ; ++i) {
			int j = i;
			for(;j > 9; j /= 10) {
				int t = j % 10;
				if(nums[t] > 0)
					nums[t]--;
				else {
					flag = false;
					break;
				}
			}
			if(j < 10 && nums[j] > 0) {
				nums[j]--;
				res++;
			}else {
				flag = false;
			}
			if(!flag) break;
		}
		System.out.println(res);
	}

}
