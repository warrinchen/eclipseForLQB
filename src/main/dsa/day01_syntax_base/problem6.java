package main.dsa.day01_syntax_base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * 思路: 链表 模拟
 */
public class problem6 {
	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		Prob6 solver = new Prob6();
		solver.solve(1, in, out);
		out.close();
	}
	static class Prob6{
		int n;
		int m;
		Node head;
		public void solve(int testNum, InputReader in, PrintWriter out) {
			n=in.nextInt();
			m=in.nextInt();
			head = new Node(0, null);
			Node node = head;
			
			for (int i = 0; i < n; i++) {
				node.nextNode = new Node(in.nextInt(), null);
				node = node.nextNode;
			}
			head = head.nextNode;
			node.nextNode=head;
			for (int i = 0; i <= m; i++) {
				node = node.nextNode;
			}
			head = node;
			out.print(node.val); node=node.nextNode;
			for (int i = 1;i < n; ++i) {
				out.print(" "+node.val);
				node=node.nextNode;
			}
		}
	}
	
	static class Node{
		int val;
		Node nextNode;
		public Node(int val, Node nexNode) {
			this.val=val;
			this.nextNode=nexNode;
		}
	}
	
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		
		public InputReader(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
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
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
/*
7-6 数组循环左移 (20 分)
本题要求实现一个对数组进行循环左移的简单函数：一个数组a中存有n（>0）个整数，在不允许使用另外数组的前提下，将每个整数循环向左移m（≥0）个位置，
即将a中的数据由（a0 a1 ⋯ an−1​）变换为（am ⋯an−1 a0 a1 ⋯ am−1）（最前面的m个数循环移至最后面的m个位置）。如果还需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？

输入格式:
输入第1行给出正整数n（≤100）和整数m（≥0）；第2行给出n个整数，其间以空格分隔。

输出格式:
在一行中输出循环左移m位以后的整数序列，之间用空格分隔，序列结尾不能有多余空格。

输入样例：
8 3
1 2 3 4 5 6 7 8
输出样例：
4 5 6 7 8 1 2 3
*/