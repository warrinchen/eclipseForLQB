package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;


public class Test {
	public static void main(String[] args) {
<<<<<<< HEAD
=======
        // test for push
>>>>>>> b043307aff036ba070c66c1c3070ca3112d94822
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob solver = new Prob();
		long st = System.currentTimeMillis();
		solver.solve(1, in, out);
		long ed = System.currentTimeMillis();
		out.printf("\ntime usage: %f (s)\n", (double)(ed-st)/1000);
		out.flush();
		out.close();
	}
	static class Prob{
		
		public void solve(int testCases, InputReader in, PrintWriter out) {
			String datestr = "20220410";
			Date date = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			try {
				date = sdf.parse(datestr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println(sdf.format(date));
			Calendar ca = Calendar.getInstance();
			
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