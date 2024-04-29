package dto;

import java.util.Date;

public class OrderDTO {
	private int orderSeq;
	private int userSeq;
	private int totalPrice;
	private int orderState;
	private String deliveryDate;
	private String regDate;
	private String deliveryAddr1;
	private String deliveryAddr2;
	private String deliveryName;
	private String deliveryPhone;
	private String deliveryMemo;
	
	
	
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

	//주문성공시 insert
	public OrderDTO(int userSeq,int totalPrice, String deliveryDate,String deliveryAddr1,String deliveryAddr2,
			String deliveryName,String deliveryPhone, String deliveryMemo){
		super();
		this.userSeq = userSeq;
		this.totalPrice = totalPrice;
		this.deliveryDate = deliveryDate;
		this.deliveryAddr1 = deliveryAddr1;
		this.deliveryAddr2 = deliveryAddr2;
		this.deliveryName = deliveryName;
		this.deliveryPhone = deliveryPhone;
		this.deliveryMemo = deliveryMemo;
				
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

	public String getDeliveryAddr1() {
		return deliveryAddr1;
	}

	public void setDeliveryAddr1(String deliveryAddr1) {
		this.deliveryAddr1 = deliveryAddr1;
	}

	public String getDeliveryAddr2() {
		return deliveryAddr2;
	}

	public void setDeliveryAddr2(String deliveryAddr2) {
		this.deliveryAddr2 = deliveryAddr2;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryPhone() {
		return deliveryPhone;
	}

	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	public String getDeliveryMemo() {
		return deliveryMemo;
	}

	public void setDeliveryMemo(String deliveryMemo) {
		this.deliveryMemo = deliveryMemo;
	}
	
	
	
	
	
	
	
}
