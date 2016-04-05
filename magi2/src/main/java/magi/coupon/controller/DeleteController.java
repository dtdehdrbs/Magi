package magi.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import magi.coupon.model.CouponInter;

@Controller
public class DeleteController {

	@Autowired
	private CouponInter inter;
	
	@RequestMapping("delete.coupon")
	public String deletecoupon(int c_seq){
		inter.deleteCoupon(c_seq);
		return "redirect:list.coupon";
	}
	
	
}
                                                                                                                                                                                                                   