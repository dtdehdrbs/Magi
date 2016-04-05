package magi.point.controller;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import magi.point.model.PointInter;


@Controller
public class minusController {
	@Autowired
	private PointInter inter;
	
	@RequestMapping(value="minus.point", method=RequestMethod.GET)
	public ModelAndView plusPoint(){
		return new ModelAndView("index", "page", "/WEB-INF/view/point/minus.jsp");
	}
	
	@RequestMapping(value="minus.point", method=RequestMethod.POST)
	public ModelAndView plusSuccess(String brand, String phone, String minuspo){
		PointBean bean = new PointBean();
		bean.setBrand(brand);
		bean.setPhone(phone);
		bean.setMinuspoint(Integer.parseInt(minuspo));
		int count = inter.selectNum();
		bean.setNum(count+1);
		inter.minus(bean);
		return new ModelAndView("index", "page", "/WEB-INF/view/point/plussuccess.jsp");
	}
	
}
