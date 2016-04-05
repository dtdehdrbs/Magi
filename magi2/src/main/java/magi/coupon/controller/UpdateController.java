package magi.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import magi.coupon.model.CouponInter;

@Controller
public class UpdateController {

	@Autowired
	private CouponInter inter;
	
	@RequestMapping(value="update.coupon", method=RequestMethod.GET)
	public ModelAndView detailInfo(int c_seq){
		CouponBean bean = inter.detailCoupon(c_seq);
		return new ModelAndView("updatecoupon", "c", bean);
	}
	@RequestMapping(value="update.coupon", method=RequestMethod.POST)
	public ModelAndView updateSuccess(String c_group, String c_brand, String c_name,
										String c_price, String c_img ){
		ModelAndView mav = new ModelAndView();
		CouponBean bean = new CouponBean();
		
		int c_seq = inter.getCseq();
		int c_num = inter.getCnum();
		bean.setC_seq(c_seq);
		bean.setC_num(c_num);
		bean.setC_group(c_group);
		bean.setC_brand(c_brand);
		bean.setC_name(c_name);
		bean.setC_price(c_price);
		bean.setC_img(c_img);
		inter.updateCoupon(bean);
		mav.addObject("c", bean);
		mav.addObject("page", "/WEB-INF/view/coupon/updatesuccess.jsp");
		mav.setViewName("index");
		return mav;
	}
	
}
