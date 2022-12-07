package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.sellerDao;
import model.entities.departments;
import model.entities.seller;

public class sellerDaoJDBC implements sellerDao {

	private Connection conn;

	public sellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updade(seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public seller findById(Integer id)
	{
		PreparedStatement st = null;
		ResultSet rs = null;
		try 
		{
		st = conn.prepareStatement(
				"SELECT seller.*,department.Name as DepName "
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id "  
				+ "WHERE seller.Id = ?");
		
		
		st.setInt(1, id);
		rs = st.executeQuery();
		if(rs.next()) {
			
			departments dep = instantiateDepartment(rs); 
			seller obj = instantiateSeller(dep, rs);
			
			return obj;
			
		}
		
		return null;
		
	}
	catch(SQLException e) {
		
		throw new DbException(e.getMessage());
	}
		
		finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	private seller instantiateSeller(departments dep, ResultSet rs) throws SQLException {
		
		seller obj = new seller();
		obj.setId(rs.getInt("Id"));
		obj.setName("Name");
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDate(rs.getDate("BirthDate"));
		obj.setDept(dep);
		return obj;
	}

	private departments instantiateDepartment(ResultSet rs) throws SQLException {
		
		departments dep = new departments();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
