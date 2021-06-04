package co.yedam.app.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void filecreate() throws IOException {
		// 파일 생성
		File file = new File("d:/temp/diary.txt");
		boolean result = file.createNewFile();
		System.out.println(result);
	}

	private static void makefolder() {
		File file = new File("d:/temp/image");
		file.mkdir();
	}

	private static void fileInfo() {
		File file = new File("d:/temp/image.jpg");
		System.out.println("파일크기:" + file.length());
		System.out.println("파일이름:" + file.getName());
	}
	
	private static void folerlist() {
		File file = new File("d:/temp");
		if (file.isDirectory()) {
			File[] list = file.listFiles();
			for (File f : list) {
				if (StringUtil.getExtention(f.getName()).equals("jpg")) {
					System.out.println(f.getName());
					FileUtil.copy(f.getAbsolutePath(), "d:/temp/image/" + f.getName());
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		// filecreate();
		// makefolder();
		// fileInfo();
		folerlist();

	}

}
