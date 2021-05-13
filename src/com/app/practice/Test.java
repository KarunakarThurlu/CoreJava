package com.app.practice;

import java.util.List;
import java.util.Map;



public class Test  {

	public static void main(String[] args) {
		 var l=List.of(12,34,45,56,78,89,9,3,6,7,9);
		 
		 
		 l.stream().map(s->s+2).forEach(k->System.out.print(k+" "));
		 System.out.println();
		 l.stream().filter(s->s>20).forEach(k->System.out.print(k+" "));
		 System.out.println();
		 int sum= l.stream().reduce(0,(x,y)->x+y);
		 System.out.println(sum);
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
