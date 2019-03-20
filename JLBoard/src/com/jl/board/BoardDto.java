package com.jl.board;

import java.util.Date;

public class BoardDto {

	private int no = 0;
	private String title ="";
	private String writer = "";
	private String content ="";
	private Date creDate = null;
	
	
	public BoardDto() {
		super();
	}


	public BoardDto(int no, String title, String writer, String content, Date creDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.creDate = creDate;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreDate() {
		return creDate;
	}


	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}


	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", creDate="
				+ creDate + "]";
	}
	
	
	
	
}
