package magi.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import magi.coupon.model.CouponInter;


@Controller
@SessionAttributes({"sessionPhone","sessionGrade"})
public class DetailController {
	
	@Autowired
	private CouponInter inter;
	
	@RequestMapping("detail.coupon")
	public ModelAndView detailCoupon(int c_seq){
		ModelAndView mav = new ModelAndView();
		CouponBean bean = inter.detailCoupon(c_seq);
		mav.addObject("c", bean);
		mav.addObject("page", "/WEB-INF/view/coupon/detail.jsp");
		mav.setViewName("index");
		return mav;
	}
	
}
