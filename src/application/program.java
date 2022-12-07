package application;



import model.dao.daoFactory;
import model.dao.sellerDao;
import model.entities.seller;

public class program {

	public static void main(String[] args) {
		
		
		sellerDao seller =  daoFactory.createSellerDao();
		
		System.out.println("=== teste:1 seller findById ===");
		
		seller sl = seller.findById(3);
		
		
		System.out.println(sl);
		
		
		

	}

}
