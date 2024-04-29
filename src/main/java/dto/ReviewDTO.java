package dto;

import java.util.List;

public class ReviewDTO {

	private int reviewSeq;
	private int userSeq;
	private int furnitureSeq;
	private String review;
	private int score;
	private String regDate;
	
	UsersDTO user = new UsersDTO();
	FurnitureDTO furniture = new FurnitureDTO();
	private int count; // 리뷰 개수 사용할때 쓰는 변수 칼럼x
	
	private List<ReviewImgDTO> reviewImgs;

	public List<ReviewImgDTO> getReviewImgs() {
		return reviewImgs;
	}

	public void setReviewImgs(List<ReviewImgDTO> reviewImgs) {
		this.reviewImgs = reviewImgs;
	}

	public ReviewDTO() {}
	public ReviewDTO(int reviewSeq, int userSeq, int furnitureSeq, String review, int score, String regDate) {
		this.reviewSeq = reviewSeq;
		this.userSeq = userSeq;
		this.furnitureSeq = furnitureSeq;
		this.review = review;
		this.score = score;
		this.regDate = regDate;
	}



	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UsersDTO getUser() {
		return user;
	}

	public void setUser(UsersDTO user) {
		this.user = user;
	}

	public FurnitureDTO getFurniture() {
		return furniture;
	}

	public void setFurniture(FurnitureDTO furniture) {
		this.furniture = furniture;
	}

	public int getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getFurnitureSeq() {
		return furnitureSeq;
	}

	public void setFurnitureSeq(int furnitureSeq) {
		this.furnitureSeq = furnitureSeq;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ReviewDTO [reviewSeq=" + reviewSeq + ", userSeq=" + userSeq + ", furnitureSeq=" + furnitureSeq
				+ ", review=" + review + ", score=" + score + ", regDate=" + regDate + ", user=" + user + ", furniture="
				+ furniture + ", count=" + count + ", reviewImgs=" + reviewImgs + "]";
	}
	
	
}
