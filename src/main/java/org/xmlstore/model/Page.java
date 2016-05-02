package org.xmlstore.model;

import java.util.Collection;

public class Page<T> {
	private Collection<T> rows;
	private int page;
	private int max;
	private int total;
	

	public Page() {
		super();
	}
	
	public Page(int page, int max, int total, Collection<T> rows) {
		super();
		this.rows = rows;
		this.page = page;
		this.max = max;
		this.total = total;
	}
	
	public Collection<T> getRows() {
		return rows;
	}
	public void setRows(Collection<T> rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
