package dto;

public class CartDTO {

	private int cartSeq;
	private int userSeq;
	private int furnitureSeq;
	private int quantity;
	private String regDate;
	private String colorName;
	private String sizeVal;
	
	FurnitureDTO furnitureDTO= new FurnitureDTO();
	
	public CartDTO() {}
	
	public CartDTO(int cartSeq, int userSeq, int furnitureSeq, int quantity, String regDate) {
		this.cartSeq = cartSeq;
		this.userSeq = userSeq;
		this.furnitureSeq = furnitureSeq;
		this.quantity = quantity;
		this.regDate = regDate;
	}

	
	
	
	
	public CartDTO(int furnitureSeq, int quantity, String colorName, String sizeVal, FurnitureDTO furnitureDTO) {
		super();
		this.furnitureSeq = furnitureSeq;
		this.quantity = quantity;
		this.colorName = colorName;
		this.sizeVal = sizeVal;
		this.furnitureDTO = furnitureDTO;
	}

	public FurnitureDTO getFurnitureDTO() {
		return furnitureDTO;
	}

	public void setFurnitureDTO(FurnitureDTO furnitureDTO) {
		this.furnitureDTO = furnitureDTO;
	}

	public int getCartSeq() {
		return cartSeq;
	}

	public void setCartSeq(int cartSeq) {
		this.cartSeq = cartSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
}
