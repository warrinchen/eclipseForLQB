package main.pta.GPLT校赛补题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;
import java.util.StringTokenizer;

// StreamTokenizer全过, 自定义的InputReader就不行...
// 事后得知题目少了一个数据, 
// 而Streamtokenizer在没有数据的时候读入, 会返回上一次读入的数据, 而Scanner和BufferedReader不会
public class L104 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		StreamReader in = new StreamReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		
		out.flush();
		out.close();
		
	}
	static class Prob{
		int N;
		int[] fulls = {5,5,10,10,15,15,20,20,25,25,25,25,30,30,30};
		public void solve(int testCases, StreamReader in, PrintWriter out) {
			Scanner ins = new Scanner(System.in);
			int passed = 0;
			N = in.nextInt();
			
			for(int i = 0; i < N; ++i) {
				passed = 0;
				for(int j = 0; j < 15; ++j) {
					int sc = in.nextInt();
					if(sc == fulls[j])
						passed++;
				}
				if(passed == 15)
					out.println("xuan ak la!"); // 0
				else if(passed > 7)
					out.println("xuan hai xing ba!"); // 3
				else if(passed > 0)
					out.println("xuan jia you ba!"); // 2
				else
					out.println("xuan bao ling la!"); // 1
			}
			ins.close();
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
	static class StreamReader {
		StreamTokenizer st;
		public StreamReader(InputStream inputStream) {
			st = new StreamTokenizer(new BufferedReader(new InputStreamReader(inputStream)));
		}
        String next(){
            try {
                st.nextToken();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return st.sval;
        }
        int nextInt(){
        	try {
                st.nextToken();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return (int)st.nval;
        }
	}
}
/*
4
5 5 10 10 15 15 20 20 25 25 25 25 30 30 30
3 1 5 7 12 14 18 13 20 23 18 20 0 0 0
5 5 10 10 15 15 20 20 1 2 3 4 1 2 3
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
输入格式:
在第一行给出一个正整数N（0<N<100）,表示考卷的套数。

在接下来N行，每行给出15个整数，表示这一套试卷的详细分值，第i个整数表示第i题的得分情况。

注：天梯赛第1题至第15题的分值依次为：5,5,10,10,15,15,20,20,25,25,25,25,30,30,30

输出格式:
输出N行，第i行表示根据炫的第i套试卷的得分情况给出相应评语。

如果炫“ak”了，则打印xuan ak la!

如果炫“爆0”了，则打印xuan bao ling la!

如果炫“ac”的数量大于总题目数量的一半，则打印xuan hai xing ba!

如果炫有题目“ac”，但是“ac”的数量小于总题目数量的一半，则打印xuan jia you ba!
*/