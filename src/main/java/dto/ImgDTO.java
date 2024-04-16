package dto;

public class ImgDTO {
    private int IMG_SEQ;
    private int FURNITURE_SEQ;
    private String IMG_SRC;
    private String IMG_TYPE;
    private int IS_DETAIL; // 0:상품 상세 설명 , 1:상품 대표 이미지

    public ImgDTO() {}

    public ImgDTO(int IMG_SEQ, int FURNITURE_SEQ, String IMG_SRC, String IMG_TYPE, int IS_DETAIL) {
        this(IMG_SEQ,IMG_SRC,IMG_TYPE);
        this.FURNITURE_SEQ = FURNITURE_SEQ;
        this.IS_DETAIL = IS_DETAIL;
    }

    public ImgDTO(int IMG_SEQ, String IMG_SRC, String IMG_TYPE) {
        this.IMG_SEQ = IMG_SEQ;
        this.IMG_SRC = IMG_SRC;
        this.IMG_TYPE = IMG_TYPE;
    }

    public int getIMG_SEQ() {
        return IMG_SEQ;
    }

    public void setIMG_SEQ(int IMG_SEQ) {
        this.IMG_SEQ = IMG_SEQ;
    }

    public int getFURNITURE_SEQ() {
        return FURNITURE_SEQ;
    }

    public void setFURNITURE_SEQ(int FURNITURE_SEQ) {
        this.FURNITURE_SEQ = FURNITURE_SEQ;
    }

    public String getIMG_SRC() {
        return IMG_SRC;
    }

    public void setIMG_SRC(String IMG_SRC) {
        this.IMG_SRC = IMG_SRC;
    }

    public String getIMG_TYPE() {
        return IMG_TYPE;
    }

    public void setIMG_TYPE(String IMG_TYPE) {
        this.IMG_TYPE = IMG_TYPE;
    }

    public int isIS_DETAIL() {
        return IS_DETAIL;
    }

    public void setIS_DETAIL(int IS_DETAIL) {
        this.IS_DETAIL = IS_DETAIL;
    }
}
