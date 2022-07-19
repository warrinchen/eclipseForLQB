package main.pta.团体程序设计天梯赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 数据结构题
public class L2006树的遍历 {

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
		int N;
		LinkedHashMap<Integer, Integer> nodes; // 后序遍历 节点值: 顺序
		int[] mids; // 中序遍历 节点值
		Node root;
		ArrayList<Integer> res = new ArrayList<>();
		public void solve(int testCases, InputReader in, PrintWriter out) {
			N = in.nextInt();
			nodes = new LinkedHashMap<>();
			mids = new int[N];
			int rootIndex = 0, rootVal = 0;
			for(int i = 1; i <= N; ++i) {
				int val = in.nextInt();
				nodes.put(val, i);
				if(i == N)
					rootVal = val;
			}
			for(int i = 0; i < N; ++i) {
				mids[i] = in.nextInt();
				if(mids[i] == rootVal)
					rootIndex = i;
			}
			root = new Node(rootVal);
			LevelOrderTraverse(0, N-1, rootIndex, out);
		}
		private int findParentId(int L, int R) {
			int id = -1, parentID = -1;
			for(int i = L; i <= R; ++i) {
				int index = nodes.get(mids[i]);
				if(index > parentID) {
					id = i;
					parentID = index;
				}
			}
			return id;
		}
		private void initTree(Node root, int L, int R, int rootId) {
			if(L > R) return ;
			int lcdId = findParentId(L, rootId - 1);
			int rcdId = findParentId(rootId + 1, R);
			if(lcdId>=0) {
				root.lcd = new Node(mids[lcdId]);
				initTree(root.lcd, L, rootId-1, lcdId);
			}
			if(rcdId>=0) {
				root.rcd = new Node(mids[rcdId]);
				initTree(root.rcd, rootId+1, R, rcdId);
			}
		}
		private void LevelOrderTraverse(int L, int R, int rootId, PrintWriter out) {
			initTree(root, L, R, rootId);
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			StringBuilder sb = new StringBuilder();
			while(!queue.isEmpty()) {
				Node node = queue.remove();
				if(node.lcd != null) queue.add(node.lcd);
				if(node.rcd != null) queue.add(node.rcd);
				sb.append(" " +node.val);
			}
			out.print(sb.substring(1));
		}
	}
	static class Node{
		int val;
		Node lcd;
		Node rcd;
		Node(int val){
			this.val = val;
			lcd = null;
			rcd = null;
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
input
7
2 3 1 5 7 6 4
1 2 3 4 5 6 7
ans
4 1 6 3 5 7 2

*/
