package com.github.xingli13.dao;

import com.github.xingli13.entity.GithubRepo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xingli13
 * @date 2018/10/23
 */
public class BaseDao {
	private static Connection getConnection() {
		try {
			Class.forName(DbConf.JDBC_DRIVER);
			return DriverManager.getConnection(DbConf.DB_URL, DbConf.USER, DbConf.PASS);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public static int insert(String sql, Object... args) {
		Connection conn = getConnection();
		QueryRunner queryRunner = new QueryRunner();
		ArrayHandler arrayHandler = new ArrayHandler();

		try {
			Object[] objectArr = queryRunner.insert(conn, sql, arrayHandler, args);
			if (objectArr.length == 0) {
				return -1;
			}
			return ((int) objectArr[0]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
