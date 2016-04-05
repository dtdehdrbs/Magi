package magi.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import magi.info.model.InfoInter;
import magi.info.model.InfoService;
import magi.point.controller.PointBean;
import magi.point.model.PointInter;

@Controller
@SessionAttributes({"sessionPhone","sessionGrade"})
public class InfoController {
	@Autowired
	private InfoInter inter;
	@Autowired
	private InfoService infoService;
	@Autowired
	private PointInter pointinter;
	
	//홈화면
	@RequestMapping("begin.magi")
	public ModelAndView beginPage(){
		return new ModelAndView("index","page","home.jsp");
	}
	
	//회원가입
	@RequestMapping(value="join.info", method=RequestMethod.GET)
	public ModelAndView insertInfo(){
		return new ModelAndView("index","page","/WEB-INF/view/info/join.jsp");
	}
	@RequestMapping(value="join.info", method=RequestMethod.POST)
	public ModelAndView insertSuccssess(InfoBean bean){
		PointBean pointBean = new PointBean();
		pointBean.setBrand("가입축하기념");
		pointBean.setPhone(bean.getPhone());
		pointBean.setPluspoint(100);
		int count = pointinter.selectNum();
		pointBean.setNum(count+1);
		pointinter.plus(pointBean);
		inter.insertInfo(bean);
		return new ModelAndView("index","page", "/WEB-INF/view/info/joinsuccess.jsp");
	}
	
	//로그인
	@RequestMapping(value="login.info", method=RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("index","page","/WEB-INF/view/info/login.jsp");
	}
	@RequestMapping(value="login.info", method=RequestMethod.POST)
	public ModelAndView loginSuccess(String phone, String password, Model model){
		String page;
		ModelAndView mav=  new ModelAndView();
		int result = infoService.login(phone, password);
		if(result == 0){
			InfoBean bean = inter.detailInfo(phone);
			model.addAttribute("sessionPhone", phone);
			model.addAttribute("sessionGrade", bean.getGrade());
			page = "/WEB-INF/view/info/loginsuccess.jsp";
		}else {
			page = "/WEB-INF/view/info/loginfail.jsp";
		}
		mav.addObject("page", page);
		mav.addObject("result", result);
		mav.setViewName("index");
		return mav;
	}
	
	//로그아웃
	@RequestMapping("logout.info")
	public String logout(SessionStatus session){
		session.setComplete();
		return "redirect:/";
	}
	
	//회원정보수정
	@RequestMapping(value="update.info", method=RequestMethod.GET)
	public ModelAndView updateInfo(@ModelAttribute("sessionPhone")String sessionPhone){
		ModelAndView mav = new ModelAndView();
		InfoBean bean = inter.detailInfo(sessionPhone);
		mav.addObject("info", bean);
		mav.addObject("page", "/WEB-INF/view/info/update.jsp");
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping(value="update.info", method=RequestMethod.POST)
	public ModelAndView updateSuccess(InfoBean bean){
		inter.updateInfo(bean);
		return new ModelAndView("index", "page", "/WEB-INF/view/info/updatesuccess.jsp");
	}
	
	//회원탈퇴
	@RequestMapping("delete.info")
	public String deleteInfo(String phone,@ModelAttribute("sessionPhone")String sessionPhone){
		inter.deleteInfo(sessionPhone);
		return "redirect:/";
	}
	
	//회원정보
	   @RequestMapping("detail.info")
	   public ModelAndView detailInfo(@ModelAttribute("sessionPhone")String sessionPhone){
		  ModelAndView mav = new ModelAndView();
	      PointBean pointbean = new PointBean();
	      pointbean.setPhone(sessionPhone);
	      int totalPoint = pointinter.selectSumplus(pointbean) - pointinter.selectSumminus(pointbean);
	      InfoBean bean = new InfoBean();
	      bean.setPhone(sessionPhone);
	      bean.setTotalpoint(totalPoint);
	      inter.updatePoint(bean);
	      bean = inter.detailInfo(sessionPhone);
	      mav.addObject("info", bean);
	      mav.addObject("page", "/WEB-INF/view/info/detail.jsp");
	      mav.setViewName("index");
	      return mav;
	   }

}
