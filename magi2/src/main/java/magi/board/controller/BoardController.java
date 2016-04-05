package magi.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import magi.board.model.BoardInter;
import magi.coupon.controller.CouponBean;


@Controller
public class BoardController {
	@Autowired
	private BoardInter inter;
	
	private int pageSize = 5;
	
	@RequestMapping(value="free.board", method=RequestMethod.GET)
	public ModelAndView free(String boardtype ,@RequestParam(value= "pageNum", defaultValue="1")String pageNum){
		
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * pageSize; //1페이지면 startRrow = 0 2페이지는 5
		int end = pageSize;
		int count = inter.getTotalCount("free");//전체 레코드 수

		List<BoardBean> list = inter.getBoardList("free", start, end);
		List<BoardReBean> replyList = inter.getReplyList("free");
		
		ModelAndView view = new ModelAndView();
		view.addObject("replyList", replyList);
		view.addObject("list", list);
		view.addObject("boardname", "자유게시판");
		view.addObject("boardtype", "free");
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pageSize", pageSize);
		view.addObject("page", "/WEB-INF/view/board/boardlist.jsp");
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping(value="notice.board", method=RequestMethod.GET)
	public ModelAndView notice(String boardtype ,@RequestParam(value= "pageNum", defaultValue="1")String pageNum){
		
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * pageSize; //1페이지면 startRrow = 0 2페이지는 5
		int end = pageSize;
		int count = inter.getTotalCount("notice");//전체 레코드 수

		List<BoardBean> list = inter.getBoardList("notice", start, end);
		List<BoardReBean> replyList = inter.getReplyList("notice");
		
		ModelAndView view = new ModelAndView();
		view.addObject("replyList", replyList);
		view.addObject("list", list);
		view.addObject("boardname", "공지사항");
		view.addObject("boardtype", "notice");
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pageSize", pageSize);
		view.addObject("page", "/WEB-INF/view/board/boardlist.jsp");
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping(value="qna.board", method=RequestMethod.GET)
	public ModelAndView qna(@RequestParam(value= "pageNum", defaultValue="1")String pageNum){
		
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * pageSize; //1페이지면 startRrow = 0 2페이지는 5
		int end = pageSize;
		int count = inter.getTotalCount("qna");//전체 레코드 수

		List<BoardBean> list = inter.getBoardList("qna" , start, end);
		List<BoardReBean> replyList = inter.getReplyList("qna");
		
		ModelAndView view = new ModelAndView();
		view.addObject("replyList", replyList);
		view.addObject("list", list);
		view.addObject("boardname", "문의사항");
		view.addObject("boardtype", "qna");
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pageSize", pageSize);
		view.addObject("page", "/WEB-INF/view/board/boardlist.jsp");
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping(value="write.board", method=RequestMethod.GET)
	public ModelAndView insertBoard(String boardtype){
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardtype", boardtype);
		mav.addObject("page", "/WEB-INF/view/board/write.jsp");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="write.board", method=RequestMethod.POST)
	public ModelAndView insertSuccess(BoardBean bean){
		//번호증가 증가
		//조회수 증가
		ModelAndView mav = new ModelAndView();
		inter.insertBoard(bean);
		mav.addObject("boardtype", bean.getBoardtype());
		mav.addObject("page", "/WEB-INF/view/board/writesuccess.jsp");
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping(value="detail.board")
	public ModelAndView readBoard(@RequestParam("seq")int seq, Model model){
		ModelAndView mav = new ModelAndView();
		BoardBean bean = inter.getBoardDetail(seq);
		mav.addObject("b", bean);
		mav.addObject("page", "/WEB-INF/view/board/detail.jsp");
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping(value="update.board", method=RequestMethod.GET)
	public ModelAndView detailInfo(int seq){
		ModelAndView mav = new ModelAndView();
		BoardBean bean = inter.getBoardDetail(seq);
		mav.addObject("b", bean);
		mav.addObject("page", "/WEB-INF/view/board/update.jsp");
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping(value="update.board", method=RequestMethod.POST)
	public ModelAndView updateSuccess(@ModelAttribute("bean") BoardBean bean){
		ModelAndView mav = new ModelAndView();
		inter.updateBoard(bean);
		mav.addObject("b", bean);
		mav.addObject("page", "/WEB-INF/view/board/updatesuccess.jsp");
		mav.setViewName("index");
		return mav;

	}
	
	@RequestMapping(value="delete.board")
	public String deleteBoard(int seq, String boardtype){
		inter.deleteBoard(seq);
		inter.replydelete(seq);
		return "redirect:/"+boardtype+".board";
	}
	
	@RequestMapping(value="reply.board", method=RequestMethod.GET)
	public ModelAndView reply(int replyseq, @ModelAttribute("boardtype") String boardtype){
		ModelAndView mav = new ModelAndView();
		BoardBean bean = inter.getBoardDetail(replyseq);
		mav.addObject("bean", bean);
		mav.addObject("page", "/WEB-INF/view/board/reply.jsp");
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping(value="reply.board", method=RequestMethod.POST)
	public ModelAndView reply(BoardReBean bean){
		ModelAndView mav = new ModelAndView();
		int result  = inter.insertReply(bean);
		mav.addObject("result", result);
		mav.addObject("boardtype", bean.getReplytype());
		mav.addObject("page", "/WEB-INF/view/board/replysuccess.jsp");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="redetail.board", method=RequestMethod.GET)
	public ModelAndView reDetail(int num){
		ModelAndView mav = new ModelAndView();
		BoardReBean bean = inter.getBoardReDetail(num);
		mav.addObject("b", bean);
		mav.addObject("page", "/WEB-INF/view/board/replydetail.jsp");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="redelete.board", method=RequestMethod.GET)
	public String reDelete(int num, String replytype){
		inter.redelete(num);
		return "redirect:/"+replytype+".board";
	}
	
	@RequestMapping(value="search.board", method=RequestMethod.POST)
	public ModelAndView searchProcess(BoardBean bean){
		ModelAndView mav = new ModelAndView();
		List list = inter.selectsearch(bean);
		mav.addObject("b", list);
		mav.addObject("page", "/WEB-INF/view/board/list.jsp");
		mav.setViewName("index");
		return mav;
	}
}
