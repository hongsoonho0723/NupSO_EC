package dto;

import java.util.Date;

public class OrderDTO {
	private int orderSeq;
	private int userSeq;
	private int totalPrice;
	private int orderState;
	private String deliveryDate;
	private String regDate;
	
	//상세정보 가구이름 뺄때 사용하는 변수
	OrderInfoDTO orderInfo = new OrderInfoDTO();
	FurnitureDTO furniture = new FurnitureDTO();
	
	private String DeliveryState;
	
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

	
	


	public String getDeliveryState() {
		return DeliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		DeliveryState = deliveryState;
	}

	public OrderInfoDTO getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfoDTO orderInfo) {
		this.orderInfo = orderInfo;
	}

	public FurnitureDTO getFurniture() {
		return furniture;
	}

	public void setFurniture(FurnitureDTO furniture) {
		this.furniture = furniture;
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
