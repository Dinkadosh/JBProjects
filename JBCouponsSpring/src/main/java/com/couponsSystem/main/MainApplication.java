package com.couponsSystem.main;

import java.sql.Date;

import org.springframework.boot.SpringApplication;

import com.couponsSystem.main.beans.Company;
import com.couponsSystem.main.beans.Coupon;
import com.couponsSystem.main.beans.Coupon.Category;
import com.couponsSystem.main.beans.Customer;
import com.couponsSystem.main.dao.CompanyDAO;
import com.couponsSystem.main.dao.CouponDAO;
import com.couponsSystem.main.dao.CustomerDAO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
		System.out.println("GO!");
		
		CompanyDAO companyDAO = ctx.getBean(CompanyDAO.class);
		CustomerDAO customerDAO = ctx.getBean(CustomerDAO.class);
		CouponDAO couponDAO = ctx.getBean(CouponDAO.class);
		
		Company c1 = new Company("IBM", "ibm@ibm.com", "passwordIBM");
		Company c2 = new Company("Apple", "Apple@apple.com", "passwordApple");
		
		Customer cus1 = new Customer("Michael", "Zhebov", "zhebov@gmail.com", "1234");
		Customer cus2 = new Customer("irina", "Zhebov", "irina@gmail.com", "12344");
		
		Coupon coupon1 = new Coupon(c1, Category.Computer, "20%", "20% discount for all PC", new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime() + 1000000000), 10, 340.00, "url");
		Coupon coupon2 = new Coupon(c2, Category.Sport, "30%", "30% discount for all", new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime() + 1000000000), 5, 100.00, "url");
		
		c1.addCoupon(coupon2);
		c2.addCoupon(coupon1);
		
		cus1.addCoupon(coupon2);
		
		cus2.addCoupon(coupon1);
		
		couponDAO.addCoupon(coupon1);
		couponDAO.addCoupon(coupon2);
		
		companyDAO.addCompany(c1);
		companyDAO.addCompany(c2);
		
		customerDAO.addCustomer(cus1);
		customerDAO.addCustomer(cus2);
		
		System.out.println(couponDAO.getAllCoupons());
		System.out.println(customerDAO.getAllCustomers());
		System.out.println(companyDAO.getAllCompanies());
		System.out.println(c1);
}

}
