package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.entities.departments;
import model.entities.seller;

public class program {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		
		departments dp = new departments(1, "Books");
		seller sl = new seller(1, "book", "lucas@gmail.com",LocalDateTime.parse("1988-08-27 01:00:30", fmt), 2000.0, dp);
		
		
		System.out.println(sl);

	}

}
