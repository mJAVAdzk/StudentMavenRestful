package ir.maktab.manager;

import java.sql.SQLException;

import ir.maktab.dao.StudentDao;
import ir.maktab.entities.Entity;

public class StudentManager extends Manager {
	private static StudentManager instance;
	private StudentDao studentDao = StudentDao.getInstance();

	public static StudentManager getInstance() {
		if (instance == null)
			instance = new StudentManager();
		return instance;
	}

	@Override
	public void create(Entity entity) throws SQLException {
		studentDao.create(entity);
	}

	@Override
	public Entity read(Integer id) throws SQLException {
		return studentDao.read(id);
	}

	@Override
	public void update(Entity entity) throws SQLException {
		studentDao.update(entity);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		studentDao.delete(id);
	}

	public Entity[] list() throws SQLException {
		return studentDao.list();
	}

}
