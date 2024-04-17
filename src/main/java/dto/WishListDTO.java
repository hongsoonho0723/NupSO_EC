package dto;

import java.util.Date;

public class WishListDTO {
    private int wishListSeq;    // 관심목록 고유번호 (대표키)
    private int userSeq;        // 사용자 고유번호 (외래키)
    private int furnitureSeq;   // 가구 고유번호 (외래키)
    private Date regDate;       // 등록 날짜

    // 생성자
    public WishListDTO(int wishListSeq, int userSeq, int furnitureSeq, Date regDate) {
        this.wishListSeq = wishListSeq;
        this.userSeq = userSeq;
        this.furnitureSeq = furnitureSeq;
        this.regDate = regDate;
    }

    // Getters and Setters
    public int getWishListSeq() {
        return wishListSeq;
    }

    public void setWishListSeq(int wishListSeq) {
        this.wishListSeq = wishListSeq;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
