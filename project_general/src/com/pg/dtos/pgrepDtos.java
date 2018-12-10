package com.pg.dtos;

import java.sql.Date;

public class pgrepDtos {
	private int commentnum;
	private int freenum;
	private int areanum;
	private String nickname;
	private Date time;
	private int depth;
	private String content;
	private int like1;
	private int hate;
	private int refer;
	public pgrepDtos() {
		super();
	}
	public pgrepDtos(int commentnum, int freenum, int areanum, String nickname, Date time, int depth, String content,
			int like1, int hate, int refer) {
		super();
		this.commentnum = commentnum;
		this.freenum = freenum;
		this.areanum = areanum;
		this.nickname = nickname;
		this.time = time;
		this.depth = depth;
		this.content = content;
		this.like1 = like1;
		this.hate = hate;
		this.refer = refer;
	}
	@Override
	public String toString() {
		return "pgrepDtos [commentnum=" + commentnum + ", freenum=" + freenum + ", areanum=" + areanum + ", nickname="
				+ nickname + ", time=" + time + ", depth=" + depth + ", content=" + content + ", like1=" + like1
				+ ", hate=" + hate + ", refer=" + refer + "]";
	}
	public int getCommentnum() {
		return commentnum;
	}
	public void setCommentnum(int commentnum) {
		this.commentnum = commentnum;
	}
	public int getFreenum() {
		return freenum;
	}
	public void setFreenum(int freenum) {
		this.freenum = freenum;
	}
	public int getAreanum() {
		return areanum;
	}
	public void setAreanum(int areanum) {
		this.areanum = areanum;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public int getRefer() {
		return refer;
	}
	public void setRefer(int refer) {
		this.refer = refer;
	}
	
	
	
	
	
	
}
