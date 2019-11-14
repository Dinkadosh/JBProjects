package com.couponsSystem.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.couponsSystem.main.beans.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
