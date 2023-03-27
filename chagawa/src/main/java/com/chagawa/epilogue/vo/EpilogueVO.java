package com.chagawa.epilogue.vo;

public class EpilogueVO {
	// 글번호, 제목, 내용, 작성자, 작성일, 카풀번호, 조회수
	private long no;
	private String title, content, writer, writeDate;
	private long cpNo, hit;
	// 카풀 종료시 후기작성 0 or 1 
	private int reviewed;
	
	public int getReviewed() {
		return reviewed;
	}
	public void setReviewed(int reviewed) {
		this.reviewed = reviewed;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public long getCpNo() {
		return cpNo;
	}
	public void setCpNo(long cpNo) {
		this.cpNo = cpNo;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		return "EpilogueVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + ", cpNo=" + cpNo + ", hit=" + hit + ", reviewed=" + reviewed + "]";
	}

} // end of EpilogueVO class
