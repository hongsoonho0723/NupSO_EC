package dto;

import java.util.Date;

public class WishListDTO {
    private int wishListSeq;    // 관심목록 고유번호 (대표키)
    private int userSeq;        // 사용자 고유번호 (외래키)
    private int furnitureSeq;   // 가구 고유번호 (외래키)
    private Date regDate;       // 등록 날짜
    private String colorName;
    private String sizeVal;
    
    //생성자
	public WishListDTO(int wishListSeq, int userSeq, int furnitureSeq, Date regDate, String colorName, String sizeVal) {
		super();
		this.wishListSeq = wishListSeq;
		this.userSeq = userSeq;
		this.furnitureSeq = furnitureSeq;
		this.regDate = regDate;
		this.colorName = colorName;
		this.sizeVal = sizeVal;
	}
	
	//getters and setters
	
	
	public int getWishListSeq() {
		return wishListSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public int getFurnitureSeq() {
		return furnitureSeq;
	}

	public Date getRegDate() {
		return regDate;
	}

	public String getColorName() {
		return colorName;
	}

	public String getSizeVal() {
		return sizeVal;
	}

	public void setWishListSeq(int wishListSeq) {
		this.wishListSeq = wishListSeq;
	}

	
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public void setFurnitureSeq(int furnitureSeq) {
		this.furnitureSeq = furnitureSeq;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public void setSizeVal(String sizeVal) {
		this.sizeVal = sizeVal;
	}

}
