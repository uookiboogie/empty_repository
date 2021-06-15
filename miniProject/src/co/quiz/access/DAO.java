package co.quiz.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public Connection conn;
	
	public DAO(){
		String url = "jdbc:sqlite:C:/sqlite/db/quiz.db";
		try {
			conn= DriverManager.getConnection(url);
			//System.out.println("!!!QUIZ.DB연결성공!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}