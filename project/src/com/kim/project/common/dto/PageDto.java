package com.kim.project.common.dto;

public class PageDto {
	private int firstBlock;
	private int lastBlock;

	private int prevPage;
	private int nextPage;
	private int isEmpty;
	
	
	
	public int getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(int isEmpty) {
		this.isEmpty = isEmpty;
	}
	public int getFirstBlock() {
		return firstBlock;
	}
	public void setFirstBlock(int firstBlock) {
		this.firstBlock = firstBlock;
	}
	public int getLastBlock() {
		return lastBlock;
	}
	public void setLastBlock(int lastBlock) {
		this.lastBlock = lastBlock;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	@Override
	public String toString() {
		return "PageDto [firstBlock=" + firstBlock + ", lastBlock=" + lastBlock + ", prevPage=" + prevPage
				+ ", nextPage=" + nextPage + ", isEmpty=" + isEmpty + "]";
	}
	
	
}
