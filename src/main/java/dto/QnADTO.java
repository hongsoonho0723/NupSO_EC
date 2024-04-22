package dto;

public class QnADTO {
	private int qnASeq;
	private int furnitureSeq;
	private String question;
	private String answer;
	private String state;
	private String answerDate;
	private String regDate;
	private String name;
	private String password;
	
	//QnA 입력시 가구 dto 생성하기 qna개수 셀 때 필요한 변수
	FurnitureDTO furniture = new FurnitureDTO();
	int qnaCount;
	
	public QnADTO(int qnASeq, int furnitureSeq, String question, String answer, String state, String answerDate,
			String regDate, String name, String password) {
		this.qnASeq = qnASeq;
		this.furnitureSeq = furnitureSeq;
		this.question = question;
		this.answer = answer;
		this.state = state;
		this.answerDate = answerDate;
		this.regDate = regDate;
		this.name = name;
		this.password = password;
	}


	public QnADTO() {
	}


	public int getQnaCount() {
		return qnaCount;
	}


	public void setQnaCount(int qnaCount) {
		this.qnaCount = qnaCount;
	}


	public FurnitureDTO getFurniture() {
		return furniture;
	}


	public void setFurniture(FurnitureDTO furniture) {
		this.furniture = furniture;
	}

	public int getQnASeq() {
		return qnASeq;
	}


	public void setQnASeq(int qnASeq) {
		this.qnASeq = qnASeq;
	}


	public int getFurnitureSeq() {
		return furnitureSeq;
	}


	public void setFurnitureSeq(int furnitureSeq) {
		this.furnitureSeq = furnitureSeq;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getAnswerDate() {
		return answerDate;
	}


	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "QnADTO [qnASeq=" + qnASeq + ", furnitureSeq=" + furnitureSeq + ", question=" + question + ", answer="
				+ answer + ", state=" + state + ", answerDate=" + answerDate + ", regDate=" + regDate + ", name=" + name
				+ ", password=" + password + ", furniture=" + furniture + "]";
	}
	
	
}
