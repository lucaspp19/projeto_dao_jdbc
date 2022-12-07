package application;

import java.util.List;
import java.util.Scanner;

import model.dao.daoFactory;
import model.dao.sellerDao;
import model.entities.departments;
import model.entities.seller;

public class program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		

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
		
		sl = seller.findById(9);
		sl.setName("joao silva");
		seller.updade(sl);
		System.out.println("update completo!");
		
		System.out.println("\n=== Teste:6 seller delete ===");
		
		System.out.print("Entre com Id que sera deletado: ");
		int id = sc.nextInt();
		seller.deleteById(id);
		
		System.out.println("delete completado!");
		
	}

}
