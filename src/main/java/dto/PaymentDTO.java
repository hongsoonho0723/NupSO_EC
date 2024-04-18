package dto;

public class PaymentDTO {
	
	private int orderInfoSeq;
	private int orderSeq;
	private int furnitureSeq;
	private int quantity;
	
		
	public PaymentDTO(int orderInfoSeq, int orderSeq, int furnitureSeq, int quantity) {
		super();
		this.orderInfoSeq = orderInfoSeq;
		this.orderSeq = orderSeq;
		this.furnitureSeq = furnitureSeq;
		this.quantity = quantity;
	}
	
	
	public int getOrderInfoSeq() {
		return orderInfoSeq;
	}
	public void setOrderInfoSeq(int orderInfoSeq) {
		this.orderInfoSeq = orderInfoSeq;
	}
	public int getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}
	public int getFurnitureSeq() {
		return furnitureSeq;
	}
	public void setFurnitureSeq(int furnitureSeq) {
		this.furnitureSeq = furnitureSeq;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
