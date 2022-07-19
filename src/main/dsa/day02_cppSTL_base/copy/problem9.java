package main.dsa.day02_cppSTL_base.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class problem9 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream=System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		new Prob9().solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob9{
		Set<String> lib;
		public void solve(int testCases, InputReader in, PrintWriter out) {
			lib=new TreeSet<String>();
			int n = in.nextInt();
			String cmd;
			String arg;
			for(int i=0;i<n;++i) {
				cmd=in.next();
				arg=in.nextLine();
				if(cmd.equals("add")) lib.add(arg);
				else out.println(find(arg));
			}
		}
		String find(String book) {
			if(lib.contains(book)) return "yes";
			return "no";
		}
	}
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		
		public InputReader(InputStream inputStream) {
			br = new BufferedReader(new InputStreamReader(inputStream), 32768);
			st=null;
		}
		public String next() {
			while(st==null||!st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		public String nextLine(){
			String s="";
			try {
				if(st.hasMoreTokens()) {
					for(int i=0;st.hasMoreTokens();++i) {
						if(i!=0) s+=" "+st.nextToken();
						else s+=st.nextToken();
					}
				}else {
					s= br.readLine();
				}
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
7-9 图书管理 (20 分)
图书管理是一件十分繁杂的工作，在一个图书馆中每天都会有许多新书加入。为了更方便的管理图书（以便于帮助想要借书的客人快速查找他们是否有他们所需要的书），我们需要设计一个图书查找系统。

该系统需要支持 2 种操作：

add(s)表示新加入一本书名为s的图书。

find(s)表示查询是否存在一本书名为s的图书。

输入格式:
第一行包括一个正整数 n (n<=30000)，表示操作数。 以下n行，每行给出 2 种操作中的某一个指令条，指令格式为：

add s

find s

在书名 s 与指令（add，find）之间有一个隔开，我们保证所有书名的长度都不超过200 。可以假设读入数据是准确无误的。

输出格式:
对于每个 find(s) 指令，我们必须对应的输出一行 yes 或 no，表示当前所查询的书是否存在于图书馆内。

注意：一开始时图书馆内是没有一本图书的。并且，对于相同字母不同大小写的书名，我们认为它们是不同的。

输入样例:
4
add Inside C#
find Effective Java
add Effective Java
find Effective Java
*/