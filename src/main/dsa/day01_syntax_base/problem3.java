package main.dsa.day01_syntax_base;

import java.util.Scanner;

/*
7-3 凯撒密码 (10 分)
在密码学中，恺撒密码（Caesar cipher），或称恺撒加密、恺撒变换、变换加密，是一种最简单且最广为人知的加密技术。它是一种替换加密的技术，明文中的所有字母都在字母表上向后循环按照一个固定数目进行偏移后被替换成密文。例如，当偏移量是3的时候，所有的字母A将被替换成D，B变成E，以此类推。这个加密方法是以罗马共和时期恺撒的名字命名的，当年恺撒曾用此方法与其将军们进行联系。

输入格式:
一个字符串。

输出格式:
加密的字符串。注：字符串中大写字母循环后移3位，小写字母循环后移3位，其它符号不变。

输入样例:
abc xyz!
输出样例:
def abc!

思路:模拟
 */
public class problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] chs = in.nextLine().toCharArray();
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] >= 'a' && chs[i] <= 'z') {
				chs[i] = (char) ((chs[i] - 97 + 3)%26 + 97);
			}else if (chs[i] >= 'A' && chs[i] <= 'Z') {
				chs[i] = (char) ((chs[i] - 65 + 3)%26 + 65);
			}
		}
		System.out.println(chs);
		in.close();
	}

}
