package dto;

public class SizeDTO {
    private int sizeSeq;       // 사이즈 고유번호 (대표키)
    private int furnitureSeq;  // 가구 고유번호 (외래키)
    private String sizeVal;   // 사이즈 명세

    // 생성자	
    public SizeDTO(int sizeSeq, int furnitureSeq, String sizeVal) {
        this(sizeVal);
        this.sizeSeq = sizeSeq;
        this.furnitureSeq = furnitureSeq;
    }

    public SizeDTO(String sizeVal) {
        this.sizeVal = sizeVal;
    }

    // Getters and Setters
    public int getSizeSeq() {
        return sizeSeq;
    }

    public void setSizeSeq(int sizeSeq) {
        this.sizeSeq = sizeSeq;
    }

    public int getFurnitureSeq() {
        return furnitureSeq;
    }

    public void setFurnitureSeq(int furnitureSeq) {
        this.furnitureSeq = furnitureSeq;
    }

    public String getsizeVal() {
        return sizeVal;
    }

    public void setsizeVal(String sizeVal) {
        this.sizeVal = sizeVal;
    }
}

