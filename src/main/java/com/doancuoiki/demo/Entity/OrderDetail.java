package com.doancuoiki.demo.Entity;
public class OrderDetail {
	private Book book;
	private Integer quantity;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public OrderDetail() {}
	
}
