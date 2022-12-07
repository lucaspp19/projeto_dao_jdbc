package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.daoFactory;
import model.dao.sellerDao;
import model.entities.departments;
import model.entities.seller;

public class program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		

		sellerDao seller = daoFactory.createSellerDao();

		System.out.println("=== Teste:1 seller findById ===");

		seller sl = seller.findById(3);
		System.out.println(sl);

		System.out.println("\n=== Teste:2 seller findByDepartment ===");

		departments dep = new departments(2, null);
		List<seller> list = seller.findByDepartment(dep);

		for (seller obj : list) {

			System.out.println();
			System.out.println(obj);
		}

		System.out.println("\n=== Teste:3 seller findByAll ===");

		list = seller.findAll();

		for (seller obj : list) {

			System.out.println();
			System.out.println(obj);
		}
		
		/*
		System.out.println("\n=== Teste:4 seller insert ===");
		seller newSeller = new seller (null, "Max", "Max@hotmail.com", new Date(), 7000.0, dep);

		seller.insert(newSeller);
		
		System.out.println("Novo Id inserido: " + newSeller.getId());
		
		*/
		
		System.out.println("\n=== Teste:5 seller update ===");
		
		sl = seller.findById(10);
		sl.setName("joao silva");
		seller.updade(sl);
		System.out.println("update completo!");
		
		
	}

}
