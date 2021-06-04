package co.memo.acess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.memo.model.Memo;

public class MemoList implements MemoAccess {
	ArrayList<Memo> memos;
	String path = "d:/temp/Memo.txt";

		public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while(true) {
				if(!scanner.hasNext())break;
				String str = scanner.next();
				String[] arr = str.split(",");
				memos.add(new Memo(arr[0],arr[1]));
			}
			scanner.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void save() {
		try {
		BufferedWriter fw = new BufferedWriter(new FileWriter(path));
		for(Memo m : memos) {
			fw.write(String.format("%s,%s\n",m.getDate(),m.getContent()));
		}
		fw.close();
	}catch(Exception e){
		e.printStackTrace();}
	}

	@Override
	public void insert(Memo memo) {
		memos.add(memo);
		save();
	}
	@Override
	public void update(Memo memo) {
		for(Memo m : memos) {
			if(m.getDate().equals(memo.getDate())) {
				m.setContent(memo.getContent()); //이게 뭐야?
				break;
			}
		}
		save();
	}
	@Override
	public void delete(String date) {
		for(Memo m : memos) {
			if(m.getDate().equals(date)) {
				memos.remove(m);
				break;
			}
		}
		save();
	}

	@Override
	public ArrayList<Memo> selectAll() {
		return memos;
	}

	@Override
	public Memo findDate(String Date) {
		for(Memo m : memos) {
			if(m.getDate().equals(Date)) {
				return m;
			}
		}
		return null;
	}

	@Override
	public Memo findContent(String content) {
		for(Memo m : memos) {
			if(m.getContent().equals(content)) {
				return m;
			}
		}
		return null;
	}
	
}
