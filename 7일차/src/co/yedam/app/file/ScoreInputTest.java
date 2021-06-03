package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class ScoreInputTest {

	public static void main(String[] args) {
		try {
			BufferedReader fr = new BufferedReader(new FileReader("d:/temp/Score.txt"));
			PrintStream out =  System.out;
			String a;
			while(true) {
				a= fr.readLine();
				String[] score = a.split(" ");
				int sum =0;
				for(String s :score) {
					sum+= Integer.parseInt(s);
				}
				System.out.println(sum);
				
				if(a==null) break;
				out.println(sum);
			}
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
