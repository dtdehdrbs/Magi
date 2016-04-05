package magi.coupon.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import magi.coupon.model.CouponInter;

@Controller
@SessionAttributes({"sessionPhone","sessionGrade"})
public class InsertController {

	@Autowired
	private CouponInter inter;
	
	@RequestMapping(value="insert.coupon",  method=RequestMethod.GET)
	public ModelAndView insert(){
		return new ModelAndView("index","page","/WEB-INF/view/coupon/insertcoupon.jsp");
	}

	
	@RequestMapping(value="insert.coupon", method=RequestMethod.POST)
	public ModelAndView insertSuccess(String c_group, String c_brand, String c_name,
										String c_price, String c_img, @ModelAttribute("sessionPhone")String sessionPhone ) throws IOException{
		ModelAndView mav = new ModelAndView();
		CouponBean bean = new CouponBean();
		int c_seq = inter.getCseq();
		
		bean.setC_seq(c_seq+1);
		bean.setC_group(c_group);
		bean.setC_brand(c_brand);
		bean.setC_name(c_name);
		bean.setC_price(c_price);
		bean.setC_img(c_img);
		bean.setPhone(sessionPhone);
		
	    inter.insertCoupon(bean);
	    mav.addObject("c", bean);
	    mav.addObject("page", "/WEB-INF/view/coupon/insertsuccess.jsp");
	    mav.setViewName("index");
	    
		return mav;
	}
}
