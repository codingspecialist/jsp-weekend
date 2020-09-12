package com.cos.blog.config;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {

	public static Connection getInstance() {		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();
			System.out.println("DB연결 성공");
			return conn;
		} catch (Exception e) {
			System.out.println("DB 연결시 오류가 났습니다. : "+ e.getMessage());
		}
		return null;
	}
}
