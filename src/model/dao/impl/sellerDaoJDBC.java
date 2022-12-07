package model.dao.impl;

import java.nio.channels.ReadPendingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		PreparedStatement st = null;
		try {
		st = conn.prepareStatement(
				"INSERT INTO seller " 
				+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
				+ "VALUES "  
				+ "(?, ?, ?, ?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
		
		st.setString(1, obj.getName());
		st.setString(2, obj.getEmail());
		st.setDate(3, new java.sql.Date(obj.getDate().getTime()));
		st.setDouble(4, obj.getBaseSalary());
		st.setInt(5, obj.getDept().getId());
		
		int rowsAffected = st.executeUpdate();
		
		if(rowsAffected > 0) {
			
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
				
				int id = rs.getInt(1);
				obj.setId(id);	
			}
			
			DB.closeResultSet(rs);
		}
		else {
			throw new DbException("Nenhuma linha foi alterada!");
		}
		
		}
		catch(SQLException e) {
			
			throw new DbException(e.getMessage());
		}
		finally {
			
			DB.closeStatement(st);
			
		}

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
		obj.setName(rs.getString("Name"));
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
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try 
		{
		st = conn.prepareStatement(
				
				"SELECT seller.*,department.Name as DepName "
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id "  
				+ "ORDER BY Name");
		
		
		
		rs = st.executeQuery();
		
		List<seller> list = new ArrayList();
		Map<Integer, departments> map = new HashMap();
		
		while(rs.next()) {
			
			departments dep = map.get(rs.getInt("DepartmentId"));
			
			if(dep == null) {
				 
				 dep = instantiateDepartment(rs);
				 map.put(rs.getInt("DepartmentId"), dep);
			}
			
			
			seller obj = instantiateSeller(dep, rs);
			
			list.add(obj);
			
			
		}
		
		return list;
		
	}
	catch(SQLException e) {
		
		throw new DbException(e.getMessage());
	}
		
		finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	

	@Override
	public List<seller> findByDepartment(departments dept) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try 
		{
		st = conn.prepareStatement(
				"SELECT seller.*,department.Name as DepName "
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id "  
				+ "WHERE DepartmentId = ? "
				+ "ORDER BY Name");
		
		
		st.setInt(1, dept.getId());
		rs = st.executeQuery();
		
		List<seller> list = new ArrayList();
		Map<Integer, departments> map = new HashMap();
		
		while(rs.next()) {
			
			departments dep = map.get(rs.getInt("DepartmentId"));
			
			if(dep == null) {
				 
				 dep = instantiateDepartment(rs);
				 map.put(rs.getInt("DepartmentId"), dep);
			}
			
			
			seller obj = instantiateSeller(dep, rs);
			
			list.add(obj);
			
			
		}
		
		return list;
		
	}
	catch(SQLException e) {
		
		throw new DbException(e.getMessage());
	}
		
		finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

}
