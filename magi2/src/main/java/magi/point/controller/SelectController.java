package magi.point.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import magi.point.model.PointDto;
import magi.point.model.PointInter;

@Controller
public class SelectController {

	@Autowired
	private PointInter inter;
	
	@RequestMapping("list.point")
	public ModelAndView selectPhone(String phone, @RequestParam(value="pageNum", defaultValue="1")String pageNum){
		int currentPage = Integer.parseInt(pageNum);
		int gap = 4;
		int start = (currentPage-1) * gap;
		PointBean bean = new PointBean();
		bean.setPhone(phone);
		bean.setStart(start);
		bean.setGap(gap);
		List<PointDto> pointlist = inter.selectPhone(bean);
		int count = (inter.selectNumPhone(bean) - 1) / gap + 1;
		ModelAndView view = new ModelAndView();
		view.addObject("pointlist", pointlist);
		view.addObject("count", count);
		view.addObject("currentPage", currentPage);
		view.addObject("page","/WEB-INF/view/point/list.jsp");
		view.setViewName("index");
		return view;
	}
}
