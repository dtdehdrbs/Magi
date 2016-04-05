package magi.resource;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import magi.basket.controller.BasketBean;
import magi.board.controller.BoardBean;
import magi.board.controller.BoardReBean;
import magi.coupon.controller.CouponBean;
import magi.coupon.model.CouponDto;
import magi.info.controller.InfoBean;
import magi.point.controller.PointBean;
import magi.point.model.PointDto;

public interface MagiSQLInter {
	//point/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Select("select count(num) from point")
	public int selectNum();
	
	@Insert("insert into point(num, brand, phone, pluspoint, minuspoint, indate) value(#{num}, #{brand}, #{phone}, #{pluspoint},0, sysdate())")
	public void plusPoint(PointBean bean);
	
	@Insert("insert into point(num, brand, phone, minuspoint, pluspoint, indate) value(#{num}, #{brand}, #{phone}, #{minuspoint},0, sysdate())")
	public void minusPoint(PointBean bean);
	
	@Select("select * from point where phone = #{phone} order by num desc limit #{start}, #{gap}")
	public List<PointDto> selectPhone(PointBean bean);
	
	@Select("select count(num) from point where phone = #{phone}")
	public int selectNumPhone(PointBean bean);
	
	@Select("select sum(pluspoint) from point where phone = #{phone}")
	public int selectSumplus(PointBean bean);
	   
	@Select("select sum(minuspoint) from point where phone = #{phone}")
	public int selectSumminus(PointBean bean);
	//basket/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Insert("Insert into basket value(#{b_seq}, #{phone}, #{c_seq}, #{count}, #{status})")
	public void insertBasket(BasketBean bean);
	
	@Select("select * from coupon where c_seq = #{c_seq}")
	public List<CouponDto> selectCseq(BasketBean bean);
	
	@Update("update basket set status = #{status} where phone = #{phone} and b_seq = #{b_seq}")
	public void updateStatus(BasketBean bean);
	
	@Select("select count(b_seq) from basket")
	public int selectBseq();
	
	//info/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Insert("insert into member values(#{name},#{phone},#{password},0,#{grade},now())")
	public int insertInfo(InfoBean bean);
	
	@Select("select password from member where phone=#{phone}")
	public String selectPW(String phone);
	
	@Select("select name, password, grade, phone, totalpoint, date_format(indate,'%Y.%m.%d') as indate from member where phone=#{phone}")
	public InfoBean detailInfo(String phone);

	@Update("update member set password=#{password}, grade=#{grade} where phone=#{phone}")
	public int updateInfo(InfoBean bean);
	
	@Delete("delete from member where phone=#{phone}")
	public int deleteInfo(String phone);
	
	@Update("update member set totalpoint = #{totalpoint} where phone=#{phone} ")
	public int updatePoint(InfoBean bean);
	//coupon///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Select("select * from coupon order by c_seq desc")
	public List<CouponDto> selectAllData(); 
	
	@Select("select count(c_num) from coupon")
	public int gettotalCount(String c_group);
	
	@Select("select * from coupon where c_group = #{c_group} limit #{start}, #{end}")
	public List<CouponBean> groupList(@Param("c_group")String c_group, @Param("start")int start, @Param("end")int end);
	
	@Select("select c_seq, c_num, c_group, c_brand, c_name, c_price, c_img from coupon where c_brand like concat('%',#{searchValue},'%') order by c_seq desc")
	public List<CouponDto> selectSearch(CouponBean bean);
	
	@Insert("insert into coupon value(#{c_seq}, #{c_num}, #{c_group}, #{c_brand}, #{c_name}, #{c_price}, #{c_img}, #{phone})")
	public void insertCoupon(CouponBean bean);
	
	@Select("select count(c_num) from coupon")
	public int selectC_seq();
	
	@Update("update coupon set c_group = #{c_group}, c_brand = #{c_brand}, c_name = #{c_name}, c_price = #{c_price}, c_img = #{c_img} where c_seq = #{c_seq}")
	public void updateCoupon(CouponBean bean);
	
	@Select("select c_seq, c_num, c_group, c_brand, c_name, c_price, c_img, phone from coupon where c_seq = #{c_seq}")
	public CouponBean detailCoupon(int c_seq);
	
	@Delete("delete from coupon where c_seq = #{c_seq}")
	public int deleteCoupon(int c_seq);
	
	//board///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		//전체 게시물 조회
		@Select("select count(seq) from board where boardtype=#{boardtype}")
		public int getTotalCount(String boardtype);
		
		@Select("select count(seq) from board")
		public int selectSeq();
		
		//페이징 리스트 조회
		@Select("select seq, boardtitle, boardwriter, boardcotent, boardviewcount, boardtime, boardtype from board where boardtype = #{boardtype} limit #{start} ,#{end}")
		public List<BoardBean> getBoardList(@Param("boardtype")String boardtype, @Param("start")int start, @Param("end")int end);
		
		//글쓰기
		@Insert("insert into board values(#{seq}, #{boardtitle}, #{boardwriter}, #{boardcotent}, now(), #{boardviewcount}, #{boardtype})")
		public int insertBoard(BoardBean bean);
		
		// 게시물 수정
		@Update("update board set boardtitle=#{boardtitle}, boardcotent=#{boardcotent}" + " where seq = #{seq}")
		public int updateBoard(BoardBean bean);
		
		//읽은 글 조회수 1씩 증가
		@Update("update board set boardviewcount = boardviewcount + 1 where seq = #{seq}")
		public int viewCount(int seq);
		
		//게시물 상세내역
		@Select("select seq, boardtitle, boardwriter, boardcotent, boardtime, boardviewcount, boardtype "
					+ "from board where seq=#{seq}")
		public BoardBean getBoardDetail(int seq);
		
		@Delete("delete from board where seq=#{seq}")
		public int deleteBoard(int seq);
		
		//댓글
		@Insert("insert into boardreply values(#{num}, #{replyseq}, #{replytitle}, #{replycontent}, #{replywriter}, 0, now(), #{replytype})")
		public int insertReply(BoardReBean bean);
		
		//댓글리스트
		@Select("select * from boardreply where replytype = #{replytype}")
		public List<BoardReBean> getReplyList(String replytype);
		
		//댓글 상세내역
		@Select("select * from boardreply where num=#{num}")
		public BoardReBean getBoardReDetail(int num);
		
		//댓글만 삭제
		@Delete("delete from boardreply where num=#{num}")
		public int redelete(int num);
		
		//글과 함께 삭제 
		@Delete("delete from boardreply where replyseq=#{replyseq}")
		public int replydelete(int replyseq);
		
		//검색
		@Select("select seq, boardtitle, boardwriter, boardcotent, boardviewcount, boardtime, boardtype from board where boardtitle like concat('%',#{searchValue},'%') order by seq desc")
		public List<BoardBean> selectsearch(BoardBean bean);
		
}
