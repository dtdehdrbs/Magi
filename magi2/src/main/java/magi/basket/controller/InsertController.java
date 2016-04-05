package magi.basket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import magi.basket.model.BasketInter;
import magi.coupon.model.CouponDto;
import magi.info.controller.InfoBean;
import magi.info.model.InfoInter;
import magi.point.controller.PointBean;
import magi.point.model.PointInter;

@Controller
public class InsertController {
	@Autowired
	private BasketInter inter;
	
	@Autowired
	private PointInter pointinter;
	
	@Autowired
	private InfoInter infointer;

	
	@RequestMapping(value="insert.basket",  method=RequestMethod.GET)
	public ModelAndView insert(String c_seq, String c_group){
		ModelAndView mav = new ModelAndView();
		
		int c_seqint = Integer.parseInt(c_seq);
		
		mav.addObject("c_group", c_group);
		mav.addObject("c_seq", c_seqint);
		mav.addObject("page", "/WEB-INF/view/basket/insertbasket.jsp");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="insert.basket", method=RequestMethod.POST)
	public ModelAndView insert(String phone, int c_seq, String count, String c_group){
		ModelAndView mav = new ModelAndView();
		BasketBean bean = new BasketBean();
		InfoBean infoBean = new InfoBean();
		infoBean = infointer.detailInfo(phone);
		
		int b_seq = inter.selectBseq();
		bean.setB_seq(b_seq+1);
		bean.setPhone(phone);
		
		bean.setC_seq(c_seq);
		List<CouponDto> list = inter.selectCseq(bean);
		int c_price = list.get(0).getC_price()*Integer.parseInt(count);
		if(c_price>infoBean.getTotalpoint()){
			mav.addObject("page", "/WEB-INF/view/basket/insertfail.jsp");
			mav.setViewName("index");
		}else{
			int c_seqint = list.get(0).getC_num();
			bean.setC_seq(c_seqint);
			bean.setCount(Integer.parseInt(count));
			bean.setStatus("미사용");
			inter.insertBasket(bean);
		
			///////////point 차감////////////////
			PointBean pointbean = new PointBean();
			int num = pointinter.selectNum();
			pointbean.setNum(num+1);
			pointbean.setBrand("쿠폰교환");
			pointbean.setPhone(phone);
		
			pointbean.setMinuspoint(c_price);//c_price 값 받기
			pointinter.minus(pointbean);
		
			mav.addObject("c_group", c_group);
			mav.addObject("page", "/WEB-INF/view/basket/insertsuccess.jsp");
			mav.setViewName("index");
		}
		return mav;
	}
	
}
