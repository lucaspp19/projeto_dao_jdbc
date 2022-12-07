package model.dao;

import java.util.List;

import model.entities.departments;
import model.entities.seller;

public interface sellerDao {
	
	void insert(seller obj);
	void updade(seller obj);
	void deleteById(Integer id);
	seller findById(Integer id);
	List<seller> findAll();
	List<seller> findByDepartment (departments dept);

}
