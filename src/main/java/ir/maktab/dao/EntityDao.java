package ir.maktab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ir.maktab.entities.Entity;

public abstract class EntityDao {
	protected Connection connection;
	protected PreparedStatement ps;
	protected ResultSet rs;
	private String connectionUrl = "jdbc:mysql://localhost/studentTeacherDB?user=root&password=";
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public abstract Boolean create(Entity entity) throws SQLException;

	public abstract Entity read(Integer id) throws SQLException;

	public abstract Boolean update(Entity entity) throws SQLException;

	public abstract Boolean delete(Integer id) throws SQLException;

	@Override
	protected void finalize() {
		try {
			ps.close();
			connection.close();
		} catch (Exception e) {
		}
	}
}
