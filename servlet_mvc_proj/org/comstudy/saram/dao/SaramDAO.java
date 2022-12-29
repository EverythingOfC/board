package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SaramDAO {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	static final String SELECT_ALL = "select * from saram";
	static final String INSERT = "insert into saram values(?,?,?)";
}
