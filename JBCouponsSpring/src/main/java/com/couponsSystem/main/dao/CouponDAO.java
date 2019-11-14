package com.couponsSystem.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.couponsSystem.main.beans.Coupon;
import com.couponsSystem.main.repo.CouponRepository;

@Repository
public class CouponDAO {
	
	@Autowired
	private CouponRepository repo;
	
	public void addCoupon(Coupon coupon) {
		if (coupon != null) {
			repo.save(coupon);
		}
	}
	
	public void deleteCoupon(Coupon coupon) {
		if (coupon != null) {
			repo.delete(coupon);
		}
	}
	
	public List<Coupon> getAllCoupons() {
		return repo.findAll();
	}
}
