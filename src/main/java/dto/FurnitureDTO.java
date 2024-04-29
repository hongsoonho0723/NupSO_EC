package dto;

import java.util.ArrayList;
import java.util.List;

public class FurnitureDTO {
    private int furnitureSeq;
    private String furnitureNumber;
    private String furnitureName;
    private String furnitureDescription;
    private String furnitureImgSrc;
    private int price;
    private int stock;
    private int saleCount; // 판매량
    private String category;
    private String texture;
    private String regDate;
    
    private int flag;


   
    //상품 상세페이지에서 사용될 변수
    private List<ImgDTO> imgList = new ArrayList<ImgDTO>();
    private List<ImgDTO> imgDetailList = new ArrayList<ImgDTO>();
    private List<ColorDTO> colorList = new ArrayList<ColorDTO>();
    private List<SizeDTO> sizeList = new ArrayList<SizeDTO>();
    private List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
    private List<QnADTO> qnaList = new ArrayList<QnADTO>();
    
    
    public FurnitureDTO() {};
    
    public FurnitureDTO(int furnitureSeq, String furnitureNumber, String furnitureName, 
    		String furnitureDescription,
    		int price, int stock,  String category,int saleCount, String regDate) {
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
    
	
	// 상품 Create 생성자
	public FurnitureDTO(String furnitureNumber, String furnitureName, String furnitureDescription, int price, int stock, String category, String texture, String furnitureImgSrc) {
        this.furnitureNumber = furnitureNumber;
        this.furnitureName = furnitureName;
        this.furnitureDescription = furnitureDescription;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.texture = texture;
        this.furnitureImgSrc = furnitureImgSrc;
    }



	
	public FurnitureDTO(int furnitureSeq, String furnitureNumber, String furnitureName, String furnitureDescription,
			String furnitureImgSrc, int price, int stock, int saleCount, String category, String texture,
			String regDate, int flag) {
		this(furnitureSeq, furnitureNumber, furnitureName, furnitureDescription, furnitureImgSrc, price, stock, saleCount, category, texture, regDate);
		this.flag = flag;
	}

	
    
	//장바구니에서 필요
	public FurnitureDTO( String furnitureName, String furnitureImgSrc, int price, String texture) {
		super();
		this.furnitureName = furnitureName;
		this.furnitureImgSrc = furnitureImgSrc;
		this.price = price;
		this.texture = texture;

	}

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
	    
		public FurnitureDTO(int furnitureSeq, String furnitureNumber, String furnitureName, String furnitureDescription,
				String furnitureImgSrc, int price, int stock, int saleCount, String category, String texture,
				String regDate) {
			this(furnitureSeq, furnitureNumber, furnitureName, furnitureDescription, price, stock, saleCount, category, regDate);
			this.furnitureImgSrc = furnitureImgSrc;
		}


	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}

	public List<QnADTO> getQnaList() {
		return qnaList;
	}

	public void setQnaList(List<QnADTO> qnaList) {
		this.qnaList = qnaList;
	}

	public List<ImgDTO> getImgDetailList() {
		return imgDetailList;
	}

	public void setImgDetailList(List<ImgDTO> imgDetailList) {
		this.imgDetailList = imgDetailList;
	}

	public String getFurnitureImgSrc() {
		return furnitureImgSrc;
	}

	public void setFurnitureImgSrc(String furnitureImgSrc) {
		this.furnitureImgSrc = furnitureImgSrc;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public List<ImgDTO> getImgList() {
		return imgList;
	}

	public void setImgList(List<ImgDTO> imgList) {
		this.imgList = imgList;
	}


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

	@Override
	public String toString() {
		return "FurnitureDTO [furnitureSeq=" + furnitureSeq + ", furnitureNumber=" + furnitureNumber
				+ ", furnitureName=" + furnitureName + ", furnitureDescription=" + furnitureDescription
				+ ", furnitureImgSrc=" + furnitureImgSrc + ", price=" + price + ", stock=" + stock + ", saleCount="
				+ saleCount + ", category=" + category + ", texture=" + texture + ", regDate=" + regDate + "]";
	}

    
    
}
