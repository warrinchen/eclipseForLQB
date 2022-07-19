package main.blue_bridge_cup.简单;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P003递增序列 {

	public static void main(String[] args) {
		InputStream inputStream=System.in;
		OutputStream outputStream = System.out;
		InputReader in=new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		solver.solve(1, in, out);
		out.flush();
		out.close();
	}
	static class Prob{
		String s="VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG\n" + 
				"SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF\n" + 
				"ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA\n" + 
				"BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL\n" + 
				"YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH\n" + 
				"ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU\n" + 
				"XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR\n" + 
				"ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG\n" + 
				"MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA\n" + 
				"VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF\n" + 
				"GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC\n" + 
				"EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK\n" + 
				"PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW\n" + 
				"CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP\n" + 
				"RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS\n" + 
				"PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR\n" + 
				"JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL\n" + 
				"YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP\n" + 
				"HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN\n" + 
				"DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF\n" + 
				"LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW\n" + 
				"CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ\n" + 
				"IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI\n" + 
				"ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB\n" + 
				"HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP\n" + 
				"FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS\n" + 
				"VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ\n" + 
				"BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR\n" + 
				"RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY\n" + 
				"ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX";
		public void solve(int testCases, InputReader in, PrintWriter out) {
			int mx = 0;
			String[] ss = s.split("\n");
			//row
			for(int i = 0; i < 30; ++i)
				for(int j = 0; j < 50; ++j)
					for(int k = j + 1; k < 50; ++k)
						if(ss[i].charAt(j) < ss[i].charAt(k))
							mx++;
//			out.println(mx);
			//column
			for(int i = 0; i < 50; ++i)
				for(int j = 0; j < 30; ++j)
					for(int k = j + 1; k < 30; ++k)
						if(ss[j].charAt(i) < ss[k].charAt(i))
							mx++;
//			out.println(mx);
			//diagonal 左上右下
			for(int i = 0; i < 30; ++i)
				for(int j = 0; j < 50; ++j)
					for(int k = 1; (i + k) < 30 && (j + k) < 50; ++k)
						if(ss[i].charAt(j) < ss[i+k].charAt(j+k))
							mx++;
//			out.println(mx);
			//diagonal 左下右上
			for(int i = 0; i < 30; ++i)
				for(int j = 0; j < 50; ++j)
					for(int k = 1; (i - k) >= 0 && (j + k) < 50; ++k)
						if(ss[i].charAt(j) < ss[i - k].charAt(j + k))
							mx++;
//			out.println(mx);
			//diagonal 右上左下
			for(int i = 0; i < 30; ++i)
				for(int j = 0; j < 50; ++j)
					for(int k = 1; (i + k) < 30 && (j - k) >= 0; ++k)
						if(ss[i].charAt(j) < ss[i + k].charAt(j - k))
							mx++;
			out.print(mx);
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
