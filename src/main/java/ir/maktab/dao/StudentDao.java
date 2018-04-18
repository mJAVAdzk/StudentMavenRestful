package ir.maktab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import ir.maktab.entities.Entity;
import ir.maktab.entities.Student;

public class StudentDao extends EntityDao {

	private static StudentDao instance;

	@Override
	public Boolean create(Entity entity) throws SQLException {
		Student student = (Student) entity;
		String query = "insert into student(id, name, birthYear, department, teacherId) values(?,?,?,?,?)";
		ps = connection.prepareStatement(query);
		ps.setInt(1, student.getId());
		ps.setString(2, student.getName());
		ps.setInt(3, student.getBirthYear());
		ps.setString(4, student.getDepartment());
		ps.setInt(5, student.getTeacherId());
		ps.executeUpdate();
		return true;
	}

	@Override
	public Entity read(Integer id) throws SQLException {
		String query = "select * from student where id=?";
		ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Student student = new Student();
		rs.next();
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setDepartment(rs.getString(4));
		student.setBirthYear(rs.getInt(3));
		student.setTeacherId(rs.getInt(5));
		rs.close();
		return student;
	}

	@Override
	public Boolean update(Entity entity) throws SQLException {
		Student student = (Student) entity;
		String query = "update student set name=?, birthYear=?, department=?, teacherId=? where id=?";
		ps = connection.prepareStatement(query);
		ps.setString(1, student.getName());
		ps.setInt(2, student.getBirthYear());
		ps.setString(3, student.getDepartment());
		ps.setInt(4, student.getTeacherId());
		ps.setInt(5, student.getId());
		ps.executeUpdate();
		return true;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		String query = "delete from student where id=?";
		ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		return true;
	}

	public static StudentDao getInstance() {
		if (instance == null)
			instance = new StudentDao();
		return instance;
	}

	public Entity[] list() throws SQLException {
		String query = "select * from student";
		ResultSet rs = connection.prepareStatement(query).executeQuery();
		int count = 0;
		while (rs.next())
			count++;
		rs.first();
		Student[] students = new Student[count];
		int i = 0;
		while (rs.next()) {
			students[i] = new Student();
			students[i].setId(rs.getInt(1));
			students[i].setName(rs.getString(2));
			students[i].setDepartment(rs.getString(4));
			students[i].setBirthYear(rs.getInt(3));
			students[i].setTeacherId(rs.getInt(5));
			i++;
		}
		rs.close();
		return students;
	}
}
