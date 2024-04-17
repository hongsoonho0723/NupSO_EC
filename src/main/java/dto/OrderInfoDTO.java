package dto;

public class OrderInfoDTO {
	private int orderInfoSeq;
	private int orderSeq;
	private int furnitureSeq;
	private int quantity;
	private String colorName;
	private int sizeVal;
	private String textureName;
	
	
	public OrderInfoDTO() {}


	public OrderInfoDTO(int orderInfoSeq, int orderSeq, int furnitureSeq, int quantity, String colorName, int sizeVal,
			String textureName) {
		super();
		this.orderInfoSeq = orderInfoSeq;
		this.orderSeq = orderSeq;
		this.furnitureSeq = furnitureSeq;
		this.quantity = quantity;
		this.colorName = colorName;
		this.sizeVal = sizeVal;
		this.textureName = textureName;
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


	public String getColorName() {
		return colorName;
	}


	public void setColorName(String colorName) {
		this.colorName = colorName;
	}


	public int getSizeVal() {
		return sizeVal;
	}


	public void setSizeVal(int sizeVal) {
		this.sizeVal = sizeVal;
	}


	public String getTextureName() {
		return textureName;
	}


	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}

	
	
}
