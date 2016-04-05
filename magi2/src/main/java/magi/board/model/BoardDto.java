package magi.board.model;

public class BoardDto {
	
	private int seq;
	private String boardtitle;
	private String boardwriter;
	private String boardcotent;
	private String boardtime;
	private int boardviewcount;
	private String boardtype;
	
	public String getBoardtype() {
		return boardtype;
	}
	public void setBoardtype(String boardtype) {
		this.boardtype = boardtype;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoardwriter() {
		return boardwriter;
	}
	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}
	public String getBoardcotent() {
		return boardcotent;
	}
	public void setBoardcotent(String boardcotent) {
		this.boardcotent = boardcotent;
	}
	public String getBoardtime() {
		return boardtime;
	}
	public void setBoardtime(String boardtime) {
		this.boardtime = boardtime;
	}
	public int getBoardviewcount() {
		return boardviewcount;
	}
	public void setBoardviewcount(int boardviewcount) {
		this.boardviewcount = boardviewcount;
	}
	
	
}
