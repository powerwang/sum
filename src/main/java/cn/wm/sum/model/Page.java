package cn.wm.sum.model;

import java.util.List;

public class Page<T> {

	
	private int pageSize =2;
	private int pageNo =1;
	private int resultsNum;
	@SuppressWarnings("unused")
	private int pageTotalNum;
	private List<T> list ;
	
	public boolean hasPreviousPage(){
		return this.getPageNo() > 1;
	}
	
	public boolean hasNextPage() {
		return this.getPageNo() < this.getPageTotalNum();
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getResultsNum() {
		return resultsNum;
	}
	public void setResultsNum(int resultsNum) {
		this.resultsNum = resultsNum;
	}
	
	public int getPageTotalNum() {
		return ((this.pageSize+this.resultsNum)-1)/this.pageSize;
	}
//	public void setPageTotalNum(int pageTotalNum) {
//		this.pageTotalNum = pageTotalNum;
//	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
