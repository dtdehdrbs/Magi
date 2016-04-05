package magi.coupon.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import magi.coupon.model.CouponInter;

@Controller
public class ListController {

	@Autowired
	private CouponInter inter;
	
	private int pageSize = 5;
	
	
	@RequestMapping("list.coupon")
	public Model process(Model model){
		model.addAttribute("c", inter.list());
		return model;

	}
	
	@RequestMapping("group.coupon")
	public ModelAndView groupList(){
		return new ModelAndView("index", "page", "/WEB-INF/view/coupon/group.jsp");
		
	}
	
	@RequestMapping(value="food.coupon", method=RequestMethod.GET)
	public ModelAndView food(String c_group ,@RequestParam(value= "pageNum", defaultValue="1")String pageNum){
	
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * pageSize; //1페이지면 startRrow = 0 2페이지는 5
		int end = pageSize;
		int count = inter.gettotalCount(c_group);//전체 레코드 수
		
		List<CouponBean> list = inter.getgroupList("food", start, end);
		

		ModelAndView view = new ModelAndView();
		view.addObject("list", list);
		view.addObject("c_group", "food");
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pageSize", pageSize);
		view.addObject("page", "/WEB-INF/view/coupon/grouplist.jsp");
		view.setViewName("index");
		return view;

	}
	
	@RequestMapping(value="store.coupon", method=RequestMethod.GET)
	public ModelAndView store(String c_group ,@RequestParam(value= "pageNum", defaultValue="1")String pageNum){
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * pageSize; //1페이지면 startRrow = 0 2페이지는 5
		int end = pageSize;
		int count = inter.gettotalCount("store");//전체 레코드 수

		List<CouponBean> list = inter.getgroupList("store", start, end);
		
		ModelAndView view = new ModelAndView();
		view.addObject("list", list);
		view.addObject("c_group", "store");
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pageSize", pageSize);
		view.addObject("page", "/WEB-INF/view/coupon/grouplist.jsp");
		view.setViewName("index");
		return view;

	}
	
	@RequestMapping(value="cafe.coupon", method=RequestMethod.GET)
	public ModelAndView cafe(String c_group ,@RequestParam(value= "pageNum", defaultValue="1")String pageNum){
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * pageSize; //1페이지면 startRrow = 0 2페이지는 5
		int end = pageSize;
		int count = inter.gettotalCount("cafe");//전체 레코드 수

		List<CouponBean> list = inter.getgroupList("cafe", start, end);
		
		ModelAndView view = new ModelAndView();
		view.addObject("list", list);
		view.addObject("c_group", "cafe");
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pageSize", pageSize);
		view.addObject("page", "/WEB-INF/view/coupon/grouplist.jsp");
		view.setViewName("index");
		return view;

	}
	
	@RequestMapping(value="etc.coupon", method=RequestMethod.GET)
	public ModelAndView etc(String c_group ,@RequestParam(value= "pageNum", defaultValue="1")String pageNum){
	
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * pageSize; //1페이지면 startRrow = 0 2페이지는 5
		int end = pageSize;
		int count = inter.gettotalCount("etc");//전체 레코드 수

		List<CouponBean> list = inter.getgroupList("etc", start, end);
		
		ModelAndView view = new ModelAndView();
		view.addObject("list", list);
		view.addObject("c_group", "etc");
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pageSize", pageSize);
		view.addObject("page", "/WEB-INF/view/coupon/grouplist.jsp");
		view.setViewName("index");
		return view;

	}

}
