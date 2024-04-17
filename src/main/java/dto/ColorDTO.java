package dto;

public class ColorDTO {
    private int colorSeq;         // 색상 고유번호 (대표키)
    private int furnitureSeq;     // 가구 고유번호 (외래키)
    private String colorName;     // 색상 이름

    // 생성자
    public ColorDTO(int colorSeq, int furnitureSeq, String colorName) {
        this.colorSeq = colorSeq;
        this.furnitureSeq = furnitureSeq;
        this.colorName = colorName;
    }

    // Getters and Setters
    public int getColorSeq() {
        return colorSeq;
    }

    public void setColorSeq(int colorSeq) {
        this.colorSeq = colorSeq;
    }

    public int getFurnitureSeq() {
        return furnitureSeq;
    }

    public void setFurnitureSeq(int furnitureSeq) {
        this.furnitureSeq = furnitureSeq;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
