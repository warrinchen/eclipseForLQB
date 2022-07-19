package main.blue_bridge_cup.比赛题目.省2019_10th.Java_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;


public class A组队 {
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
		int[][] players = {
				{97,90,0,0,0},
				{92,85,96,0,0},
				{0,0,0,0,93},
				{0,0,0,80,86},
				{89,83,97,0,0},
				{82,86,0,0,0},
				{0,0,0,87,90},
				{0,97,96,0,0},
				{0,0,89,0,0},
				{95,99,0,0,0},
				{0,0,96,97,0},
				{0,0,0,93,98},
				{94,91,0,0,0},
				{0,83,87,0,0},
				{0,0,98,97,98},
				{0,0,0,93,86},
				{98,83,99,98,81},
				{93,87,92,96,98},
				{0,0,0,89,92},
				{0,99,96,95,81}
		};
		public void solve(int testCases, StreamReader in, PrintWriter out) {
//			System.out.println((7+9+9+7+8) + 90 * 5);
			int mx = 0;
			for(int i = 0; i < 20; ++i)
				for(int j = 0; j <20; ++j)
					for(int k = 0; k < 20; ++k)
						for(int l = 0; l < 20; ++l)
							for(int m = 0; m < 20; ++m)
								if(i != j && i != k && i != l && i != m
										  && j != k && j != l && j != m
													&& k != l && k != m
															  && l != m) {
									int sum = players[i][0] + players[j][1] + players[k][2] + players[l][3] + players[m][4];
									if(sum > mx)
										mx = sum;
								}
			out.print(mx);
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