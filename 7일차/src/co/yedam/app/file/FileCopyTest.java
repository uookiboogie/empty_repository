package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		// 파일복사

		try {
			FileInputStream fis = new FileInputStream("d:/temp/image.jpg");
			FileOutputStream fos = new FileOutputStream("d:/temp/image2.jpg");
			byte[] b = new byte[100];
						
			while (true) {
				int cnt = fis.read(b);
				if(cnt ==-1) break;
				fos.write(b);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
