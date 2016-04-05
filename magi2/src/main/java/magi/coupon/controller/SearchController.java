package magi.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import magi.coupon.model.CouponInter;

@Controller
public class SearchController {
	@Autowired
	CouponInter inter;
	
	@RequestMapping(value="search.coupon", method=RequestMethod.POST)
	public ModelAndView searchProcess(CouponBean bean){
		ModelAndView mav = new ModelAndView();
		List list = inter.search(bean);
		mav.addObject("c", list);
		mav.addObject("page", "/WEB-INF/view/coupon/list.jsp");
		mav.setViewName("index");
		return mav;
	}

}
