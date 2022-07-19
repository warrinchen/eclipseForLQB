package main.pta.团体程序设计天梯赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 图论 Dijkstra模板题
public class L2001紧急救援 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob{
		int INF = 0x7f7f7f7f;
		int N, M, S, D; // N个城市, M条路, 从S出发, 到D
		int[] teams; // 每个城市的救援队数目
		int[][] mp; // 地图
//		Map<Integer, List<Integer>> paths; //去往每个终点经过的城市
		int[] pathChain;
		int[] Distances; // 起点到各个点的路程
		int[] DTeams; // 到各个点的总救援队数
		boolean[] finded;
//		int pathCnt = 0;  // TODO 中间路径数没有记录
		int[] pathNums; // 到 i 的路径数
		
		public void solve(int testCases, InputReader in, PrintWriter out) {
			N = in.nextInt();
			M = in.nextInt();
			S = in.nextInt();
			D = in.nextInt();
			teams = new int[N];
			mp = new int[N][N];
			Distances = new int[N];
			DTeams = new int[N];
			finded = new boolean[N];
//			paths = new HashMap<>();
			pathChain = new int[N];
			pathNums = new int[N];
			for (int i = 0; i < N; i++) {
				pathChain[i] = -1;
				Distances[i] = INF;
				Arrays.fill(mp[i], INF);
				mp[i][i]= 0;         // 自己到自己的代价为 0, 此题可不加..
				teams[i] = in.nextInt();
			}
			for(int i = 0; i < M; ++i) {
				int f, t, v;
				f = in.nextInt();
				t = in.nextInt();
				v = in.nextInt();
				mp[f][t] = v;
				mp[t][f] = v;        // 无向图.
			}
			
			for(int i = 0; i < N; ++i) {
//				List<Integer> path = new ArrayList<>();
//				paths.put(i, path);
				if(mp[S][i] < INF) {
					Distances[i] = mp[S][i];
					DTeams[i] = teams[S] + teams[i];
					pathNums[i] = 1;
//					path.add(i);
				}
			}
			Distances[S] = 0;
			pathNums[S] = 1;
			finded[S] = true;
			
			for(int i = 0; i < N; ++i) {
				int p = 0, cost = INF;
				for(int j = 0; j < N; ++j)
					if(!finded[j] && Distances[j] < cost) {
						p = j;
						cost = Distances[j];
					}
				finded[p] = true;
				for(int j = 0; j < N; ++j) {
					if(!finded[j]) {
						if((Distances[p] + mp[p][j]) < Distances[j]) {
							pathNums[j] = pathNums[p];
							DTeams[j] = DTeams[p] + teams[j];
							Distances[j] = Distances[p] + mp[p][j];
//							paths.get(p).add(j);   //误
//							List<Integer> path = paths.get(p); //误
//							List<Integer> path = new ArrayList<>(paths.get(p));  //防止覆盖到p的路径
//							path.add(j);
//							paths.put(j, path);   //应该是修改到j的路径
							pathChain[j] = p;
						}else if((Distances[p] + mp[p][j]) == Distances[j]) { // 相同长度
							pathNums[j] += pathNums[p];
							// 取救援队更多的
							if(DTeams[j] < (DTeams[p] + teams[j])) {
								DTeams[j] = DTeams[p] + teams[j];
								Distances[j] = Distances[p] + mp[p][j];
//								List<Integer> path = new ArrayList<>(paths.get(p));
//								path.add(j);
//								paths.put(j, path);
								pathChain[j] = p;
							}
						}
					}
				}
			}
			out.printf("%d %d\n%d ", pathNums[D], DTeams[D], S);
			prtPath(D, out);
			out.print(D);
//			List<Integer> path = paths.get(D);
//			for(int i = 0;i < path.size(); ++i)
//				out.printf(" %d", path.get(i));
		}
		private void prtPath(int id, PrintWriter out) {
			if(pathChain[id] != -1) {
				prtPath(pathChain[id], out);
				out.print(pathChain[id] + " ");
				out.flush();
			}
		}
	}
	static class InputReader{
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
}
/*
PTA卡时间, Java过不了, 换成cpp就能过了...
测试数据:
7 9 0 4
10 20 30 40 50 60 70
0 1 1
0 2 2
0 3 1
1 5 1
1 2 1
5 4 1
2 4 1
3 6 1
6 4 1
ans : 4 170 0 3 6 4
*/

