package ir.maktab.manager;

import java.sql.SQLException;

import ir.maktab.entities.Entity;

public abstract class Manager {

	public abstract void create(Entity entity) throws SQLException;

	public abstract Entity read(Integer id) throws SQLException;

	public abstract void update(Entity entity) throws SQLException;

	public abstract void delete(Integer id) throws SQLException;
}
