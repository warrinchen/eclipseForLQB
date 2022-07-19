package main.dsa.day02_cppSTL_base.copy;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class problem2 {
	public static void main(String[] args) {
		OutputStream outputStream = System.out;
		PrintWriter out=new PrintWriter(outputStream);
		Prob2 solver=new Prob2();
		solver.solve(1, out);
		out.flush();
		out.close();
	}
	
	static class Prob2{
		public void solve(int testCases, PrintWriter out) {
			Scanner ins=new Scanner(System.in);
			StringBuilder sb=new StringBuilder();
			for (;ins.hasNext();) {
				String input=ins.nextLine();
				for(char c : input.toCharArray()) {
					if(c != '#' && c!='@') sb.append(c);
					else if(c == '#' && sb.length()>0) sb.deleteCharAt(sb.length()-1);
					else if(c == '@') sb.delete(0, sb.length());
				}
				out.print(sb.toString()+"\n");
				out.flush();
				sb.delete(0, sb.length());
			}
		}
	}
}
/*
7-2 行编辑器 (10 分)
一个简单的行编辑程序的功能是：接受用户从终端输入的程序或数据，并存入用户的数据区。 由于用户在终端上进行输入时，不能保证不出差错，因此，若在编辑程序中，“每接受一个字符即存入用户数据区”的做法显然不是最恰当的。较好的做法是，设立一个输入缓冲区，用以接受用户输入的一行字符，然后逐行存入用户数据区。允许用户输入出差错，并在发现有误时可以及时更正。例如，当用户发现刚刚键入的一个字符是错的时，可补进一个退格符"#"，以表示前一个字符无效； 如果发现当前键入的行内差错较多或难以补救，则可以键入一个退行符"@"，以表示当前行中的字符均无效。 如果已经在行首继续输入'#'符号无效。

输入格式:
输入一个多行的字符序列。但行字符总数（包含退格符和退行符）不大于250。

输出格式:
按照上述说明得到的输出。

输入样例1:
在这里给出一组输入。例如：

whli##ilr#e(s#*s)
输出样例1:
在这里给出相应的输出。例如：

while(*s)
输入样例2:
在这里给出一组输入。例如：

outcha@putchar(*s=#++);
输出样例2:
在这里给出相应的输出。例如：

putchar(*s++);
*/