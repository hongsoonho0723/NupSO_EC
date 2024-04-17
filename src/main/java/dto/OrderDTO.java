package dto;

import java.util.Date;

public class OrderDTO {
	private int orderSeq;
	private int userSeq;
	private int totalPrice;
	private int orderState;
	private String deliveryDate;
	private String regDate;
	
	public OrderDTO() {}

	public OrderDTO(int orderSeq, int userSeq, int totalPrice, int orderState, String deliveryDate, String regDate) {
		super();
		this.orderSeq = orderSeq;
		this.userSeq = userSeq;
		this.totalPrice = totalPrice;
		this.orderState = orderState;
		this.deliveryDate = deliveryDate;
		this.regDate = regDate;
	}

	
	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	
	
}
