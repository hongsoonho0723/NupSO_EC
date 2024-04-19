package dto;

public class ImgDTO {
    private int imgSeq;
    private int furnitureSeq;
    private String imgSrc;
    private String imgType;
    private boolean isDetail; // 0: 상품 상세 설명, 1: 상품 대표 이미지 -> boolean으로 표현

    public ImgDTO() {}

    public ImgDTO(int imgSeq, int furnitureSeq, String imgSrc, String imgType, boolean isDetail) {
        this(imgSeq, imgSrc, imgType);
        this.furnitureSeq = furnitureSeq;
        this.isDetail = isDetail;
    }

    public ImgDTO(int imgSeq, String imgSrc, String imgType) {
        this.imgSeq = imgSeq;
        this.imgSrc = imgSrc;
        this.imgType = imgType;
    }

    public int getImgSeq() {
        return imgSeq;
    }

    public void setImgSeq(int imgSeq) {
        this.imgSeq = imgSeq;
    }

    public int getFurnitureSeq() {
        return furnitureSeq;
    }

    public void setFurnitureSeq(int furnitureSeq) {
        this.furnitureSeq = furnitureSeq;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public boolean isDetail() { // Getter 메서드명 수정
        return isDetail;
    }

    public void setDetail(boolean isDetail) { // Setter 메서드명 수정
        this.isDetail = isDetail;
    }
}
