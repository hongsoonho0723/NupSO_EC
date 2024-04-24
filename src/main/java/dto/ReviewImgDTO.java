package dto;

import java.util.List;

public class ReviewImgDTO {

	private int imgSeq;
	private int reviewSeq;
	private String imgSrc;
	private String imgType;
	private String regDate;
	
	//상세페이지에 사용될 변수
	
	public ReviewImgDTO() {}

	public ReviewImgDTO(int imgSeq, int reviewSeq, String imgSrc, String imgType, String regDate) {
		super();
		this.imgSeq = imgSeq;
		this.reviewSeq = reviewSeq;
		this.imgSrc = imgSrc;
		this.imgType = imgType;
		this.regDate = regDate;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	
	
}
