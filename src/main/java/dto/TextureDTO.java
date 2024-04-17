package dto;

public class TextureDTO {
    private int textureSeq;    // 재질 고유번호 (대표키)
    private int furnitureSeq;  // 가구 고유번호 (외래키)
    private String textureName; // 재질

    // 생성자
    public TextureDTO(int textureSeq, int furnitureSeq, String textureName) {
        this.textureSeq = textureSeq;
        this.furnitureSeq = furnitureSeq;
        this.textureName = textureName;
    }

    // Getters and Setters
    public int getTextureSeq() {
        return textureSeq;
    }

    public void setTextureSeq(int textureSeq) {
        this.textureSeq = textureSeq;
    }

    public int getFurnitureSeq() {
        return furnitureSeq;
    }

    public void setFurnitureSeq(int furnitureSeq) {
        this.furnitureSeq = furnitureSeq;
    }

    public String getTextureName() {
        return textureName;
    }

    public void setTextureName(String textureName) {
        this.textureName = textureName;
    }
}
