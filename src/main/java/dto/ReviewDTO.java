package dto;

public class ReviewDTO {

	private int reviewSeq;
	private int userSeq;
	private int furnitureSeq;
	private String review;
	private int score;
	private String regDate;
	
	public ReviewDTO() {}
	public ReviewDTO(int reviewSeq, int userSeq, int furnitureSeq, String review, int score, String regDate) {
		this.reviewSeq = reviewSeq;
		this.userSeq = userSeq;
		this.furnitureSeq = furnitureSeq;
		this.review = review;
		this.score = score;
		this.regDate = regDate;
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
	
	
}
