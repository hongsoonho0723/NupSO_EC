package dto;

public class CartDTO {

	private int cartSeq;
	private int userSeq;
	private int funitureSeq;
	private int quantity;
	private String regDate;
	private String colorName;
	private String sizeVal;
	
	
	public CartDTO() {}
	
	public CartDTO(int cartSeq, int userSeq, int funitureSeq, int quantity, String regDate) {
		this.cartSeq = cartSeq;
		this.userSeq = userSeq;
		this.funitureSeq = funitureSeq;
		this.quantity = quantity;
		this.regDate = regDate;
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

	public int getFunitureSeq() {
		return funitureSeq;
	}

	public void setFunitureSeq(int funitureSeq) {
		this.funitureSeq = funitureSeq;
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
