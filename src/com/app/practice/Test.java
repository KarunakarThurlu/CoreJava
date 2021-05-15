package com.app.practice;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;



public class Test  {

	public static void main(String[] args) {

	}

	public Map<String,Integer> getOrderCountPerProduct(List<Order> orders){
		return null;
	}
}


class Order {
	private Long id;
	private List<OrderItem> orderItemList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
}
class OrderItem {
	private Long id;
	private String product;
	private Integer qty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
