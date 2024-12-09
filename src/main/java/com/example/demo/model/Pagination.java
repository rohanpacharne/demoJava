package com.example.demo.model;

public class Pagination {
	
	private int totalCount;
	private int count;
	private int totalPages;
	private Object data;
	private int page;
	private int size;

	public Pagination() {
		super();
	}

	public Pagination(int totalCount, int count, int totalPages, Object data, int page, int size) {
		super();
		this.totalCount = totalCount;
		this.count = count;
		this.totalPages = totalPages;
		this.data = data;
		this.page = page;
		this.size = size;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}


	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "Pagination [totalCount=" + totalCount + ", count=" + count + ", data=" + data + ", page=" + page
				+ ", size=" + size + "]";
	}
	
	

}
