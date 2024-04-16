package dto;

public class FurnitureImgDTO {
    private int FIMG_SEQ;
    private int FURN_SEQ;
    private String IMG_SRC;
    private String IMG_TYPE;

    public FurnitureImgDTO() {}

    public FurnitureImgDTO(int FIMG_SEQ, int FURN_SEQ, String IMG_SRC, String IMG_TYPE) {
        this.FIMG_SEQ = FIMG_SEQ;
        this.FURN_SEQ = FURN_SEQ;
        this.IMG_SRC = IMG_SRC;
        this.IMG_TYPE = IMG_TYPE;
    }

    public int getFIMG_SEQ() {
        return FIMG_SEQ;
    }

    public void setFIMG_SEQ(int FIMG_SEQ) {
        this.FIMG_SEQ = FIMG_SEQ;
    }

    public int getFURN_SEQ() {
        return FURN_SEQ;
    }

    public void setFURN_SEQ(int FURN_SEQ) {
        this.FURN_SEQ = FURN_SEQ;
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
}
