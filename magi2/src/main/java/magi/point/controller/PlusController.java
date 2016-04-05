package magi.point.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import magi.point.model.PointInter;

@Controller
public class PlusController {
	@Autowired
	private PointInter inter;

	@ModelAttribute("command")
	public PointBean formBack() {
		return new PointBean();
	}

	@RequestMapping(value = "plus.point", method = RequestMethod.GET)
	public ModelAndView plusPoint() {
		return new ModelAndView("index", "page", "/WEB-INF/view/point/plus.jsp");
	}

	@RequestMapping(value = "plus.point", method = RequestMethod.POST)
	public ModelAndView plusSuccess(String brand, String phone, String pluspo) {
		PointBean bean = new PointBean();
		
		int point = (int) (Integer.parseInt(pluspo)*(0.05));
		bean.setBrand(brand);
		bean.setPhone(phone);
		bean.setPluspoint(point);
		int count = inter.selectNum();
		bean.setNum(count + 1);
		inter.plus(bean);
		
		return new ModelAndView("index", "page", "home.jsp");
	}
}
