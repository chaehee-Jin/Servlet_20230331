package com.study.servlet.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.study.servlet.entity.User;
import com.study.servlet.util.DBConnectionMgr;

public class UserRepositoryImpl implements UserRepository {
	private static UserRepository instance;

	public static UserRepository getInstance() {
		if (instance == null) {
			instance = new UserRepositoryImpl();
		}
		return instance;
	}

	// DBConnction
	private DBConnectionMgr pool;

	private UserRepositoryImpl() {
		pool = DBConnectionMgr.getInstance();
	}

	@Override
	public int save(User user) {

		return 0;
	}

	@Override
	public User findUserByUsername(String username) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		int successCount = 0;

		try {
			con = pool.getConnection();
			String sql = "insert into user_mst\r\n" + "value(0, ?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			successCount = pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			pool.freeConnection(con, pstmt);
		}

		return user;
	}

}
