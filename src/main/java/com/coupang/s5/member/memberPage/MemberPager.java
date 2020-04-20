package com.coupang.s5.member.memberPage;

public class MemberPager {
	
	private Long curPage;
	private Integer perPage;
	
	private long startRow;
	private long lastRow;
	
	private long totalPage;
	private long totalBlock;
	private long curBlock;
	private long startNum;
	private long lastNum;
	
	private String kind;
	private String search;
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow= this.getCurPage()*this.getPerPage();
	}
	
	public void makePage(long totalCount) {
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			this.totalPage++;
		}
		long perBlock=5L;
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			this.totalBlock++;
		}
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = this.curBlock*perBlock;
		
		if(this.curBlock==totalBlock) {
			this.lastNum=this.totalPage;
		}
		
	}

	
	
	
	public Long getCurPage() {
		if(this.curPage ==null || this.curPage==0) {
			this.curPage=1L;
		}
		return curPage;
	}
	public Integer getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage=10;
		}
		return perPage;
	}
	public long getStartRow() {
		return startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public long getTotalBlock() {
		return totalBlock;
	}
	public long getCurBlock() {
		return curBlock;
	}
	public long getStartNum() {
		return startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public String getKind() {
		return kind;
	}
	public String getSearch() {
		if(this.search ==null) {
			this.search ="";
		}
		return search;
	}
	
}
