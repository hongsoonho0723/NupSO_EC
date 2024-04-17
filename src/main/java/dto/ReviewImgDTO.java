package dto;

public class ReviewImgDTO {

	private int imgSeq;
	private int reviewSeq;
	private String imgSrc01;
	private String imgSrc02;
	private String imgSrc03;
	private String imgType;
	
	
	
	public ReviewImgDTO() {}
	
	public ReviewImgDTO(int imgSeq, int reviewSeq) {
		this.imgSeq = imgSeq;
		this.reviewSeq = reviewSeq;
	}

	public ReviewImgDTO(int imgSeq, int reviewSeq, String imgSrc01, String imgType) {
		this(imgSeq, reviewSeq);
		this.imgSrc01 = imgSrc01;
		this.imgType = imgType;
	}

	
	public ReviewImgDTO(int imgSeq, int reviewSeq, String imgSrc01, String imgSrc02, String imgType) {
		this(imgSeq, reviewSeq, imgSrc01, imgType);
		this.imgSrc02 = imgSrc02;
	}

	public ReviewImgDTO(int imgSeq, int reviewSeq, String imgSrc01, String imgSrc02, String imgSrc03, String imgType) {
		this(imgSeq, reviewSeq, imgSrc01, imgSrc02, imgType);
		this.imgSrc03 = imgSrc03;
	}

	public int getImgSeq() {
		return imgSeq;
	}

	public void setImgSeq(int imgSeq) {
		this.imgSeq = imgSeq;
	}

	public int getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
	}

	public String getImgSrc01() {
		return imgSrc01;
	}

	public void setImgSrc01(String imgSrc01) {
		this.imgSrc01 = imgSrc01;
	}

	public String getImgSrc02() {
		return imgSrc02;
	}

	public void setImgSrc02(String imgSrc02) {
		this.imgSrc02 = imgSrc02;
	}

	public String getImgSrc03() {
		return imgSrc03;
	}

	public void setImgSrc03(String imgSrc03) {
		this.imgSrc03 = imgSrc03;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	
}
