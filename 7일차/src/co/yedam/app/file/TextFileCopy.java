package co.yedam.app.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileCopy {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("d:/temp/data.txt");
			FileWriter fw = new FileWriter("d:/temp/data3.txt");
			char[] c = new char[100];
			while(true) {
				int cnt = fr.read(c);
				if(cnt==-1) break;
				fw.write(c);
//			int c;
//			while(true) {
//				c= fr.read();
//				if(c==-1) break;
//				fw.write(c);
			}
			fr.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
