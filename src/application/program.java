package application;



import java.util.List;

import model.dao.daoFactory;
import model.dao.sellerDao;
import model.entities.departments;
import model.entities.seller;

public class program {

	public static void main(String[] args) {
		
		
		sellerDao seller =  daoFactory.createSellerDao();
		
		System.out.println("=== Teste:1 seller findById ===");
		
		seller sl = seller.findById(3);
		System.out.println(sl);
		
		System.out.println("\n=== Teste:2 seller findByDepartment ===");
		
		departments dep = new departments(2, null);
		List<seller> list = seller.findByDepartment(dep);
		
		for(seller obj : list) {
			
			System.out.println();
			System.out.println(obj);
		}
		
		
		
		

	}

}
