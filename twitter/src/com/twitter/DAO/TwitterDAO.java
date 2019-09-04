package com.twitter.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.twitter.entity.TwitterEmployee;

public class TwitterDAO implements TwitterDAOInterface {

	public static TwitterDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new TwitterDAO();
	}

	@Override
	public int createProfileDAO(TwitterEmployee te) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into TwitterEmployee values(?,?,?,?)");
			ps.setString(1, te.getName());
			ps.setString(2, te.getPass());
			
			ps.setString(3, te.getEmail());
			ps.setString(4, te.getAddress());
			i=ps.executeUpdate();
			System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return i;
	}

}

