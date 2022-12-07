package model.dao;

import java.util.List;

import model.entities.departments;

public interface departmentDao {
	
	void insert(departments obj);
	void updade(departments obj);
	void deleteById(Integer id);
	departments findById(Integer id);
	List<departments> findAll();
	

}
