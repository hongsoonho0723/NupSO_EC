package dto;

import java.util.List;

public class FurnitureDTO {
    private int furnitureSeq;
    private String furnitureNumber;
    private String furnitureName;
    private String furnitureDescription;
    private int price;
    private int stock;
    private int saleCount; // 판매량
    private String category;
    private String regDate;

    private List<ColorDTO> colorList;
    private List<SizeDTO> sizeList;
    private List<TextureDTO> textureList;
    
    
    public List<ColorDTO> getColorList() {
        return colorList;
    }

    public void setColorList(List<ColorDTO> colorList) {
        this.colorList = colorList;
    }

    public List<SizeDTO> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<SizeDTO> sizeList) {
        this.sizeList = sizeList;
    }

    public List<TextureDTO> getTextureList() {
        return textureList;
    }

    public void setTextureList(List<TextureDTO> textureList) {
        this.textureList = textureList;
    }

    public FurnitureDTO() {}

    public FurnitureDTO(int furnitureSeq, String furnitureNumber, String furnitureName, String furnitureDescription, int price, int stock, int saleCount, String category, String regDate) {
        this.furnitureSeq = furnitureSeq;
        this.furnitureNumber = furnitureNumber;
        this.furnitureName = furnitureName;
        this.furnitureDescription = furnitureDescription;
        this.price = price;
        this.stock = stock;
        this.saleCount = saleCount;
        this.category = category;
        this.regDate = regDate;
    }

    public int getFurnitureSeq() {
        return furnitureSeq;
    }

    public void setFurnitureSeq(int furnitureSeq) {
        this.furnitureSeq = furnitureSeq;
    }

    public String getFurnitureNumber() {
        return furnitureNumber;
    }

    public void setFurnitureNumber(String furnitureNumber) {
        this.furnitureNumber = furnitureNumber;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public String getFurnitureDescription() {
        return furnitureDescription;
    }

    public void setFurnitureDescription(String furnitureDescription) {
        this.furnitureDescription = furnitureDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

}
