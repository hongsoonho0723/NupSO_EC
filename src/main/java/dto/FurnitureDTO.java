package dto;

public class FurnitureDTO {
    private int FURNITURE_SEQ;
    private String FURNITURE_NUMBER;
    private String FURNITURE_NAME;
    private String FURNITURE_DISCRIPTION;
    private int PRICE;
    private int STOCK;
    private int SALE_COUNT; //판매량
    private String CATEGORY;
    private String REG_DATE;

    public FurnitureDTO() {}

    public FurnitureDTO(int FURNITURE_SEQ, String FURNITURE_NUMBER, String FURNITURE_NAME, String FURNITURE_DISCRIPTION, int PRICE, int STOCK, int SALE_COUNT, String CATEGORY, String REG_DATE) {
        this.FURNITURE_SEQ = FURNITURE_SEQ;
        this.FURNITURE_NUMBER = FURNITURE_NUMBER;
        this.FURNITURE_NAME = FURNITURE_NAME;
        this.FURNITURE_DISCRIPTION = FURNITURE_DISCRIPTION;
        this.PRICE = PRICE;
        this.STOCK = STOCK;
        this.SALE_COUNT = SALE_COUNT;
        this.CATEGORY = CATEGORY;
        this.REG_DATE = REG_DATE;
    }

    public int getFURNITURE_SEQ() {
        return FURNITURE_SEQ;
    }

    public void setFURNITURE_SEQ(int FURNITURE_SEQ) {
        this.FURNITURE_SEQ = FURNITURE_SEQ;
    }

    public String getFURNITURE_NUMBER() {
        return FURNITURE_NUMBER;
    }

    public void setFURNITURE_NUMBER(String FURNITURE_NUMBER) {
        this.FURNITURE_NUMBER = FURNITURE_NUMBER;
    }

    public String getFURNITURE_NAME() {
        return FURNITURE_NAME;
    }

    public void setFURNITURE_NAME(String FURNITURE_NAME) {
        this.FURNITURE_NAME = FURNITURE_NAME;
    }

    public String getFURNITURE_DISCRIPTION() {
        return FURNITURE_DISCRIPTION;
    }

    public void setFURNITURE_DISCRIPTION(String FURNITURE_DISCRIPTION) {
        this.FURNITURE_DISCRIPTION = FURNITURE_DISCRIPTION;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    public int getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(int STOCK) {
        this.STOCK = STOCK;
    }

    public int getSALE_COUNT() {
        return SALE_COUNT;
    }

    public void setSALE_COUNT(int SALE_COUNT) {
        this.SALE_COUNT = SALE_COUNT;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getREG_DATE() {
        return REG_DATE;
    }

    public void setREG_DATE(String REG_DATE) {
        this.REG_DATE = REG_DATE;
    }
}
