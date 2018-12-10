package com.pg.dtos;

import java.util.Date;

public class pgDtos {
	private int freenum;
	private String nickname;
	private String title;
	private String content;
	private int view1;
	private int like1;
	private int hate;
	private Date time;
	private int code;
	
	public pgDtos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pgDtos(int freenum, String nickname, String title, String content, int view1, int like1, int hate, Date time,
			int code) {
		super();
		this.freenum = freenum;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
		this.view1 = view1;
		this.like1 = like1;
		this.hate = hate;
		this.time = time;
		this.code = code;
	}

	public pgDtos(String opvalue, String id, String title2, String content2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "pgDtos [freenum=" + freenum + ", nickname=" + nickname + ", title=" + title + ", content=" + content
				+ ", view1=" + view1 + ", like1=" + like1 + ", hate=" + hate + ", time=" + time + ", code=" + code
				+ "]";
	}

	public int getFreenum() {
		return freenum;
	}

	public void setFreenum(int freenum) {
		this.freenum = freenum;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public int getView1() {
		return view1;
	}

	public void setView1(int view1) {
		this.view1 = view1;
	}

	public int getLike1() {
		return like1;
	}

	public void setLike1(int like1) {
		this.like1 = like1;
	}

	public int getHate() {
		return hate;
	}

	public void setHate(int hate) {
		this.hate = hate;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	
	
}
